/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : stusys

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-11-21 21:59:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `year` int(11) NOT NULL,
  `collegeID` int(11) NOT NULL,
  PRIMARY KEY (`classID`),
  KEY `class_college` (`collegeID`),
  CONSTRAINT `class_college` FOREIGN KEY (`collegeID`) REFERENCES `college` (`collegeID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '信息安全2班', '2015', '1');
INSERT INTO `class` VALUES ('2', '信息安全1班', '2015', '1');

-- ----------------------------
-- Table structure for `college`
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `collegeID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`collegeID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES ('1', '网络空间安全与计算机学院');

-- ----------------------------
-- Table structure for `stu_info`
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info` (
  `infoID` varchar(11) NOT NULL,
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` varchar(2) NOT NULL,
  `classID` int(11) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `homeNumber` varchar(11) DEFAULT NULL COMMENT '家庭电话',
  `address` varchar(100) DEFAULT NULL,
  `hornor` varchar(500) DEFAULT NULL COMMENT '所获荣誉',
  `activity` varchar(1000) DEFAULT NULL COMMENT '活动经历',
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`infoID`),
  KEY `nameIndex` (`name`),
  KEY `info_class` (`classID`),
  CONSTRAINT `info_class` FOREIGN KEY (`classID`) REFERENCES `class` (`classID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_info
-- ----------------------------
INSERT INTO `stu_info` VALUES ('20151101005', '王恺霖', '女', '2', '22222222222', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('20151101023', '温子酉', '男', '2', '11111111111', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('20151101029', '陈思明', '男', '1', '15028435695', '00000', '河北省保定市徐水区安顺街四巷二号', '河北省程序设计竞赛一等奖<br>中国大学生程序设计竞赛优胜奖', '河北大学学生会主席', '1996-10-03');

-- ----------------------------
-- Table structure for `stu_user`
-- ----------------------------
DROP TABLE IF EXISTS `stu_user`;
CREATE TABLE `stu_user` (
  `id` varchar(11) NOT NULL COMMENT '学号',
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_user
-- ----------------------------

-- ----------------------------
-- View structure for `v_studetil`
-- ----------------------------
DROP VIEW IF EXISTS `v_studetil`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_studetil` AS select `stu_info`.`infoID` AS `id`,`stu_info`.`name` AS `name`,`stu_info`.`phone` AS `phone`,`class`.`name` AS `clazz`,`class`.`year` AS `year`,`college`.`name` AS `college`,`stu_info`.`sex` AS `sex`,`stu_info`.`homeNumber` AS `homeNumber`,`stu_info`.`address` AS `address`,`stu_info`.`hornor` AS `hornor`,`stu_info`.`activity` AS `activity`,`stu_info`.`birthday` AS `birthday` from ((`college` join `class` on((`college`.`collegeID` = `class`.`collegeID`))) join `stu_info` on((`stu_info`.`classID` = `class`.`classID`))) ;

-- ----------------------------
-- View structure for `v_stuinfo`
-- ----------------------------
DROP VIEW IF EXISTS `v_stuinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_stuinfo` AS select `stu_info`.`infoID` AS `id`,`stu_info`.`name` AS `name`,`stu_info`.`phone` AS `phone`,`class`.`name` AS `clazz`,`class`.`year` AS `year`,`college`.`name` AS `college`,`stu_info`.`sex` AS `sex` from ((`college` join `class` on((`college`.`collegeID` = `class`.`collegeID`))) join `stu_info` on((`stu_info`.`classID` = `class`.`classID`))) ;
