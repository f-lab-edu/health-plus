package org.healthplus.user.infrastructure.security.jwt.wrapper;

import org.healthplus.user.domain.dto.JwtPayloadDto;

public class Payload {

  private JwtPayloadDto payloadDto;

  private Payload(JwtPayloadDto payloadDto) {
    this.payloadDto = payloadDto;
  }

  public static Payload from(JwtPayloadDto payloadDto) {
    return new Payload(payloadDto);
  }

}
