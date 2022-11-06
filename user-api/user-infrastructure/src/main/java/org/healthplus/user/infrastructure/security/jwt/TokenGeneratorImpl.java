package org.healthplus.user.infrastructure.security.jwt;

import org.healthplus.user.domain.TokenGenerator;
import org.healthplus.user.domain.dto.TokenPayloadDto;

public class TokenGeneratorImpl implements TokenGenerator {
  @Override
  public String generate(TokenPayloadDto payloadDto){
    return Token.of(payloadDto).generate();
  }
}
