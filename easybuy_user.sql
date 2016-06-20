/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50546
Source Host           : localhost:3306
Source Database       : easybuy

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2016-05-19 21:01:54
*/

SET FOREIGN_KEY_CHECKS=0;
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
