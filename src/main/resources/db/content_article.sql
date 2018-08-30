DROP TABLE
IF EXISTS content_article;

CREATE TABLE content_article (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '文章ID',
	title VARCHAR (255) COMMENT '标题',
	summary text DEFAULT '' (255) COMMENT '摘要',
	content text COMMENT '内容',
	imageName VARCHAR (255) COMMENT '首图名称',
	readAmount INT (10) DEFAULT '456' COMMENT '阅读量',
	likeAmount INT (10) DEFAULT '32' COMMENT '点赞量',
	likeNoAmount INT (10) DEFAULT '6' COMMENT '甩鞋量',
	classifyId VARCHAR (10) DEFAULT '' COMMENT '分类',
	columnId VARCHAR (10) DEFAULT '' COMMENT '栏目名称',
	isDelete INT (1) COMMENT '是否删除(1:是,0:否)',
	creator VARCHAR (10) COMMENT '创建人',
	createTime datetime COMMENT '创建时间',
	updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '文章管理表';
COMMIT ;

/*================================[DML<数据操作语言>:20180830]================================*/
update content_article set summary = replace(summary,'<p>','') /**将指定字段的特定内容删除**/
