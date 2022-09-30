package org.healthplus.wrapper;

public class Email {

    private String email;

    private Email(String email) {
        this.email = email;
    }

    public Email from(String email) {
        return new Email(email);
    }

}
