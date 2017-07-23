drop table if EXISTS `user`
create table user(
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `record_id` varchar(36) not null  COMMENT '记录id',
  `name` varchar(255) DEFAULT '' COMMENT '用户名',
  `user_account` varchar(36) DEFAULT '' COMMENT '帐号',
  `user_password` varchar(36) DEFAULT '' COMMENT '密码',
  `email` varchar(36) DEFAULT '' COMMENT 'email',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户表';
