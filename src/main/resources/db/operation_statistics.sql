DROP TABLE
IF EXISTS `operation_statistics`;

CREATE TABLE `operation_statistics` (
	`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`content` VARCHAR (255) DEFAULT '' COMMENT '内容',
	`contentId` INT (11) COMMENT '内容ID(文章ID)',
	`amount` INT (10) DEFAULT 0 COMMENT '数量',
	`classify` VARCHAR (10) DEFAULT '' COMMENT '分类',
	`isDelete` INT (1) DEFAULT 0 COMMENT '是否删除(1:是,0:否)',
	`creator` VARCHAR (10) DEFAULT 'darker' COMMENT '创建人',
	`createTime` datetime COMMENT '创建时间',
	`updateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 4 DEFAULT CHARSET = utf8 COMMENT = '统计信息表';