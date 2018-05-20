

DROP DATABASE dtmp;
CREATE DATABASE dtmp;

-- ----------------------------
-- Table structure for upms_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) NOT NULL COMMENT '帐号',
  `password` varchar(32) NOT NULL COMMENT '密码MD5(密码+盐)',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐',
  `realname` varchar(20) DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(150) DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `locked` tinyint(4) DEFAULT NULL COMMENT '状态(0:正常,1:锁定)',
  `ctime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of upms_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '66f1b370c660445a8657bf8bf1794486', 'alkaid', '', '', 'jiangbb868@sina.com', '1', '0', '1');
INSERT INTO `tbl_user` VALUES ('2', 'jiangb', 'e10adc3949ba59abbe56e057f20f883e', 'd2d0d03310444ad388a8b290b0fe8564', '姜兵', '', '', 'jiangbb868@sina.com', '1', '0', '1493394720495');
