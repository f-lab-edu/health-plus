package org.healthplus.account.infrastructure.jwt;

public class Signature {

  private final static String SECRET_KEY = "HealthPlusTokenKey";
  private String EncodedHeader;
  private String EncodedPayload;

  private Signature(String encodedHeader, String encodedPayload) {
    EncodedHeader = encodedHeader;
    EncodedPayload = encodedPayload;
  }

  public static Signature of(String header, String payload) {
    return new Signature(header, payload);
  }
}
