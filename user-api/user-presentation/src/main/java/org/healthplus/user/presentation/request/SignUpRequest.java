package org.healthplus.user.presentation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequest {

  private String email;

  private String name;

  private String password;

  private String phoneNumber;
}
