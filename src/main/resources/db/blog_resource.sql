DROP TABLE
IF EXISTS blog_resource;

CREATE TABLE blog_resource (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '资源ID',
	CODE FLOAT (2, 1) DEFAULT 0.0 COMMENT '编码',
	NAME VARCHAR (10) DEFAULT '' COMMENT '资源名称',
	path VARCHAR (255) DEFAULT '' COMMENT '资源链接',
	parentName VARCHAR (10) DEFAULT '' COMMENT '父节点名称',
	classify VARCHAR (10) DEFAULT '' COMMENT '资源分类',
	isDelete INT (11) DEFAULT 0 COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) DEFAULT 'darker' COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '资源管理表';
COMMIT;
/*================================[更新脚本时间:20180724]================================*/
CREATE TABLE blog_resource (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '资源ID',
	code FLOAT (2, 1) COMMENT '编码',
	name VARCHAR (10) COMMENT '资源名称',
	path VARCHAR (255) COMMENT '资源链接',
	parentName VARCHAR (10) COMMENT '父节点名称',
	isDelete INT (11) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '资源管理表';
ALTER TABLE blog_resource ADD classify VARCHAR(10) COMMENT '资源分类';
COMMIT ;