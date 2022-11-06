package org.healthplus.user.infrastructure.security.jwt.wrapper;

import static org.healthplus.user.infrastructure.exception.ErrorCode.JWT_ALGORITHM_NAME_EXCEPTION;
import static org.healthplus.user.infrastructure.exception.ErrorCode.TOKEN_TYPE_NAME_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import org.healthplus.user.infrastructure.exception.JwtException;
import org.healthplus.user.infrastructure.security.jwt.enums.HeaderType;
import org.healthplus.user.infrastructure.security.jwt.enums.SignatureAlgorithm;

public class TokenHeader {

  private SignatureAlgorithm algo;
  private HeaderType type;

  private TokenHeader(String algo, String type) {

    isTokenAlgo(algo);
    isTokenType(type);

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

  private void isTokenType(String type) {
    List<String> checkList = new ArrayList<>();
    for (HeaderType header : HeaderType.values()) {
      checkList.add(header.name());
    }
    if (!checkList.contains(type)) {
      throw new JwtException(TOKEN_TYPE_NAME_EXCEPTION);
    }
  }

  private void isTokenAlgo(String algo) {
    List<String> checkList = new ArrayList<>();
    for (SignatureAlgorithm algorithm : SignatureAlgorithm.values()) {
      checkList.add(algorithm.name());
    }
    if (!checkList.contains(algo)) {
      throw new JwtException(JWT_ALGORITHM_NAME_EXCEPTION);
    }
  }
}
