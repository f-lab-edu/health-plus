package org.healthplus.presentation;

import org.healthplus.presentation.request.UserRegisterRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserAuthenticationSpecification {

  /*
   * 회원 가입
   * */
  @PostMapping("/api/auth/user/register")
  void register(@RequestBody UserRegisterRequest request);

  /*
   * 회원 가입 확인
   * */
  @GetMapping("/api/auth/user/confirm")
  void registerConfirm();

  /*
   * 회원 로그인
   * */
  @PostMapping("/api/auth/user/login")
  void login();

  @PostMapping("/api/auth/user/reIssuance")
  void reIssuance();

}
