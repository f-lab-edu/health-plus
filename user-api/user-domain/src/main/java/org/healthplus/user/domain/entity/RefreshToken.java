package org.healthplus.user.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "token")
@Getter
public class RefreshToken {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "token_id")
  private Long tokenId;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "refresh_token")
  private String token;

  /*
   * 만료 기간은 생성 시간으로 설정하고 생성 시에 token type에 따라 시간 설정
   * */
  @Column(name = "expired_date")
  private LocalDateTime expiredDate;

}
