package org.healthplus.account.domain;

import org.healthplus.account.domain.dto.TokenPayloadDto;

public interface TokenGenerator {

  String generateAccessToken(TokenPayloadDto tokenPayloadDto);

}
