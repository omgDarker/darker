CREATE TABLE operation_monitor (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	content VARCHAR (255) COMMENT '内容',
	amount INT (10) COMMENT '数量',
	consumeTime INT (10) COMMENT '耗时',
	classify VARCHAR (10) COMMENT '分类',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '监控管理表';