CREATE TABLE blog_resource (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '资源ID',
	code FLOAT (2, 1) COMMENT '编码',
	name VARCHAR (10) COMMENT '名称',
	path VARCHAR (255) COMMENT '访问路径',
	parentName VARCHAR (10) COMMENT '父节点名称',
	isDelete INT (11) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '资源管理表';