package org.healthplus.user.domain.dto;

import lombok.Getter;

@Getter
public class JwtPayloadDto {

  private String id;
  private String name;
  private String email;

  public JwtPayloadDto(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public JwtPayloadDto toPayload(String id, String name, String email) {
    return new JwtPayloadDto(id, name, email);
  }
}
