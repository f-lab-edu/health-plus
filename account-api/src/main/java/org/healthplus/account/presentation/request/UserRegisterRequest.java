package org.healthplus.account.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.model.role.Role;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

  private String email;
  private String password;
  private String name;
  private String phoneNumber;
  private Role role;
}
