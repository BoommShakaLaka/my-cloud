/*
 Navicat Premium Data Transfer

 Source Server         : mysql_docker
 Source Server Type    : MySQL
 Source Server Version : 80100 (8.1.0)
 Source Host           : localhost:3306
 Source Schema         : mycloud

 Target Server Type    : MySQL
 Target Server Version : 80100 (8.1.0)
 File Encoding         : 65001

 Date: 23/03/2024 19:13:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `material_no` bigint NOT NULL COMMENT '物料编码',
  `material_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `company` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`material_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of material
-- ----------------------------
BEGIN;
INSERT INTO `material` (`material_no`, `material_des`, `company`) VALUES (100000001, '红酒', '荣国府');
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_no` bigint NOT NULL,
  `user_id` int DEFAULT NULL,
  `goods` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `to_adress` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `from_adress` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  UNIQUE KEY `order_order_no_uindex` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` (`order_no`, `user_id`, `goods`, `amount`, `to_adress`, `from_adress`, `create_date`, `update_date`) VALUES (100000001, 1, '红酒', 1, '怡红院', '潇湘馆', '2022-12-10 18:43:27', '2022-12-10 18:43:32');
COMMIT;

-- ----------------------------
-- Table structure for tc_user
-- ----------------------------
DROP TABLE IF EXISTS `tc_user`;
CREATE TABLE `tc_user` (
  `tc_id` bigint NOT NULL,
  `tc_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tc_age` int DEFAULT NULL,
  `tc_sex` int DEFAULT NULL,
  `tc_college` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tc_address_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `blocks` json DEFAULT NULL,
  PRIMARY KEY (`tc_id`),
  KEY `user_name_index` (`tc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of tc_user
-- ----------------------------
BEGIN;
INSERT INTO `tc_user` (`tc_id`, `tc_name`, `tc_age`, `tc_sex`, `tc_college`, `tc_address_info`, `blocks`) VALUES (1, '贾宝玉', 15, 1, '中学5', '怡红院', NULL);
INSERT INTO `tc_user` (`tc_id`, `tc_name`, `tc_age`, `tc_sex`, `tc_college`, `tc_address_info`, `blocks`) VALUES (2, '林黛玉', 13, 0, '中学3', '潇湘馆', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` int DEFAULT NULL,
  `college` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `blocks` json DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_name_index` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `name`, `age`, `sex`, `college`, `address`, `blocks`) VALUES (1, '贾宝玉', 15, 1, '中学5', '怡红院', '[{\"aaa\": \"1234\", \"bbb\": \"sadsa-2321-213-dsds\", \"ccc\": 1234, \"ddd\": 2}, {\"aaa\": \"1234\", \"bbb\": \"sadsa-2321-213-dsds\", \"ccc\": 1234, \"ddd\": 2}]');
INSERT INTO `user` (`id`, `name`, `age`, `sex`, `college`, `address`, `blocks`) VALUES (2, '林黛玉', 13, 0, '中学3', '潇湘馆', '[{\"aaa\": \"1234\", \"bbb\": \"sadsa-2321-213-dsds\", \"ccc\": 1234, \"ddd\": 2}, {\"aaa\": \"1234\", \"bbb\": \"sadsa-2321-213-dsds\", \"ccc\": 1234, \"ddd\": 2}]');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
