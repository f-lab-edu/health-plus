package org.healthplus.account.domain.exception;

public class UserIdDuplicationException extends IllegalArgumentException {

  public UserIdDuplicationException() {
    super();
  }

  public UserIdDuplicationException(String s) {
    super(s);
  }
}
