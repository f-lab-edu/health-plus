package org.healthplus.user.domain;

/*
 * password μνΈν
 * */
public interface PasswordEncryption {

  String encryptor(String password);

  boolean matchPassword(String encryptedPassword, String plainText);
}
