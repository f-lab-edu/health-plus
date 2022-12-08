package org.healthplus.account.infrastructure.jwt;

import org.healthplus.account.domain.dto.TokenPayloadDto;

/*
 * header, payload, signature class를 갖고 token을 만들어 return합니다.
 * */
public class TokenProvider {

  private Header header;
  private Payload payload;
  private Signature signature;

  private TokenProvider(TokenPayloadDto tokenPayloadDto) {
    this.header = Header.from("HS256", "JWT");
    this.payload = Payload.of(tokenPayloadDto);
    this.signature = new Signature();
  }

  public static TokenProvider from(TokenPayloadDto tokenPayloadDto) {
    return new TokenProvider(tokenPayloadDto);
  }

  public String generate() {
    header.headerEncodingProcess();
    payload.payloadEncodingProcess();
    return null;
  }
}
