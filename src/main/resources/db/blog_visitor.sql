CREATE TABLE blog_visitor (
	userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '游客ID',
	userName VARCHAR (255) COMMENT '游客名称',
	email VARCHAR (255) COMMENT '游客邮箱',
	phone VARCHAR (255) COMMENT '游客手机号码',
	record VARCHAR (255) COMMENT '游客留言记录',
	motto VARCHAR (255) COMMENT '游客座右铭'
) COMMENT = '游客信息表';