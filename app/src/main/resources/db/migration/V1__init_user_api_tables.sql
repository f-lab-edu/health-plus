DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `user_id`      bigint(20) NOT NULL AUTO_INCREMENT COMMENT '회원 PK',
    `password`     varchar(100) NOT NULL DEFAULT '' COMMENT '암호',
    `nick`         varchar(50)  NOT NULL DEFAULT '' COMMENT '닉네임',
    `email`        varchar(50)  NOT NULL DEFAULT '' COMMENT '이메일',
    `phone_number` varchar(11)  NOT NULL DEFAULT '' COMMENT '휴대폰 번호',
    `roles`        JSON                  DEFAULT NULL COMMENT '회원역할',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `refresh_token`;
CREATE TABLE `refresh_token`
(
    `token_id`   bigint(20) NOT NULL AUTO_INCREMENT COMMENT '토큰 PK',
    `user_id`    bigint(20) NOT NULL DEFAULT 0 COMMENT '회원 PK',
    `token`      varchar(50) NOT NULL DEFAULT '' COMMENT '토큰',
    `expired_dt` datetime             DEFAULT NULL COMMENT '토큰 만기일자',
    PRIMARY KEY (`token_id`),
    KEY          `FK_user_TO_refresh_token` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
