/*
Navicat MySQL Data Transfer

Source Server         : localhost@root
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : darker

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2018-10-18 17:21:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_permission
-- ----------------------------
DROP TABLE IF EXISTS `blog_permission`;
CREATE TABLE `blog_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='权限管理表';

-- ----------------------------
-- Table structure for blog_role
-- ----------------------------
DROP TABLE IF EXISTS `blog_role`;
CREATE TABLE `blog_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `NAME` varchar(10) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色管理表';

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(50) DEFAULT '' COMMENT '用户名',
  `password` varchar(50) DEFAULT '' COMMENT '用户密码',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `area` varchar(255) DEFAULT '' COMMENT '地区',
  `ip` varchar(15) DEFAULT '' COMMENT 'ip地址',
  `sessionId` varchar(50) DEFAULT '' COMMENT 'sessionId',
  `loginTime` varchar(50) DEFAULT '' COMMENT '用户登录时间',
  `isDelete` int(1) DEFAULT '0' COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT 'darker' COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1873 DEFAULT CHARSET=utf8 COMMENT='用户管理表';

-- ----------------------------
-- Table structure for content_article
-- ----------------------------
DROP TABLE IF EXISTS `content_article`;
CREATE TABLE `content_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `summary` text COMMENT '摘要',
  `content` text COMMENT '内容',
  `imageName` varchar(255) DEFAULT NULL COMMENT '首图名称',
  `readAmount` int(10) DEFAULT '0' COMMENT '阅读量',
  `likeAmount` int(10) DEFAULT '0' COMMENT '点赞量',
  `likeNoAmount` int(10) DEFAULT '0' COMMENT '甩鞋量',
  `classifyId` int(10) DEFAULT NULL COMMENT '分类',
  `columnId` int(10) DEFAULT NULL COMMENT '栏目名称',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 COMMENT='文章管理表';

-- ----------------------------
-- Table structure for content_link
-- ----------------------------
DROP TABLE IF EXISTS `content_link`;
CREATE TABLE `content_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '链接ID',
  `name` varchar(100) DEFAULT '' COMMENT '链接名称',
  `url` varchar(255) DEFAULT '' COMMENT '链接地址',
  `description` varchar(100) DEFAULT NULL COMMENT '链接描述',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='友情链接表';

-- ----------------------------
-- Table structure for content_message
-- ----------------------------
DROP TABLE IF EXISTS `content_message`;
CREATE TABLE `content_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `userName` varchar(255) DEFAULT '' COMMENT '用户名称',
  `email` varchar(100) DEFAULT '' COMMENT '用户邮箱',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `articleId` varchar(11) DEFAULT NULL COMMENT '文章ID',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='留言板管理表';

-- ----------------------------
-- Table structure for content_photo
-- ----------------------------
DROP TABLE IF EXISTS `content_photo`;
CREATE TABLE `content_photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片ID',
  `name` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `description` varchar(255) DEFAULT '' COMMENT '描述',
  `readAmount` int(10) DEFAULT '0' COMMENT '阅读量',
  `likeAmount` int(10) DEFAULT '0' COMMENT '点赞量',
  `classifyId` int(10) DEFAULT '3' COMMENT '分类ID',
  `columnId` int(10) DEFAULT NULL COMMENT '栏目ID',
  `isDelete` int(1) DEFAULT '0' COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT 'darker' COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='图片管理表';

-- ----------------------------
-- Table structure for operation_monitor
-- ----------------------------
DROP TABLE IF EXISTS `operation_monitor`;
CREATE TABLE `operation_monitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `amount` int(10) DEFAULT NULL COMMENT '数量',
  `consumeTime` int(10) DEFAULT NULL COMMENT '耗时',
  `classify` varchar(10) DEFAULT NULL COMMENT '分类',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='监控管理表';

-- ----------------------------
-- Table structure for operation_statistics
-- ----------------------------
DROP TABLE IF EXISTS `operation_statistics`;
CREATE TABLE `operation_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `content` varchar(255) DEFAULT '' COMMENT '内容',
  `contentId` int(11) DEFAULT NULL COMMENT '内容ID(文章ID)',
  `amount` int(10) DEFAULT '0' COMMENT '数量',
  `classify` varchar(10) DEFAULT '' COMMENT '分类',
  `isDelete` int(1) DEFAULT '0' COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT 'darker' COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='统计信息表';

-- ----------------------------
-- Table structure for relation_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `relation_role_permission`;
CREATE TABLE `relation_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `roleId` int(11) DEFAULT NULL COMMENT '角色ID',
  `permissionId` int(11) DEFAULT NULL COMMENT '权限ID',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色权限管理表';

-- ----------------------------
-- Table structure for relation_user_role
-- ----------------------------
DROP TABLE IF EXISTS `relation_user_role`;
CREATE TABLE `relation_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `roleId` int(11) DEFAULT NULL COMMENT '角色ID',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户角色管理表';

-- ----------------------------
-- Table structure for resource_classify
-- ----------------------------
DROP TABLE IF EXISTS `resource_classify`;
CREATE TABLE `resource_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `name` varchar(10) DEFAULT '' COMMENT '分类名称',
  `description` varchar(20) DEFAULT NULL COMMENT '分类描述',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Table structure for resource_column
-- ----------------------------
DROP TABLE IF EXISTS `resource_column`;
CREATE TABLE `resource_column` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '栏目ID',
  `name` varchar(10) DEFAULT '' COMMENT '栏目名称',
  `classifyId` int(32) DEFAULT NULL COMMENT '分类ID',
  `description` varchar(100) DEFAULT NULL COMMENT '栏目描述',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='栏目表';

-- ----------------------------
-- Table structure for resource_content
-- ----------------------------
DROP TABLE IF EXISTS `resource_content`;
CREATE TABLE `resource_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `CODE` float(2,1) DEFAULT '0.0' COMMENT '编码',
  `NAME` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `path` varchar(255) DEFAULT NULL COMMENT '资源链接',
  `classify` varchar(10) DEFAULT '' COMMENT '资源分类',
  `parentName` varchar(50) DEFAULT NULL COMMENT '父节点名称',
  `isDelete` int(11) DEFAULT '0' COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT 'bk' COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='资源管理表';

-- ----------------------------
-- Table structure for resource_trash
-- ----------------------------
DROP TABLE IF EXISTS `resource_trash`;
CREATE TABLE `resource_trash` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `contentId` int(11) DEFAULT NULL COMMENT '回收内容ID',
  `description` varchar(255) DEFAULT NULL COMMENT '回收内容描述',
  `classify` varchar(10) DEFAULT NULL COMMENT '分类',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='回收站表';