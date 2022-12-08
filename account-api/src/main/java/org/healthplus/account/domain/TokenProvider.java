package org.healthplus.account.domain;

public interface TokenProvider {

  void generateAccessToken(Long userId, String email);

}
