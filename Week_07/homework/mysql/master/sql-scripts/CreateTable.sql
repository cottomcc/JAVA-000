DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(64) NOT NULL COMMENT '主键id 用户id',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称',
  `realname` varchar(128) DEFAULT NULL COMMENT '真实姓名',
  `face` varchar(1024) NOT NULL COMMENT '头像',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱地址',
  `sex` int(11) DEFAULT NULL COMMENT '性别 性别 1:男  0:女  2:保密',
  `birthday` date DEFAULT NULL COMMENT '生日 生日',
  `created_at` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间 创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间 更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` varchar(64) NOT NULL COMMENT '商品主键id',
  `name` varchar(32) NOT NULL COMMENT '商品名称',
  `on_off_status` int(11) NOT NULL COMMENT '上下架状态 上下架状态,1:上架 2:下架',
  `content` text NOT NULL COMMENT '商品内容',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

DROP TABLE IF EXISTS `product_spec`;
CREATE TABLE `product_spec` (
  `id` varchar(64) NOT NULL COMMENT '商品规格id',
  `product_id` varchar(64) NOT NULL COMMENT '商品外键id',
  `name` varchar(32) NOT NULL COMMENT '规格名称',
  `stock` int(11) NOT NULL COMMENT '库存',
  `discounts` decimal(4,2) NOT NULL COMMENT '折扣力度',
  `price_discount` int(11) NOT NULL COMMENT '优惠价',
  `price_normal` int(11) NOT NULL COMMENT '原价',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品规格';


DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(64) NOT NULL COMMENT '订单主键;同时也是订单编号',
  `user_id` varchar(64) NOT NULL COMMENT '用户id',
  `receiver_name` varchar(32) NOT NULL COMMENT '收货人快照',
  `receiver_mobile` varchar(32) NOT NULL COMMENT '收货人手机号快照',
  `receiver_address` varchar(128) NOT NULL COMMENT '收货地址快照',
  `total_amount` int(11) NOT NULL COMMENT '订单总价格',
  `real_pay_amount` int(11) NOT NULL COMMENT '实际支付总价格',
  `post_amount` int(11) NOT NULL COMMENT '邮费;默认可以为零，代表包邮',
  `pay_method` int(11) NOT NULL COMMENT '支付方式',
  `left_msg` varchar(128) DEFAULT NULL COMMENT '买家留言',
  `extand` varchar(32) DEFAULT NULL COMMENT '扩展字段',
  `is_comment` int(11) NOT NULL COMMENT '买家是否评价;1：已评价，0：未评价',
  `is_delete` int(11) NOT NULL COMMENT '逻辑删除状态;1: 删除 0:未删除',
  `created_at` datetime NOT NULL COMMENT '创建时间（成交时间）',
  `updated_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表;';


DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `order_id` varchar(64) NOT NULL COMMENT '归属订单id',
  `product_id` varchar(64) NOT NULL COMMENT '商品id',
  `product_spec_id` varchar(32) NOT NULL COMMENT '规格id',
  `price` int(11) NOT NULL COMMENT '成交价格',
  `buy_counts` int(11) NOT NULL COMMENT '购买数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单商品关联表';
