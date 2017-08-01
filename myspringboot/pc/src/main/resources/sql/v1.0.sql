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

drop table if EXISTS `role`
create table role(
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `record_id` varchar(36) not null  COMMENT '记录id',
  `name` varchar(255) DEFAULT '' COMMENT '角色名',
  `code` varchar(36) DEFAULT '' COMMENT '角色code',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户表';

drop table if EXISTS `user_role_relation`
create table user_role_relation(
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_record_id` varchar(36) not null  COMMENT '记录id',
  `role_record_id` varchar(255) DEFAULT '' COMMENT '用户名',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户表';