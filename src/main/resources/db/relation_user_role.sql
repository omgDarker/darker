CREATE TABLE relation_user_role (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	userId INT (11) COMMENT '用户ID',
	roleId INT (11) COMMENT '角色ID',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '用户角色管理表';