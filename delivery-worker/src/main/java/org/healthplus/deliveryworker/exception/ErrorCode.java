package org.healthplus.deliveryworker.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  INVALID_DELIVERY_WORKER(HttpStatus.NOT_FOUND, "존재하지 않는 배달 노동자입니다.");

  private final HttpStatus httpStatus;
  private final String message;
}
