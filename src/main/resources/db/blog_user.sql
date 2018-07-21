CREATE TABLE blog_user (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
	name VARCHAR (10) COMMENT '姓名',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '用户管理表';