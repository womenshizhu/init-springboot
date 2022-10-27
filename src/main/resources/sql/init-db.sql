-- user 用户表
DROP TABLE IF EXISTS user;

CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `test_camel` varchar(50) DEFAULT NULL COMMENT '测试',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_user` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM user;

INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');



-- document 文档表

DROP TABLE IF EXISTS document;

CREATE TABLE document
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	docType VARCHAR(30) NULL DEFAULT NULL COMMENT '文档类型	',
	docName VARCHAR(30) NULL DEFAULT NULL COMMENT '文档名称',
	docDetail VARCHAR(50) NULL DEFAULT NULL COMMENT '文档内容',
	PRIMARY KEY (id)
);

DELETE FROM document;

INSERT INTO document (id, docType, docName, docDetail) VALUES
(1, '类型1', '文档1', '内容1'),
(2, '类型2', '文档2', '内容2'),
(3, '类型3', '文档3', '内容123'),
(4, '类型1', '文档4', '内容3'),
(5, '类型2', '文档5', '内容123123123');