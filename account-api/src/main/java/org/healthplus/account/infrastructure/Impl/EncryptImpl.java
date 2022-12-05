package org.healthplus.account.infrastructure.Impl;

import org.healthplus.account.domain.repository.EncryptMapper;
import org.mindrot.jbcrypt.BCrypt;

public class EncryptImpl implements EncryptMapper {

  @Override
  public String encoder(String plainText) {
    return BCrypt.hashpw(plainText, BCrypt.gensalt());
  }

  @Override
  public boolean isMatch(String Password, String hashed) {
    return BCrypt.checkpw(Password, hashed);
  }

}
