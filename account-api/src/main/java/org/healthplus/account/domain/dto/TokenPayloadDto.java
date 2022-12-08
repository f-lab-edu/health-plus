package org.healthplus.account.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.model.role.Role;

@Getter
@NoArgsConstructor
public class TokenPayloadDto {

  private Long userId;
  private String email;
  private Role role;
  // private Instant instant;

  public TokenPayloadDto(Long userId, String email, Role role) {
    this.userId = userId;
    this.email = email;
    this.role = role;
    // this.instant = Instant.now();
  }
}
