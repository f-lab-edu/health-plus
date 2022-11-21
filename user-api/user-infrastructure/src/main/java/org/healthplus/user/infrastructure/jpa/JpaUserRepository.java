package org.healthplus.user.infrastructure.jpa;

import org.healthplus.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long> {

}
