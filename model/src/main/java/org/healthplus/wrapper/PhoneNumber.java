package org.healthplus.wrapper;

public class PhoneNumber {

    private String phoneNumber;

    private PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static PhoneNumber from(String phoneNumber) {
        return new PhoneNumber(phoneNumber);
    }
}
