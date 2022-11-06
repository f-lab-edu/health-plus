package org.healthplus.user.infrastructure.security.jwt.wrapper;

import static org.healthplus.user.infrastructure.exception.ErrorCode.JWT_ALGORITHM_NAME_EXCEPTION;
import static org.healthplus.user.infrastructure.exception.ErrorCode.TOKEN_TYPE_NAME_EXCEPTION;

import org.healthplus.user.infrastructure.exception.JwtException;
import org.healthplus.user.infrastructure.security.jwt.enums.HeaderType;
import org.healthplus.user.infrastructure.security.jwt.enums.SignatureAlgorithm;

public class TokenHeader {

  private SignatureAlgorithm algo;
  private HeaderType type;

  private TokenHeader(String algo, String type) {

    isJwtAlgo(algo);
    isJwtTokenType(type);

    this.algo = SignatureAlgorithm.valueOf(algo);
    this.type = HeaderType.valueOf(type);
  }

  public static TokenHeader of(String algo, String type) {
    return new TokenHeader(algo, type);
  }

  public SignatureAlgorithm currentAlgo() {
    return algo;
  }

  public TokenHeader currentTokenHeader() {
    return this;
  }

  private void isJwtTokenType(String type) {
    for (HeaderType header : HeaderType.values()) {
      if (header.name() != type) {
        throw new JwtException(TOKEN_TYPE_NAME_EXCEPTION);
      }
    }
  }

  private void isJwtAlgo(String algo) {
    for (SignatureAlgorithm algorithm : SignatureAlgorithm.values()) {
      if (algorithm.name() != algo) {
        throw new JwtException(JWT_ALGORITHM_NAME_EXCEPTION);
      }
    }
  }
}
