package org.healthplus.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.application.UserService;
import org.healthplus.presentation.request.UserRegisterRequest;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserAuthentication implements UserAuthenticationSpecification {

  private final UserService userService;

  @Override
  public void register(UserRegisterRequest request) {
    userService.signUp(request.getId(), request.getName(), request.getEmail(),
        request.getPassword(), request.getPhoneNumber());
  }

  @Override
  public void registerConfirm() {

  }

  @Override
  public void login() {

  }

  @Override
  public void reIssuance() {

  }
}
