package org.healthplus.user.domain.entity;

import lombok.RequiredArgsConstructor;
import org.healthplus.user.domain.TokenGenerator;

@RequiredArgsConstructor
public class RefreshToken {

  private final TokenGenerator tokenGenerator;

  private String refreshToken;
  private static final int REFRESH_TOKEN_EXPIRED_DAYS = 3;

}
