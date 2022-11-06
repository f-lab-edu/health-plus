package org.healthplus.user.infrastructure.security.jwt.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class StringToBase64CodeUtil {

  public static String generate(String inputString) {
    return Base64.getEncoder().encodeToString(inputString.getBytes(StandardCharsets.UTF_8));
  }

}
