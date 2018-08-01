CREATE TABLE content_diary (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '日志ID',
	title VARCHAR (255) COMMENT '标题',
	content text COMMENT '内容',
	readAmount INT (10) COMMENT '阅读量',
	likeAmount INT (10) COMMENT '点赞量',
	classify VARCHAR (10) COMMENT '分类<每周一记,随笔记录>',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '日志管理表';