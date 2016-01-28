/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-31 05:34:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `books`
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `bk_id` int(10) NOT NULL DEFAULT '0' AUTO_INCREMENT,
  `bk_category` varchar(100) DEFAULT NULL,
  `bk_title` varchar(100) DEFAULT NULL,
  `bk_titlelang` varchar(100) DEFAULT NULL,
  `bk_year` int(5) DEFAULT NULL,
  `bk_price` decimal(10,2) DEFAULT NULL,
  `bk_author` varchar(100) DEFAULT NULL,
  `bk_logo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of books
-- ----------------------------
