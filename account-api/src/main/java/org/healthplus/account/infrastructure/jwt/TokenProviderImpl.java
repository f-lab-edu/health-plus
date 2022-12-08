package org.healthplus.account.infrastructure.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.healthplus.account.domain.TokenProvider;

public class TokenProviderImpl implements TokenProvider {


  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void generateAccessToken(Long userId, String email) {

  }
}
