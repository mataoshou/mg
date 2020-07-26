/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17-log : Database - mg.frame.user
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mg.frame.user` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mg.frame.user`;

/*Table structure for table `m_td_action_info` */

DROP TABLE IF EXISTS `m_td_action_info`;

CREATE TABLE `m_td_action_info` (
  `id` bigint(11) DEFAULT NULL,
  `url` varchar(256) DEFAULT NULL,
  `displayName` varchar(128) DEFAULT NULL,
  `timeCreated` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `m_td_action_info` */

/*Table structure for table `m_td_user_info` */

DROP TABLE IF EXISTS `m_td_user_info`;

CREATE TABLE `m_td_user_info` (
  `id` bigint(11) DEFAULT NULL COMMENT 'id',
  `name` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `weixin` varchar(128) DEFAULT NULL,
  `weibo` varchar(128) DEFAULT NULL,
  `qq` varchar(128) DEFAULT NULL,
  `telephone` varchar(128) DEFAULT NULL,
  `displayName` varchar(128) DEFAULT NULL,
  `timeCreated` datetime DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `stataDelete` int(11) DEFAULT NULL,
  `timeDelete` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `m_td_user_info` */

insert  into `m_td_user_info`(`id`,`name`,`password`,`weixin`,`weibo`,`qq`,`telephone`,`displayName`,`timeCreated`,`level`,`stataDelete`,`timeDelete`) values (1,'mg','mg','mg','mg','mg','mg','马耿','2020-07-26 15:25:55',1,1,'2020-07-26 15:26:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
