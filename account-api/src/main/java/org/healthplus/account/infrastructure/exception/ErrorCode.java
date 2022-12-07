package org.healthplus.account.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

  TOKEN_SIGNATURE_ALGORITHM_EXCEPTION(HttpStatus.NOT_ACCEPTABLE, "JWT ALGORITHM 타입이 아닙니다."),
  TOKEN_HEADER_TYPE_EXCEPTION(HttpStatus.NOT_ACCEPTABLE, "JWT HEADER 타입이 아닙니다.");

  private final HttpStatus httpStatus;
  private final String message;
}
