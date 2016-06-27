/*
Navicat MySQL Data Transfer

Source Server         : 本地MySQL
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : questionlib

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-01-02 21:11:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mgroup`
-- ----------------------------
DROP TABLE IF EXISTS `mgroup`;
CREATE TABLE `mgroup` (
  `groupid` varchar(36) NOT NULL,
  `college` varchar(20) NOT NULL,
  `groupname` varchar(20) NOT NULL,
  `teaid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`groupid`),
  KEY `FKskf9l4iyrwqvfnxsnfx2rg8om` (`teaid`),
  CONSTRAINT `FKskf9l4iyrwqvfnxsnfx2rg8om` FOREIGN KEY (`teaid`) REFERENCES `teacher` (`teaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mgroup
-- ----------------------------
INSERT INTO `mgroup` VALUES ('03907df7-fc74-47ce-8eea-4c1aecc0b463', '信息学院', '计算机4班', '232421422');
INSERT INTO `mgroup` VALUES ('297e1e39517197f001517197f4ce0000', '信息学院', '计算机4班', '12345678');
INSERT INTO `mgroup` VALUES ('600e5f75-0d01-412b-92a9-f8752019070d', '信息学院', '计算机4班', '232421422');
INSERT INTO `mgroup` VALUES ('6ca2869e-1797-4c52-916b-d8c1cfb76a08', '信息学院', '计算机4班', '232421421');
INSERT INTO `mgroup` VALUES ('a6be7430-421c-498c-be0e-b40d3cb09052', '信息学院', '计算机4班', '232421421');
INSERT INTO `mgroup` VALUES ('d12e0f97-5170-46a6-89dc-9412d13971cf', '信息学院', '计算机4班', '12345678');

-- ----------------------------
-- Table structure for `paper`
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `paperid` varchar(40) NOT NULL,
  `papername` varchar(40) NOT NULL,
  `ownerid` varchar(40) DEFAULT NULL,
  `paperTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `destGroup` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`paperid`),
  KEY `FKb4c0pjv13pcr513f89hpq9g9h` (`ownerid`),
  KEY `FKc8gr37voivt1iaho6a89blfpu` (`destGroup`),
  CONSTRAINT `FKb4c0pjv13pcr513f89hpq9g9h` FOREIGN KEY (`ownerid`) REFERENCES `teacher` (`teaid`),
  CONSTRAINT `FKc8gr37voivt1iaho6a89blfpu` FOREIGN KEY (`destGroup`) REFERENCES `mgroup` (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('54211d16-99f2-4cd4-86a2-111c6f248dc2', '软件工程考试', '12345678', '2016-01-02 00:00:00', '297e1e39517197f001517197f4ce0000');

-- ----------------------------
-- Table structure for `quespaper`
-- ----------------------------
DROP TABLE IF EXISTS `quespaper`;
CREATE TABLE `quespaper` (
  `paperid` varchar(40) DEFAULT NULL,
  `quesid` varchar(40) DEFAULT NULL,
  `qvalue` float DEFAULT NULL,
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`rid`),
  KEY `FKbot6w5slt6n7x3pcujg8lw5cs` (`quesid`),
  KEY `FKa1d17ml2i77jj4iry1edrpuy3` (`paperid`),
  CONSTRAINT `FKa1d17ml2i77jj4iry1edrpuy3` FOREIGN KEY (`paperid`) REFERENCES `paper` (`paperid`),
  CONSTRAINT `FKbot6w5slt6n7x3pcujg8lw5cs` FOREIGN KEY (`quesid`) REFERENCES `question` (`quesid`)
) ENGINE=InnoDB AUTO_INCREMENT=477 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quespaper
-- ----------------------------
INSERT INTO `quespaper` VALUES ('54211d16-99f2-4cd4-86a2-111c6f248dc2', '86b727e1-ca38-49ef-80bd-0c8409613925', '0.341206', '467');
INSERT INTO `quespaper` VALUES ('54211d16-99f2-4cd4-86a2-111c6f248dc2', 'bbe419e9-e061-4382-98c4-fb955f5f4313', '0.707045', '468');
INSERT INTO `quespaper` VALUES ('54211d16-99f2-4cd4-86a2-111c6f248dc2', '2bed31a6-836c-4671-a42b-004c47f93493', '0.19643', '469');
INSERT INTO `quespaper` VALUES ('54211d16-99f2-4cd4-86a2-111c6f248dc2', 'b09c995c-bad3-4957-8588-f80bd6e2f1f5', '0.27102', '470');
INSERT INTO `quespaper` VALUES ('54211d16-99f2-4cd4-86a2-111c6f248dc2', 'c6dba644-4426-46c5-89b4-6709ddbd4997', '0.378802', '471');
INSERT INTO `quespaper` VALUES ('54211d16-99f2-4cd4-86a2-111c6f248dc2', 'fb052e3e-e529-4e82-86ec-4f21e02564bc', '0.507019', '472');
INSERT INTO `quespaper` VALUES ('54211d16-99f2-4cd4-86a2-111c6f248dc2', '54351910-f6dd-4ade-a811-d43ac0adbfd9', '0.52273', '473');
INSERT INTO `quespaper` VALUES ('54211d16-99f2-4cd4-86a2-111c6f248dc2', 'ba1bbfbe-c77d-4fcc-b3f1-565f55d4d659', '0.654215', '474');
INSERT INTO `quespaper` VALUES ('54211d16-99f2-4cd4-86a2-111c6f248dc2', '52512cc5-b9d7-4887-bd29-0bbca7d51303', '0.311095', '475');
INSERT INTO `quespaper` VALUES ('54211d16-99f2-4cd4-86a2-111c6f248dc2', 'c551097e-5041-407e-ac34-1e742a535068', '0.0776538', '476');

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `quesid` varchar(40) NOT NULL,
  `quesname` varchar(30) DEFAULT NULL,
  `quescontent` longtext NOT NULL,
  `quesanswer` longtext NOT NULL,
  `questype` varchar(10) NOT NULL,
  `other1` varchar(100) DEFAULT NULL,
  `other2` varchar(100) DEFAULT NULL,
  `other3` varchar(100) DEFAULT NULL,
  `other4` varchar(100) DEFAULT NULL,
  `ownerid` varchar(40) DEFAULT NULL,
  `insertTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`quesid`),
  KEY `FKqci3av542w5h16a4lmnoro7s4` (`ownerid`),
  CONSTRAINT `FKqci3av542w5h16a4lmnoro7s4` FOREIGN KEY (`ownerid`) REFERENCES `teacher` (`teaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('2bed31a6-836c-4671-a42b-004c47f93493', '名词解释2', '2、GIS软件工程就是在GIS软件的开发整个过程中，遵循一般软件开发的工程化原理和方法，并照顾到GIS软件开发的特殊规律和要求，对GIS软件各个阶段进行工程化规范的一门技术。', '答案再略', 'jeishi', '', '', '', '', '12345678', '2016-01-02 00:00:00');
INSERT INTO `question` VALUES ('52512cc5-b9d7-4887-bd29-0bbca7d51303', '应用题1', '经济可行性进行开发成本的估算以及了解取得效益的评估，确定要开发的项目是否值得投资开发。社会可行性要开发的项目是否存在任何侵犯、妨碍等责任问题，要开发项目目的运行方式在用户组织内是否行得通，现有管理制度、人员素质、操作方式是否可行。', '答案略', 'yingyong', '', '', '', '', '12345678', '2016-01-02 00:00:00');
INSERT INTO `question` VALUES ('54351910-f6dd-4ade-a811-d43ac0adbfd9', '填空2', '2.软件=       +       +       . ', '文档+程序+数据结构', 'tiankong', '', '', '', '', '12345678', '2016-01-02 00:00:00');
INSERT INTO `question` VALUES ('86b727e1-ca38-49ef-80bd-0c8409613925', '信息系统1', '信息系统的生命周期可以分为四个阶段：信息系统经常不可避免地会遇到系统更新改造、功能扩展、甚至报废重建等情况，应该在信息系统建设的（）考虑到系统消亡的条件和时机', 'A', 'xuanze', 'A、初期', 'B、中期', 'C、末期', 'D、试运行或验收期', '12345678', '2016-01-02 00:00:00');
INSERT INTO `question` VALUES ('b09c995c-bad3-4957-8588-f80bd6e2f1f5', '名词解释1', '1、软件工程是用科学知识和技术原理来定义、开发、维护软件的一门学科。其主要思想是在软件生产中用工程化的方法代替传统手工方法。', '答案略', 'jeishi', '', '', '', '', '12345678', '2016-01-02 00:00:00');
INSERT INTO `question` VALUES ('ba1bbfbe-c77d-4fcc-b3f1-565f55d4d659', '填空1', '1.传统的瀑布模型把软件生存周期划分成为题定义、    、    、      、     、       、      、       和维护共8个阶段。', '答案略', 'tiankong', '', '', '', '', '12345678', '2016-01-02 00:00:00');
INSERT INTO `question` VALUES ('bbe419e9-e061-4382-98c4-fb955f5f4313', '黑河测试1', '除了测试程序外,黑盒测试还适用于对( )阶段的软件文档进行测试。', 'B', 'xuanze', 'A、编码', 'B、软件详细设计', 'C、软件总体设计', 'D、需求分析', '12345678', '2016-01-02 00:00:00');
INSERT INTO `question` VALUES ('c551097e-5041-407e-ac34-1e742a535068', '应用题2', '某培训中心要研制一个计算机管理系统。它的业务是：将学员发来的信件收集分类后，按几种不同的情况处理。如果是报名的，则将报名数据送给负责报名事务的职员，他们将查阅课程文件，检查该课程是否额满，然后在学生文件、课程文件上登记，并开出报告单交财务部门，财务人员开出发票给学生。如果是想注销原来已选修的课程，则由注销人员在课程文件、学生文件和账目文件上做相应的修改，并给学生注销单。如果是付款的，则由财务人员在账目文件上登记，也给学生一张收费收据。 要求：对以上问题画出数据流图。', '答案略', 'yingyong', '', '', '', '', '12345678', '2016-01-02 00:00:00');
INSERT INTO `question` VALUES ('c6dba644-4426-46c5-89b4-6709ddbd4997', '简答2', '简述数据流图的分类及每一类的特点。', '数据流图有两类：变换型数据流图和事务型数据流图。(1分)变换型数据流图是由输入、处理和输出三部分组成，(1分)因此变化型数据流图是一个顺序结构。(1分)事务型数据流图特征：事务处理中心将它的输入流分离成许多发散的数据流，形成许多加工路径，(1分)并根据输入的值选择其中一个路径来执行。(1分)', 'jianda', '', '', '', '', '12345678', '2016-01-02 00:00:00');
INSERT INTO `question` VALUES ('fb052e3e-e529-4e82-86ec-4f21e02564bc', '简答1', '1. 简述软件危机产生的原因。', '软件危机产生的原因有：(每点1分) (1)软件的规模越来越大，结构越来越复杂。 \r\n(2)软件开发的管理困难。由于软件规模大，结构复杂，又具有无形性，导致管理困难，进度控制困难，质量控制困难，可靠性无法保证。 \r\n(3)软件开发费用不断增加。软件生产是一种智力劳动，它是资金密集、人力密集的产业，大型软件投入人力多，周期长，费用上升很快。 \r\n(4)软件开发技术、开发工具落后，生产率提高缓慢。 (5)生产方式落后。软件仍然采用个体手工方式开发。', 'jianda', '', '', '', '', '12345678', '2016-01-02 00:00:00');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuid` varchar(40) NOT NULL,
  `stuname` varchar(30) NOT NULL,
  `password` varchar(40) NOT NULL,
  `college` varchar(20) NOT NULL,
  `groupid` varchar(36) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`stuid`),
  UNIQUE KEY `email` (`email`),
  KEY `FKi4k4p8rlhcv32wc9yi2gohsim` (`groupid`),
  CONSTRAINT `FKi4k4p8rlhcv32wc9yi2gohsim` FOREIGN KEY (`groupid`) REFERENCES `mgroup` (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201301050411', '哈哈哈', '4QrcOUm6Wau+VuBX8g+IPg==', '信息学院', '297e1e39517197f001517197f4ce0000', '566464646', 'ada@qq.com', '2015-12-06 00:50:46');
INSERT INTO `student` VALUES ('201301050415', '林宇强', '123', '信息学院', '297e1e39517197f001517197f4ce0000', '13210135013', '1098129797@qq.com', '2015-12-05 18:02:42');
INSERT INTO `student` VALUES ('201301050416', '林宇强', '123456', '信息学院', '600e5f75-0d01-412b-92a9-f8752019070d', '13210135013', '1098129792@qq.com', '2015-12-09 00:00:00');
INSERT INTO `student` VALUES ('201301050417', '林宇强', '123456', '信息学院', '600e5f75-0d01-412b-92a9-f8752019070d', '13210135013', '10981297912@qq.com', '2015-12-30 00:00:00');
INSERT INTO `student` VALUES ('201301050418', '林宇强', '4QrcOUm6Wau+VuBX8g+IPg==', '信息学院', '600e5f75-0d01-412b-92a9-f8752019070d', '13210135013', '10981297913@qq.com', '2015-12-30 00:00:00');

-- ----------------------------
-- Table structure for `stupaper`
-- ----------------------------
DROP TABLE IF EXISTS `stupaper`;
CREATE TABLE `stupaper` (
  `stuid` varchar(40) DEFAULT NULL,
  `paperid` varchar(40) DEFAULT NULL,
  `score` float DEFAULT NULL,
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`rid`),
  KEY `FKohdtmxltrqi2ipjpg3tbrlvsu` (`paperid`),
  KEY `FK8dr8cufd3c950gasngynmcfdr` (`stuid`),
  CONSTRAINT `FK8dr8cufd3c950gasngynmcfdr` FOREIGN KEY (`stuid`) REFERENCES `student` (`stuid`),
  CONSTRAINT `FKohdtmxltrqi2ipjpg3tbrlvsu` FOREIGN KEY (`paperid`) REFERENCES `paper` (`paperid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stupaper
-- ----------------------------

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teaid` varchar(40) NOT NULL,
  `teaname` varchar(30) NOT NULL,
  `password` varchar(40) NOT NULL,
  `college` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`teaid`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('12345678', '崔阵雨', '4QrcOUm6Wau+VuBX8g+IPg==', '信息学院', '1561515311', 'sfs1@qq.com', '2015-12-06 01:12:14');
INSERT INTO `teacher` VALUES ('232421421', '老师1', '123', '信息学院', '110', '102@qq.com', '2015-12-05 18:02:42');
INSERT INTO `teacher` VALUES ('232421422', '老师1', '123', '信息学院', '110', '1021@qq.com', '2015-12-09 00:00:00');
INSERT INTO `teacher` VALUES ('232421423', '老师1', '123', '信息学院', '110', '10212@qq.com', '2015-12-09 00:00:00');
INSERT INTO `teacher` VALUES ('232421425', '老师1', '123', '信息学院', '110', '102123@qq.com', '2015-12-09 00:00:00');
INSERT INTO `teacher` VALUES ('232421426', '老师1', 'ICy5YqxZB1uWSwcVLSNLcA==', '信息学院', '110', '102124@qq.com', '2015-12-30 00:00:00');
