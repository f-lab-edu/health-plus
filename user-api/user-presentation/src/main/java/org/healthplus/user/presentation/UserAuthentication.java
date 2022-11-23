package org.healthplus.user.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.user.application.UserService;
import org.healthplus.user.presentation.request.UserLoginRequest;
import org.healthplus.user.presentation.request.UserRegisterRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserAuthentication {

  private final UserService userService;

  /*
  * 회원 가입
  * */
  @PostMapping("/api/auth/user/register")
  public void register(UserRegisterRequest registerRequest) {
    userService.signUp(registerRequest.getEmail(), registerRequest.getName(),
        registerRequest.getEmail(),
        registerRequest.getPassword(), registerRequest.getPhoneNumber());
  }


  /*
   * 회원 가입 확인
   * */
  @GetMapping("/api/auth/user/confirm")
  public void registerConfirm() {

  }

  /*
   * 회원 로그인
   * */
  @PostMapping("/api/auth/user/login")
  public void login(UserLoginRequest loginRequest) {
    userService.login(loginRequest.getId(), loginRequest.getPassword());
  }

  /*
  * refreshToken 재발급
  * */
  @PostMapping("/api/auth/user/reIssuance")
  public void reIssuance() {

  }
}
