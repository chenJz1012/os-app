/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : app

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-09-08 10:44:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_function
-- ----------------------------
DROP TABLE IF EXISTS `sys_function`;
CREATE TABLE `sys_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL COMMENT '父ID',
  `function_name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT '功能名称',
  `display` int(1) NOT NULL DEFAULT '1' COMMENT '是否显示到菜单栏',
  `state` int(1) NOT NULL COMMENT '是否启用，0=不启用，1=启用',
  `icon` varchar(50) DEFAULT NULL COMMENT 'icon',
  `action` varchar(255) NOT NULL COMMENT '请求路径',
  `function_desc` int(3) NOT NULL COMMENT '排序号',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `action` (`action`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `default_action` varchar(255) NOT NULL COMMENT '角色默认跳转function',
  `state` int(1) NOT NULL COMMENT '是否启用，0=不启用，1=启用',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '生成时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_function
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_function`;
CREATE TABLE `sys_role_function` (
  `function_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  KEY `function_id` (`function_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) NOT NULL COMMENT '登录名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `display_name` varchar(50) NOT NULL COMMENT '显示名称',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态，0=冻结，1=正常',
  `account_non_locked` tinyint(1) NOT NULL DEFAULT '1' COMMENT '未锁定状态，0=正常，1=锁定',
  `account_non_expired` tinyint(1) NOT NULL DEFAULT '1' COMMENT '账号过期状态，1=正常，0=过期',
  `credentials_non_expired` tinyint(1) NOT NULL DEFAULT '1' COMMENT '密码失效状态：1：未失效 0：已失效',
  `last_login_ip` varchar(100) DEFAULT NULL COMMENT '登陆IP',
  `last_login_time` timestamp NULL DEFAULT NULL COMMENT '最后登陆时间',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `contact_phone` varchar(100) DEFAULT NULL COMMENT '电话',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
