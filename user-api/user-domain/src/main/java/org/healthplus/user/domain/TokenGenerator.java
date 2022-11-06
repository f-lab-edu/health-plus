package org.healthplus.user.domain;

import org.healthplus.user.domain.dto.JwtPayloadDto;

public interface TokenGenerator {

    String generate(JwtPayloadDto jwtPayloadDto);

}
