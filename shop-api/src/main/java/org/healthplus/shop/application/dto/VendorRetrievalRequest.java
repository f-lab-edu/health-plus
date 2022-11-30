package org.healthplus.shop.application.dto;

import lombok.Getter;

@Getter
public class VendorRetrievalRequest {

  private Long vendorId;
  private String nickName;
  private String email;
  private String phoneNumber;
  private String name;
  private String bank;
  private String accountNumber;
  private String password;
  private Long userId;

}