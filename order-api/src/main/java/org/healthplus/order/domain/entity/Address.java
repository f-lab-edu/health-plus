package org.healthplus.order.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@AllArgsConstructor
public class Address {

  private String city;
  private String street;
  private String zipCode;
}
