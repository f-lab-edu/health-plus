package org.healthplus.user.infrastructure.security.jwt.wrapper;

import org.healthplus.user.infrastructure.security.jwt.util.StringToBase64CodeUtil;

public class Payload {

  private String payloadString;

  private Payload(String payloadString) {
    this.payloadString = StringToBase64CodeUtil.generate(payloadString);
  }

  public static Payload from(String payload) {
    return new Payload(payload);
  }

  public String currentPayloadBase64Code() {
    return payloadString;
  }
}
