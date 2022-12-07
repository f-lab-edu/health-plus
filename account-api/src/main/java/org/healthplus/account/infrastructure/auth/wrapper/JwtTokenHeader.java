package org.healthplus.account.infrastructure.auth.wrapper;

import lombok.Getter;

@Getter
public class JwtTokenHeader {

  private final String alg = "HS256";
  private final String typ = "JWT";

  protected JwtTokenHeader() {
  }
}
