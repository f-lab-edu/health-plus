package org.healthplus.user.infrastructure.security.jwt;

import org.healthplus.user.infrastructure.security.jwt.types.HeaderType;
import org.healthplus.user.infrastructure.security.jwt.types.SignatureAlgorithm;

public class TokenHeader {

    private SignatureAlgorithm algo;
    private HeaderType type;

    private TokenHeader(String algo, String type) {
        this.algo = SignatureAlgorithm.valueOf(algo);
        this.type = HeaderType.valueOf(type);
    }

    public static TokenHeader of(String algo, String type) {
        return new TokenHeader(algo, type);
    }
}
