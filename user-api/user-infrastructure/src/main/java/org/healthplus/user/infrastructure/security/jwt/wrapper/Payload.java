package org.healthplus.user.infrastructure.security.jwt.wrapper;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Payload {

  private String payloadString;

  private Payload(String payloadString) {
    this.payloadString = stringToBase64Encoder(payloadString);
  }

  public static Payload from(String payload) {
    return new Payload(payload);
  }

  private String stringToBase64Encoder(String payloadString) {
    return Base64.getEncoder().encodeToString(payloadString.getBytes(StandardCharsets.UTF_8));
  }
}
