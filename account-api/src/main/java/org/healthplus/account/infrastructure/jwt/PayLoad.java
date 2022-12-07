package org.healthplus.account.infrastructure.jwt;

import java.time.Instant;
import lombok.Getter;
import org.healthplus.model.role.Role;

@Getter
public class PayLoad {

  private Long userId;
  private String email;
  private Role role;
  private Instant currentTime;

  protected PayLoad() {
  }

  public PayLoad(Long userId, String email, Role role) {
    this.userId = userId;
    this.email = email;
    this.role = role;
    this.currentTime = Instant.now();
  }

  @Override
  public String toString() {
    return "{" +
        "userId=" + userId +
        ", email='" + email + '\'' +
        ", role=" + role +
        ", currentTime=" + currentTime +
        '}';
  }
}
