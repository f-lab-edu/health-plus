package org.healthplus.user.infrastructure.security.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.healthplus.user.domain.dto.JwtPayloadDto;
import org.healthplus.user.infrastructure.security.jwt.util.StringToBase64CodeUtil;
import org.healthplus.user.infrastructure.security.jwt.wrapper.Payload;
import org.healthplus.user.infrastructure.security.jwt.wrapper.TokenHeader;

public class Token {

  private TokenHeader header;
  private Payload payload;
  private final String ServerSecreteKey = "HealthPlusProjectTokenKey";

  private Token(String algo, String type, JwtPayloadDto payloadString) {
    this.header = TokenHeader.of(algo, type);
    this.payload = Payload.from(payloadString);
  }

  public static Token of(JwtPayloadDto payloadString) {
    return new Token("HS256", "JWT", payloadString);
  }

  public String generate() {
    return header.tokenHeaderBase64() + "." + payload.tokenPayloadBase64() + "." +
        StringToBase64CodeUtil.generate(ServerSecreteKey);
  }
}
