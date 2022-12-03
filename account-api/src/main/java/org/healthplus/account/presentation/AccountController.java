package org.healthplus.account.presentation;

import java.util.List;
import org.healthplus.account.presentation.request.UserRegisterRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/user/")
public class AccountController {

  @PostMapping("/register")
  public List<String> register(@RequestBody UserRegisterRequest request) {
    return List.of("lee", "choi");
  }
}
