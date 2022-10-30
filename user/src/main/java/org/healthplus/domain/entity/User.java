package org.healthplus.domain.entity;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.healthplus.model.role.Role;

@Entity
@Table(name = "user")
public class User {

  protected User() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email")
  private String email; // Email

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Column(name = "modify_dt")
  private LocalDateTime modifiedAt;

  @ElementCollection(fetch = FetchType.EAGER)
  @Column(name = "roles")
  private Set<Role> roles;

/*
  public void updateRoles() {
    this.roles.add(asd);
    this.validateRoles();
  }

  public void validateRoles() {
    this.roles.size() <= 1
  }
*/

}
