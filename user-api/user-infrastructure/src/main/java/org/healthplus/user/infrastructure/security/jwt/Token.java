package org.healthplus.user.infrastructure.security.jwt;

import org.healthplus.user.infrastructure.security.jwt.wrapper.Payload;

public class Token {

    private TokenHeader header;
    private Payload payload;
    private final String ServerSecreteKey = "HealthPlusProjectTokenKey";

    public Token(TokenHeader header, String payload) {
        this.header = header;
    }

    public static Token of(String algo, String type, String payloadString) {
        return new Token(TokenHeader.of(algo, type), payloadString);
    }
}
