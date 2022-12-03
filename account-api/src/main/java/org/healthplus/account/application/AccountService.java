package org.healthplus.account.application;

import lombok.extern.slf4j.Slf4j;
import org.healthplus.account.application.command.SignupCommand;
import org.healthplus.account.application.result.AccountResult;
import org.healthplus.account.domain.entity.User;
import org.healthplus.account.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountService {

  private final UserRepository userRepository;
  @Autowired
  public AccountService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public AccountResult signup(SignupCommand signupCommand) {
    log.info("AccountService works well");
    User signupUser = new User(
        signupCommand.getName(),
        signupCommand.getPassword(),
        signupCommand.getEmail(),
        signupCommand.getPhoneNumber(),
        signupCommand.getRole()
    );
    User user = userRepository.save(signupUser);
    return AccountResult.fromUser(user);
  }
}
