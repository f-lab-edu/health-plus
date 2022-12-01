package org.healthplus.shop.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Builder
public class Business {

  private String businessName;
  private String businessNumber;
  private String businessHour;
  private String mainType;
  private String subType;

}
