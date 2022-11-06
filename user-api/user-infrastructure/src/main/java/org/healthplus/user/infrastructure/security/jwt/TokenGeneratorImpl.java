package org.healthplus.user.infrastructure.security.jwt;

import org.healthplus.user.domain.TokenGenerator;
import org.healthplus.user.domain.dto.JwtPayloadDto;

public class TokenGeneratorImpl implements TokenGenerator {

  private Token token;
  @Override
  public String generate(JwtPayloadDto jwtPayloadDto){
    token = Token.of(jwtPayloadDto);
    return token.generate();
  }
}
