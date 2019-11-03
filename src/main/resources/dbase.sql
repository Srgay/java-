/*
Navicat MySQL Data Transfer

Source Server         : aaaa
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : dbase

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-11-01 18:42:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buyer
-- ----------------------------
DROP TABLE IF EXISTS `buyer`;
CREATE TABLE `buyer` (
  `id` varchar(3) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of buyer
-- ----------------------------
INSERT INTO `buyer` VALUES ('101', 'a001', 'a001', '18', 'M', '13011112222', 'ZhengzhouCity');
INSERT INTO `buyer` VALUES ('103', 'a003', 'a003', '31', 'M', '13055556666', 'XianCity');
INSERT INTO `buyer` VALUES ('111', '1', '1', '1', 'm', '1', '1');

-- ----------------------------
-- Table structure for orderr
-- ----------------------------
DROP TABLE IF EXISTS `orderr`;
CREATE TABLE `orderr` (
  `id` varchar(255) NOT NULL,
  `item` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` int(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of orderr
-- ----------------------------
INSERT INTO `orderr` VALUES ('1572599868602', '111111*1，1233*1，452*1，', '12798');
INSERT INTO `orderr` VALUES ('1572600120037', '111111*1，', '11111');
INSERT INTO `orderr` VALUES ('1572600158669', '1233*1，111111*1，', '12344');
INSERT INTO `orderr` VALUES ('2', '111，222，333', '222');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `stock` int(255) DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('1', '111111', '2', '11111');
INSERT INTO `stock` VALUES ('123', '1233', '1233', '1233');
INSERT INTO `stock` VALUES ('451', '452', '453', '454');
