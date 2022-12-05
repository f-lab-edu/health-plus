package org.healthplus.account.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.model.role.Role;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationCommand {

  private Long userId;
  private String email;
  private Role role;

}
