package org.healthplus.user.domain.dto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class TokenPayloadDto {

  private String id;
  private String name;
  private String email;

  private LocalDateTime expired = LocalDateTime.now();

  public TokenPayloadDto(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public TokenPayloadDto toPayload(String id, String name, String email) {
    return new TokenPayloadDto(id, name, email);
  }
}
