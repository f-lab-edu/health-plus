package org.healthplus.exception;

public class ApplicationUserNameException extends IllegalArgumentException {


    public ApplicationUserNameException() {
    }

    public ApplicationUserNameException(String s) {
        super(s);
    }
}
