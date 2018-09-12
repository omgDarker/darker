DROP TABLE
IF EXISTS blog_user;

CREATE TABLE blog_user (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
	name VARCHAR (50) DEFAULT '' COMMENT '用户名',
	password VARCHAR (50) DEFAULT '' COMMENT '用户密码',
	email VARCHAR (50) DEFAULT '' COMMENT '邮箱',
	area VARCHAR (255) DEFAULT '' COMMENT '地区',
	ip VARCHAR (15) DEFAULT '' COMMENT 'ip地址',
	sessionId VARCHAR (50) DEFAULT '' COMMENT 'sessionId',
	loginTime VARCHAR (50) DEFAULT '' COMMENT '用户登录时间',
	isDelete INT (1) DEFAULT 0 COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) DEFAULT 'darker' COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '用户管理表';

COMMIT;
/*================================[DML<数据操作语言>:20180912]================================*/
INSERT INTO blog_user (name, password,email,area,ip) VALUES ("darker", "darker","13264389469@163.com","北京市","127.0.0.1")