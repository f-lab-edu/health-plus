package org.healthplus.account.infrastructure.jwt;

public class Signature {

  private final static String SECRET_KEY = "HealthPlusTokenKey";
  private Header header;
  private PayLoad payLoad;

  public Signature(Header header, PayLoad payLoad) {
    this.header = header;
    this.payLoad = payLoad;
  }
}
