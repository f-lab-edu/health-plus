DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
    `customer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '구매자 PK',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '회원 PK',
    `nick` varchar(50) NOT NULL DEFAULT '' COMMENT '닉네임',
    `email` varchar(50) NOT NULL DEFAULT '' COMMENT '이메일',
    `phone_number` varchar(11) NOT NULL DEFAULT '' COMMENT '휴대폰 번호',
    `password` varchar(100) NOT NULL DEFAULT '' COMMENT '암호',
    `create_dt` datetime DEFAULT NULL COMMENT '가입일',
    `modify_dt` datetime DEFAULT NULL COMMENT '수정일자',
    `delete_dt` datetime DEFAULT NULL COMMENT '삭제일자',
    `use_yn` char(1) DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`customer_id`),
    UNIQUE KEY `nick` (`nick`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `phone_number` (`phone_number`),
    KEY `FK_user_TO_customer` (`user_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
    `cart_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '장바구니 PK',
    `customer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '구매자 PK',
    `menu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '메뉴 PK',
    `name` varchar(50) NOT NULL DEFAULT '' COMMENT '메뉴명',
    `price` int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 가격',
    `desc` varchar(100) NOT NULL DEFAULT '' COMMENT '메뉴 설명 (옵션명)',
    `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 수량',
    `create_dt` datetime DEFAULT NULL COMMENT '생성일자',
    PRIMARY KEY (`cart_id`),
    KEY `FK_customer_TO_cart` (`customer_id`),
    KEY `FK_menu_TO_cart` (`menu_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
    `address_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '주소 PK',
    `customer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '구매자 PK',
    `city` varchar(50) NOT NULL DEFAULT '' COMMENT '시/군/구',
    `street` varchar(50) NOT NULL DEFAULT '' COMMENT '동/내/읍',
    `zip_code` varchar(6) DEFAULT NULL COMMENT '우편번호',
    `basic_yn` char(1) DEFAULT 'N' COMMENT '기본 주소 여부',
    PRIMARY KEY (`address_id`),
    KEY `FK_customer_TO_address` (`customer_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `customer_alarm`;
CREATE TABLE `customer_alarm` (
    `alarm_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '구매자 알람 PK',
    `customer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '구매자 PK',
    `content` varchar(100) NOT NULL DEFAULT '' COMMENT '알람 내용',
    `url` varchar(50) DEFAULT NULL COMMENT '알람 URL',
    `create_dt` datetime DEFAULT NULL COMMENT '알람 생성일자',
    `read_dt` datetime DEFAULT NULL COMMENT '알람 확인일자',
    PRIMARY KEY (`alarm_id`),
    KEY `FK_customer_TO_customer_alarm` (`customer_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
