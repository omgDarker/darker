CREATE TABLE blog_role (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '角色ID',
	name VARCHAR (10) COMMENT '角色名称',
	description VARCHAR (10) COMMENT '角色描述',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '角色管理表';

/*================================[DML<数据操作语言>:20180730]================================*/
INSERT INTO blog_role (name) VALUES ('管理员');
INSERT INTO blog_role (name) VALUES ('游客');