CREATE TABLE content_photo (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '图片ID',
	title VARCHAR (255) COMMENT '标题',
	description VARCHAR (255) COMMENT '描述',
	path VARCHAR (255) COMMENT '存储路径',
	readAmount INT (10) COMMENT '阅读量',
	likeAmount INT (10) COMMENT '点赞量',
	classify VARCHAR (10) COMMENT '分类',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '图片管理表';