CREATE TABLE blog_trash (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	contentId INT (11) COMMENT '回收内容ID',
	description VARCHAR (255) COMMENT '回收内容描述',
	classify VARCHAR (10) COMMENT '分类',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '回收站表';