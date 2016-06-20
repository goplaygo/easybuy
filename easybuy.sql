/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50546
Source Host           : localhost:3306
Source Database       : easybuy

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2016-05-19 21:02:31
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `easybuy_product`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product`;
CREATE TABLE `easybuy_product` (
  `ep_id` int(11) NOT NULL AUTO_INCREMENT,
  `ep_name` varchar(255) NOT NULL,
  `ep_price` varchar(255) NOT NULL,
  `ep_type_id` int(11) NOT NULL,
  `ep_pic` varchar(255) NOT NULL,
  `ep_description` text NOT NULL,
  PRIMARY KEY (`ep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_product
-- ----------------------------
INSERT INTO `easybuy_product` VALUES ('1', '华硕电脑', '3000.0', '2', 's1.jpg', '华硕品牌笔记本电脑');
INSERT INTO `easybuy_product` VALUES ('2', '联想电脑', '4000.0', '2', 's2.jpg', '联想品牌笔记本电脑');
INSERT INTO `easybuy_product` VALUES ('3', 'IPHONE手机', '4899', '2', 's3.jpg', '苹果品牌智能手机');
INSERT INTO `easybuy_product` VALUES ('4', 'THINK IN JAVA', '78.0', '3', 's4.jpg', 'java学习经典书籍');
INSERT INTO `easybuy_product` VALUES ('5', 'SQL数据库入门', '80.0', '3', 's5.jpg', 'SQL入门学习书籍');
INSERT INTO `easybuy_product` VALUES ('6', '华数电脑', '3500.0', '2', 's6.jpg', '华硕品牌笔记本电脑');
INSERT INTO `easybuy_product` VALUES ('7', '联想电脑', '4000.0', '2', 's7.jpg', '联想电脑');
INSERT INTO `easybuy_product` VALUES ('8', '水浒传', '50', '3', 's8.jpg', '经典名著');
INSERT INTO `easybuy_product` VALUES ('9', '三国演义', '60', '3', 's9.jpg', '经典名著');

-- ----------------------------
-- Table structure for `easybuy_user`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_user`;
CREATE TABLE `easybuy_user` (
  `eu_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `eu_user_name` varchar(255) NOT NULL,
  `eu_password` varchar(255) NOT NULL,
  `eu_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eu_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_user
-- ----------------------------
INSERT INTO `easybuy_user` VALUES ('1', 'ruby', '123', null);
INSERT INTO `easybuy_user` VALUES ('2', '悟饭', '123', null);
INSERT INTO `easybuy_user` VALUES ('6', '花花', 'a123456', null);
