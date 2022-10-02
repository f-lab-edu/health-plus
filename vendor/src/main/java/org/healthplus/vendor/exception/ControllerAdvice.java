package org.healthplus.vendor.exception;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

  @Order(1)
  @ExceptionHandler(Exception.class)
  public void test() {

  }
}
