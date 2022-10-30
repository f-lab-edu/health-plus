package org.healthplus.application;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.healthplus.domain.PasswordEncryption;
import org.healthplus.domain.UserRepository;
import org.healthplus.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncryption passwordEncryption;

  public void signUp(String id, String name, String email, String password, String phoneNumber) {
    String encryptedPW = passwordEncryption.encryptor(password);
    User user = new User(id, name, email, encryptedPW, phoneNumber, LocalDateTime.now());
    userRepository.save(user);
  }
}
