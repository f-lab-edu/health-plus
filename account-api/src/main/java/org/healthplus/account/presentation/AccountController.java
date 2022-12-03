package org.healthplus.account.presentation;

import java.util.List;
import org.healthplus.account.application.AccountService;
import org.healthplus.account.presentation.request.UserSignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/user/")
public class AccountController {

  private final AccountService accountService;

  @Autowired
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/register")
  public List<String> register(@RequestBody UserSignUpRequest request) {
    accountService.signup(request.toCommand());
    return List.of("lee", "choi");
  }
}
