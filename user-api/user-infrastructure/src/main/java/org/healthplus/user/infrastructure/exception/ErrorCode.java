package org.healthplus.user.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ErrorCode {

  private final HttpStatus httpStatus;
  private final String message;
}
