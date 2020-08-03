/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.31 : Database - mg.frame.sys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mg.frame.sys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mg.frame.sys`;

/*Table structure for table `m_td_sys_config` */

DROP TABLE IF EXISTS `m_td_sys_config`;

CREATE TABLE `m_td_sys_config` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `showType` int(11) DEFAULT NULL COMMENT '显示类型  1  文本   2 下拉',
  `controlType` int(11) DEFAULT NULL COMMENT '类型  1 全配置  2 单系统配置',
  `value` varchar(128) DEFAULT NULL COMMENT '配置值',
  `dataSource` varchar(512) DEFAULT NULL COMMENT '配置数据源  或 默认值',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `siteId` bigint(11) DEFAULT NULL COMMENT '站点id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `m_td_sys_config` */

insert  into `m_td_sys_config`(`id`,`name`,`showType`,`controlType`,`value`,`dataSource`,`description`,`siteId`) values (1,'111',11,11,'11','11','11',1);

/*Table structure for table `m_td_sys_site` */

DROP TABLE IF EXISTS `m_td_sys_site`;

CREATE TABLE `m_td_sys_site` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `siteName` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `displayName` varchar(128) DEFAULT NULL,
  `siteType` int(11) DEFAULT NULL COMMENT '站点类型  1 webiste  2 compose   3 node   4 normal',
  `timeCreated` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `m_td_sys_site` */

insert  into `m_td_sys_site`(`id`,`siteName`,`password`,`displayName`,`siteType`,`timeCreated`) values (1,'222','222','222',222,'2020-08-03 16:59:17');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
