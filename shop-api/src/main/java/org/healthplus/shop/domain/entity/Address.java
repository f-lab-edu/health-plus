package org.healthplus.shop.domain.entity;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

  private String city;
  private String street;
  private String zipCode;

  public Address(String city, String street, String zipCode) {
    this.city = city;
    this.street = street;
    this.zipCode = zipCode;
  }
}
