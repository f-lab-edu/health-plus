package org.healthplus.account.infrastructure.jwt;

import org.healthplus.account.domain.TokenGenerator;
import org.healthplus.account.domain.dto.TokenPayloadDto;
import org.healthplus.account.infrastructure.jwt.util.ObjectToJsonChanger;

public class TokenGeneratorImpl implements TokenGenerator {

  @Override
  public String generateAccessToken(TokenPayloadDto tokenPayloadDto) {
    return TokenProvider.from(tokenPayloadDto).generate();
  }
}
