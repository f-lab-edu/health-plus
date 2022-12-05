package org.healthplus.account.infrastructure.auth.Impl;

import org.healthplus.account.domain.AuthorizationMapper;
import org.healthplus.model.role.Role;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationMapperImpl implements AuthorizationMapper {

  @Override
  public String login(Long userId, String email, Role userRole) {
    return null;
  }
}
