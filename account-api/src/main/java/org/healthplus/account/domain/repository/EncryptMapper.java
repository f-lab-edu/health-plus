package org.healthplus.account.domain.repository;

public interface EncryptMapper {

  String encoder(String plainText);

  boolean isMatch(String password, String hashed);

}
