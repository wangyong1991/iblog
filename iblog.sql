/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost
 Source Database       : iblog

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : utf-8

 Date: 05/01/2016 11:42:37 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(19) NOT NULL,
  `name` varchar(25) NOT NULL,
  `leftv` int(11) NOT NULL,
  `rightv` int(11) NOT NULL,
  `visible` tinyint(1) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` varchar(19) NOT NULL,
  `postId` varchar(19) NOT NULL,
  `parent` varchar(19) DEFAULT NULL,
  `creator` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `url` varchar(100) NOT NULL,
  `agent` varchar(120) NOT NULL,
  `ip` varchar(15) NOT NULL,
  `content` varchar(200) NOT NULL,
  `status` enum('wait','approve','reject','trash') NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `link`
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `id` varchar(19) NOT NULL,
  `name` varchar(80) NOT NULL,
  `url` varchar(100) NOT NULL,
  `notes` varchar(150) DEFAULT NULL,
  `visible` tinyint(1) NOT NULL,
  `creator` varchar(20) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `option`
-- ----------------------------
DROP TABLE IF EXISTS `option`;
CREATE TABLE `option` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `value` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` varchar(19) NOT NULL,
  `title` varchar(100) NOT NULL,
  `excerpt` varchar(350) DEFAULT NULL,
  `content` mediumtext NOT NULL,
  `type` enum('post','page') NOT NULL,
  `parent` varchar(19) DEFAULT NULL,
  `categoryId` varchar(19) DEFAULT NULL,
  `pstatus` varchar(10) NOT NULL,
  `cstatus` varchar(10) NOT NULL,
  `ccount` int(11) NOT NULL,
  `rcount` int(11) NOT NULL,
  `creator` varchar(19) NOT NULL,
  `createTime` datetime NOT NULL,
  `lastUpdate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tag`
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` varchar(19) NOT NULL,
  `name` varchar(15) NOT NULL,
  `postId` varchar(19) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `upload`
-- ----------------------------
DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload` (
  `id` varchar(19) NOT NULL,
  `postId` varchar(19) DEFAULT NULL,
  `name` varchar(80) NOT NULL,
  `path` varchar(100) NOT NULL,
  `creator` varchar(25) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(19) NOT NULL,
  `nickName` varchar(25) NOT NULL,
  `realName` varchar(25) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(30) NOT NULL,
  `status` varchar(10) NOT NULL,
  `role` enum('admin','editor','contributor') NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `createTime` datetime NOT NULL,
  `creator` varchar(15) DEFAULT NULL,
  `lastUpdate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
