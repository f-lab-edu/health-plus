package org.healthplus.user.infrastructure.jpa;

import java.util.HashMap;
import java.util.Map;
import org.healthplus.user.domain.UserRepository;
import org.healthplus.user.domain.entity.User;
import org.springframework.stereotype.Component;

public class UserRepositoryAdapter implements UserRepository {

  private final JpaUserRepository jpaUserRepository;

  public UserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
    this.jpaUserRepository = jpaUserRepository;
  }
}
