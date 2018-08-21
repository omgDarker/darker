DROP TABLE
IF EXISTS blog_permission;

CREATE TABLE blog_permission (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	name VARCHAR (255) COMMENT '权限名称',
	description VARCHAR (255) COMMENT '权限描述',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '权限管理表';
COMMIT ;