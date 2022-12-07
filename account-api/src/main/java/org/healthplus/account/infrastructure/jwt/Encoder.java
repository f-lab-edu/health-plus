package org.healthplus.account.infrastructure.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encoder {

  public static String run(String givenJsonString) {
    return Base64.getUrlEncoder().withoutPadding()
        .encodeToString(givenJsonString.getBytes(StandardCharsets.UTF_8));
  }

}
