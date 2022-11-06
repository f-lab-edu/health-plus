package org.healthplus.user.infrastructure.security.jwt.util;

import java.util.Base64;

public class Decoder {

  public static String generate(String inputString) {
    return new String(Base64.getDecoder().decode(inputString));
  }
}
