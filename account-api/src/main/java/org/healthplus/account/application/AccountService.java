package org.healthplus.account.application;

import lombok.extern.slf4j.Slf4j;
import org.healthplus.account.application.command.SignupCommand;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountService {

  public void register(SignupCommand toCommand) {
    log.info("AccountService works well");
  }
}
