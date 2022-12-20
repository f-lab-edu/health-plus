package org.healthplus.account.infrastructure.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.healthplus.account.domain.Authorization;
import org.springframework.web.servlet.HandlerInterceptor;

/*
* Application Account 인가를 위한 Class
* */
@RequiredArgsConstructor
public class AccountAuthorizationInterceptor implements HandlerInterceptor {

  private final Authorization authorization;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }
}
