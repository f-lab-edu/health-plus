package org.healthplus.user.infrastructure.security.jwt.wrapper;

import org.healthplus.user.infrastructure.security.jwt.enums.HeaderType;
import org.healthplus.user.infrastructure.security.jwt.enums.SignatureAlgorithm;

public class TokenHeader {

  private SignatureAlgorithm algo;
  private HeaderType type;

  private TokenHeader(String algo, String type) {
    this.algo = SignatureAlgorithm.valueOf(algo);
    this.type = HeaderType.valueOf(type);
  }

  public static TokenHeader of(String algo, String type) {
    return new TokenHeader(algo, type);
  }
}
