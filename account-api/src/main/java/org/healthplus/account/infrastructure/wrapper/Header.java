package org.healthplus.account.infrastructure.wrapper;

import lombok.Getter;

@Getter
public class Header {

  private final String alg = "HS256";
  private final String typ = "JWT";

  protected Header() {
  }

  @Override
  public String toString() {
    return "{" +
        "alg='" + alg + '\'' +
        ", typ='" + typ + '\'' +
        '}';
  }
}
