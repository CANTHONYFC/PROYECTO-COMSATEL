/*
Navicat MySQL Data Transfer

Source Server         : LOCAL
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : comsatel

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2021-01-18 22:41:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for all_sequences
-- ----------------------------
DROP TABLE IF EXISTS `all_sequences`;
CREATE TABLE `all_sequences` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of all_sequences
-- ----------------------------

-- ----------------------------
-- Table structure for com_grupo
-- ----------------------------
DROP TABLE IF EXISTS `com_grupo`;
CREATE TABLE `com_grupo` (
  `id` int(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of com_grupo
-- ----------------------------
INSERT INTO `com_grupo` VALUES ('1', 'Labores del Dia semana', '1');
INSERT INTO `com_grupo` VALUES ('2', 'Compras de Fin Semana', '1');

-- ----------------------------
-- Table structure for com_grupo_detalle
-- ----------------------------
DROP TABLE IF EXISTS `com_grupo_detalle`;
CREATE TABLE `com_grupo_detalle` (
  `id` int(11) NOT NULL,
  `idgrupo` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of com_grupo_detalle
-- ----------------------------
INSERT INTO `com_grupo_detalle` VALUES ('1', '1', '1', 'Reunion Diaria 08:30 am');
INSERT INTO `com_grupo_detalle` VALUES ('2', '1', '1', 'Coordinar Reunion con el Area Comercial');
INSERT INTO `com_grupo_detalle` VALUES ('3', '1', '1', 'Hacer el Alcance para Quimica Suiza');
INSERT INTO `com_grupo_detalle` VALUES ('4', '1', '1', 'Alineacion Ramas');
INSERT INTO `com_grupo_detalle` VALUES ('6', '2', '1', 'PRUEBA');
