package org.healthplus.wrapper;

public class ZipCode {

    private String zipCode;

    private ZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public static ZipCode from(String zipCode) {
        return new ZipCode(zipCode);
    }
}
