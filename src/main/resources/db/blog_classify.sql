DROP TABLE
IF EXISTS blog_classify;

CREATE TABLE blog_classify (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '分类ID',
	name VARCHAR (10) DEFAULT '' COMMENT '分类名称',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '分类表';
COMMIT ;

/*================================[DML<数据操作语言>:20180815]================================*/
INSERT INTO `blog_classify` (`id`, `name`, `isDelete`, `creator`, `createTime`, `updateTime`) VALUES (1, '生活点滴', 0, 'darker', NULL, '2018-8-15 14:15:13');
INSERT INTO `blog_classify` (`id`, `name`, `isDelete`, `creator`, `createTime`, `updateTime`) VALUES (2, '技术联盟', 0, 'darker', NULL, '2018-8-15 14:15:15');