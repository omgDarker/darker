DROP TABLE
IF EXISTS blog_column;

CREATE TABLE blog_column (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '栏目ID',
	name VARCHAR (10) DEFAULT '' COMMENT '栏目名称',
	classifyId INT (32) COMMENT '分类ID',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '栏目表';
COMMIT ;

/*================================[DML<数据操作语言>:20180815]================================*/
INSERT INTO `blog_column` (`id`, `name`, `classifyId`, `isDelete`, `creator`, `createTime`, `updateTime`) VALUES (1, '漫心周记', 1, 0, 'darker', NULL, '2018-8-15 14:15:37');
INSERT INTO `blog_column` (`id`, `name`, `classifyId`, `isDelete`, `creator`, `createTime`, `updateTime`) VALUES (2, '随笔记录', 1, 0, 'darker', NULL, '2018-8-15 14:15:37');
INSERT INTO `blog_column` (`id`, `name`, `classifyId`, `isDelete`, `creator`, `createTime`, `updateTime`) VALUES (3, '前端技术', 2, 0, 'darker', NULL, '2018-8-15 14:15:38');
INSERT INTO `blog_column` (`id`, `name`, `classifyId`, `isDelete`, `creator`, `createTime`, `updateTime`) VALUES (4, '后端技术', 2, 0, 'darker', NULL, '2018-8-15 14:15:39');
INSERT INTO `blog_column` (`id`, `name`, `classifyId`, `isDelete`, `creator`, `createTime`, `updateTime`) VALUES (5, '网络编程', 2, 0, 'darker', NULL, '2018-8-15 14:15:40');
INSERT INTO `blog_column` (`id`, `name`, `classifyId`, `isDelete`, `creator`, `createTime`, `updateTime`) VALUES (6, '设计模式', 2, 0, 'darker', NULL, '2018-8-15 14:15:41');