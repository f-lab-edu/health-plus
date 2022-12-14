package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.VendorRetrievalService;
import org.healthplus.shop.domain.entity.Vendor;
import org.healthplus.shop.presentation.convertor.VendorDtoConvertor;
import org.healthplus.shop.presentation.dto.response.VendorRetrievalResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class VendorRetrievalController {

  private final VendorRetrievalService vendorRetrievalService;

  @GetMapping("/{vendorId}")
  public ApiResponse<VendorRetrievalResponse> retrieveVendor(@PathVariable Long vendorId) {

    Vendor vendor = vendorRetrievalService.retrieveVendor(vendorId);
    VendorRetrievalResponse responseData = VendorDtoConvertor.toVendorRetrievalResponse(vendor);

    return ApiResponse.success(responseData);
  }
}
