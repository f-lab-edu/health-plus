DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`
(
    `pay_id`    bigint(20) NOT NULL AUTO_INCREMENT COMMENT '결제 PK',
    `order_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '주문 PK',
    `pg`        varchar(10) NOT NULL DEFAULT '' COMMENT 'PG사',
    `content`   varchar(50) NOT NULL DEFAULT '' COMMENT '결제 내용',
    `method`    varchar(50) NOT NULL DEFAULT '' COMMENT '결제 수단',
    `amount`    int(11) NOT NULL DEFAULT 0 COMMENT '결제 가격',
    `create_dt` datetime             DEFAULT NULL COMMENT '생성일자',
    PRIMARY KEY (`pay_id`),
    KEY         `FK_order_TO_payment` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    `order_id`    bigint(20) NOT NULL AUTO_INCREMENT COMMENT '주문 PK',
    `customer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '구매자 PK',
    `vendor_id`   bigint(20) NOT NULL DEFAULT 0 COMMENT '판매자 PK',
    `rider_id`    bigint(20) NOT NULL DEFAULT 0 COMMENT '라이더 PK',
    `status`      varchar(20) NOT NULL DEFAULT '' COMMENT '주문 상태',
    `total_price` int(11) NOT NULL DEFAULT 0 COMMENT '총 가격',
    `city`        varchar(50) NOT NULL DEFAULT '' COMMENT '시/군/구',
    `street`      varchar(50) NOT NULL DEFAULT '' COMMENT '동/내/읍',
    `zip_code`    varchar(6)           DEFAULT '' COMMENT '우편번호',
    `create_dt`   datetime             DEFAULT NULL COMMENT '생성일자',
    `modify_dt`   datetime             DEFAULT NULL COMMENT '수정일자',
    PRIMARY KEY (`order_id`),
    KEY           `FK_customer_TO_order` (`customer_id`),
    KEY           `FK_vendor_TO_order` (`vendor_id`),
    KEY           `FK_rider_TO_order` (`rider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `order_lines`;
CREATE TABLE `order_lines`
(
    `order_lines_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '주문 항목 PK',
    `order_id`       bigint(20) NOT NULL DEFAULT 0 COMMENT '주문 PK',
    `menu_id`        bigint(20) NOT NULL DEFAULT 0 COMMENT '메뉴 PK',
    `name`           varchar(50) NOT NULL DEFAULT '' COMMENT '메뉴명',
    `price`          int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 가격',
    `quantity`       int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 수량',
    `create_dt`      datetime             DEFAULT NULL COMMENT '생성일자',
    PRIMARY KEY (`order_lines_id`),
    KEY              `FK_order_TO_order_lines_` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
