DROP TABLE IF EXISTS `blog_link`;
CREATE TABLE `blog_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '链接ID',
  `name` varchar(100) DEFAULT '' COMMENT '链接名称',
  `url` varchar(255) DEFAULT '' COMMENT '链接地址',
  `description` varchar(100) DEFAULT NULL COMMENT '链接描述',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除(1:是,0:否)',
  `creator` varchar(10) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='友情链接表';

/*================================[DML<数据操作语言>:20180820]================================*/
INSERT INTO `blog_link` VALUES ('1', '百度', 'http://www.baidu.com', '搜索引擎', '0', null, null, '2018-08-17 19:25:55');
INSERT INTO `blog_link` VALUES ('2', '谷歌', 'http://www.google.com', '搜索引擎', '0', null, null, '2018-08-17 19:25:53');
INSERT INTO `blog_link` VALUES ('3', 'Bootstrap', 'http://www.bootcss.com', '前端框架', '0', null, null, '2018-08-17 19:25:50');
INSERT INTO `blog_link` VALUES ('4', 'OSCer', 'https://my.oschina.net/Tsher2015', '个人博客', '0', null, null, '2018-08-17 14:43:35');
INSERT INTO `blog_link` VALUES ('5', 'Jquery', 'http://www.jq22.com/', '动画效果', '0', null, null, '2018-08-17 15:21:31');