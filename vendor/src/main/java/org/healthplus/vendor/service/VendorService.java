package org.healthplus.vendor.service;

import org.healthplus.vendor.dto.*;

public interface VendorService {


  ProductInfoInquiryDTO getProduct(Long vendorId, Long productId) throws Exception;

  RestaurantInfoInquiryDTO getRestaurant(Long vendorId) throws Exception;

  String updateProduct(Long vendorId, Long productId, ProductInfoDTO productInfo) throws Exception;

  ProductInfoRegistrationResultDTO registerProductInfo(Long vendorId, ProductInfoRegistrationDTO productInfo) throws Exception;

  VendorRegistrationResultDTO registerVendor(VendorRegistrationDTO vendorInfo) throws Exception;

  VendorProfileInquiryDTO getVendorProfile(Long vendorId) throws Exception;

  String removeVendor(Long vendorId);
}
