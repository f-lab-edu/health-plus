package org.healthplus.wrapper;

import org.healthplus.exception.ApplicationUserNameException;

public class Name {

    private String name;

    private Name(String name) {
        if (isNotName(name)) {
            throw new ApplicationUserNameException();
        }
        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public void changeName(String name) {
        this.name = name;
    }

    public String currentName() {
        return this.name;
    }

    private boolean isNotName(String name) {
        return name.isBlank() == true || name.length() > 12;
    }
}
