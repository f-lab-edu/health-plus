package org.healthplus.account.infrastructure.jwt;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import lombok.Getter;
import org.healthplus.account.domain.dto.TokenPayloadDto;
import org.healthplus.account.infrastructure.jwt.util.Encoder;
import org.healthplus.account.infrastructure.jwt.util.ObjectToJsonChanger;
import org.healthplus.model.role.Role;

@Getter
public class Payload {

  private Long userId;
  private String email;
  private Role role;
  private Instant currentTime;

  private Payload() {
  }

  private Payload(Long userId, String email, Role role) {
    this.userId = userId;
    this.email = email;
    this.role = role;
    this.currentTime = Instant.now();
  }

  public static Payload of(TokenPayloadDto tokenPayloadDto) {
    return new Payload(tokenPayloadDto.getUserId(),
        tokenPayloadDto.getEmail(),
        tokenPayloadDto.getRole());
  }

  public Payload currentPayload() {
    return this;
  }

  public String payloadEncodingProcess() {
    String jsonTypePayload = ObjectToJsonChanger.changer(this);
    return Encoder.run(jsonTypePayload.getBytes(StandardCharsets.UTF_8));
  }
}
