use myDB;

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(12) DEFAULT '' COMMENT '名称',
  `age` int(3) unsigned DEFAULT 0 COMMENT '年龄',
  `height` decimal(3,2) unsigned DEFAULT 0.00 COMMENT '身高',
  `weight` decimal(3,2) DEFAULT 0.00 COMMENT '重量',
  `telephone` varchar(36) DEFAULT '' COMMENT '电话',
  `qq` int(10) DEFAULT 0 COMMENT 'qq',
  `create_time` varchar(36) DEFAULT '' COMMENT '创建时间',
  `user_account` varchar(36) DEFAULT '' COMMENT '帐号',
  `user_password` varchar(36) DEFAULT '' COMMENT '密码',
  `email` varchar(36) DEFAULT  '' COMMENT 'email',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='测试'