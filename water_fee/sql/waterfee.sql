/*
 Navicat Premium Data Transfer

 Source Server         : Docker
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 192.168.10.10:3306
 Source Schema         : waterfee

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 24/09/2020 10:16:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `admin_id` int(255) NOT NULL AUTO_INCREMENT,
  `unit_price` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
BEGIN;
INSERT INTO `admin_info` VALUES (1, 5.60, '2020-09-24 00:47:06');
COMMIT;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL,
  `supply_number` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `user_tel` varchar(255) DEFAULT NULL,
  `user_adress` varchar(255) DEFAULT NULL,
  `money_left` decimal(8,6) DEFAULT NULL,
  `water_left` decimal(8,6) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_recharge
-- ----------------------------
DROP TABLE IF EXISTS `user_recharge`;
CREATE TABLE `user_recharge` (
  `recharge_id` varchar(255) NOT NULL,
  `supply_number` varchar(255) DEFAULT NULL,
  `recherge_status` int(1) DEFAULT NULL,
  `recherge_amount` decimal(8,6) DEFAULT NULL,
  `recharge_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`recharge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_recharge
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_statistics
-- ----------------------------
DROP TABLE IF EXISTS `user_statistics`;
CREATE TABLE `user_statistics` (
  `statistics_id` varchar(255) NOT NULL,
  `supply_number` varchar(255) DEFAULT NULL,
  `statistics_daily` decimal(8,6) DEFAULT NULL,
  `statistics_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`statistics_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_statistics
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
