package org.healthplus.user.infrastructure.jpa;

import org.healthplus.user.domain.UserRepository;
import org.healthplus.user.domain.entity.User;
import org.healthplus.user.infrastructure.exception.ErrorCode;
import org.healthplus.user.infrastructure.exception.UserException;

public class UserRepositoryAdapter implements UserRepository {

  private final JpaUserRepository jpaUserRepository;

  public UserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
    this.jpaUserRepository = jpaUserRepository;
  }

  @Override
  public User save(User user) {
    return jpaUserRepository.save(user);
  }

  @Override
  public User findByEmail(String email) {
    return jpaUserRepository.findByEmail(email)
        .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));
  }

  @Override
  public boolean existsByEmail(String email) {
    return jpaUserRepository.existsByEmail(email);
  }


}
