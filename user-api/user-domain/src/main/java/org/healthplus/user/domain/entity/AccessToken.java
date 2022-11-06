package org.healthplus.user.domain.entity;

import lombok.RequiredArgsConstructor;
import org.healthplus.user.domain.TokenGenerator;

@RequiredArgsConstructor
public class AccessToken {

  private final TokenGenerator tokenGenerator;

  private String accessToken;
  private static final int ACCESS_TOKEN_EXPIRED_HOUR = 1;
}
