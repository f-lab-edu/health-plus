package org.healthplus.vendor.controller;

import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.*;
import org.healthplus.vendor.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
@RequiredArgsConstructor
public class VendorController {

  private final VendorService vendorService;

  @GetMapping("/{vendorId}/{productId}/info")
  public ResponseEntity<ProductInfoInquiryDTO> getProductInfo(@PathVariable("vendorId") Long vendorId,
                                                              @PathVariable("productId") Long productId) throws Exception {

    return ResponseEntity.ok(vendorService.getProduct(vendorId, productId));
  }

  @GetMapping("/{vendorId}/info")
  public ResponseEntity<RestaurantInfoInquiryDTO> getRestaurantInfo(@PathVariable("vendorId") Long vendorId) throws Exception {

    return ResponseEntity.ok(vendorService.getRestaurant(vendorId));
  }

  @PostMapping("/{vendorId}/{productId}/order")
  public ResponseEntity<ProductOrderDTO> orderProduct(@PathVariable("vendorId") Long vendorId,
                                                      @PathVariable("productId") Long productId) {

    return ResponseEntity.ok(new ProductOrderDTO());
  }

  @PutMapping("/{vendorId}/{productId}")
  public String changeProductInfo(@PathVariable("vendorId") Long vendorId,
                                  @PathVariable("productId") Long productId,
                                  @RequestBody ProductInfoDTO productInfo) throws Exception {

    vendorService.updateProduct(vendorId, productId, productInfo);

    return null;
  }

  @PostMapping("/{vendorId}/product")
  public ResponseEntity<ProductInfoRegistrationResultDTO> addProductInfo(@PathVariable("vendorId") Long vendorId,
                                                                         @RequestBody ProductInfoRegistrationDTO productInfo) throws Exception {

    return ResponseEntity.ok(vendorService.registerProductInfo(vendorId, productInfo));
  }

  @GetMapping("/{vendorId}/profile")
  public ResponseEntity<VendorProfileInquiryDTO> getVendorProfile(@PathVariable("vendorId") Long vendorId) throws Exception {

    return ResponseEntity.ok(vendorService.getVendorProfile(vendorId));
  }

  @DeleteMapping("/{vendorId}")
  public ResponseEntity<String> removeVendorInfo(@PathVariable("vendorId") Long vendorId) throws Exception {
    return ResponseEntity.ok(vendorService.removeVendor(vendorId));
  }


}
