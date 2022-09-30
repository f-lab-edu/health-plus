package org.healthplus.wrapper;

public class Password {

    private String password;

    private Password(String password) {
        this.password = password;
    }

    public static Password from(String password) {
        return new Password(password);
    }
}
