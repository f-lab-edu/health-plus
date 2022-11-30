package org.healthplus.shop.presentation.convertor;

import org.healthplus.shop.presentation.dto.VendorModificationResponse;
import org.healthplus.shop.presentation.dto.VendorRetrievalResponse;
import org.healthplus.shop.entity.Vendor;

public class VendorResponseDataConvertor {

  public static VendorRetrievalResponse toVendorRetrievalResponse(Vendor vendor) {
    return VendorRetrievalResponse.builder()
            .vendorId(vendor.getId())
            .name(vendor.getName())
            .email(vendor.getEmail())
            .phoneNumber(vendor.getPhoneNumber())
            .bank(vendor.getBank().getBank())
            .accountNumber(vendor.getBank().getAccountNumber())
            .build();
  }

  public static VendorModificationResponse toVendorModificationResponse(Vendor vendor) {
    return VendorModificationResponse.builder()
            .vendorId(vendor.getId())
            .name(vendor.getName())
            .email(vendor.getEmail())
            .phoneNumber(vendor.getPhoneNumber())
            .nickName(vendor.getNickName())
            .build();
  }

}
