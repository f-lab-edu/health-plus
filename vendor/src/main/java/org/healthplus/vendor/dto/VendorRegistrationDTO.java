package org.healthplus.vendor.dto;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.model.entity.Address;
import org.healthplus.vendor.entity.Restaurant;
import org.healthplus.vendor.entity.Vendor;
import org.healthplus.vendor.enums.IsYn;

@Getter
@Builder
public class VendorRegistrationDTO {

  private String id;
  private String password;
  private String name;
  private String bank;
  private String accountNumber;
  private String email;
  private String phoneNumber;
  private String businessName;
  private String businessHour;
  private String businessNumber;
  private String mainType;
  private String subType;
  private Integer minimumPrice;
  private Integer deliveryFee;
  private IsYn openYn;
  private String city;
  private String street;
  private Integer zipCode;

  public Vendor toVendorEntity() {
    return Vendor.builder()
            .id(id)
            .password(password)
            .name(name)
            .bank(bank)
            .accountNumber(accountNumber)
            .email(email)
            .phoneNumber(phoneNumber)
            .build();
  }
  
  public Restaurant toRestaurantEntity() {
    return Restaurant.builder()
            .businessName(businessName)
            .businessHour(businessHour)
            .businessNumber(businessNumber)
            .mainType(mainType)
            .subType(subType)
            .minimumPrice(minimumPrice)
            .deliveryFee(deliveryFee)
            .address(new Address(city, street, zipCode))
            .openYn(openYn)
            .build();
  }
}
