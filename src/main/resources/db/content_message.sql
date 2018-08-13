DROP TABLE
IF EXISTS content_message;

CREATE TABLE content_message (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	userId INT (11) COMMENT '用户ID',
	userName VARCHAR (255) DEFAULT '' COMMENT '用户名称',
	email VARCHAR (100) DEFAULT '' COMMENT '用户邮箱',
	content VARCHAR (255) COMMENT '内容',
	articleId VARCHAR (11) COMMENT '文章ID',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '留言板管理表';

COMMIT;

/*================================[DML<数据操作语言>:20180808]================================*/
INSERT INTO content_message (userId,userName,email,content)VALUES(14,'测试TEST233','13264389469@163.com','测试');