CREATE TABLE relation_role_permission (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	roleId INT (11) COMMENT '角色ID',
	permissionId INT (11) COMMENT '权限ID',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '角色权限管理表';