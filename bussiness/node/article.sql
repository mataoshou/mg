/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.31 : Database - mg.frame.website
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mg.frame.website` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mg.frame.website`;

/*Table structure for table `m_td_article_detail_info` */

DROP TABLE IF EXISTS `m_td_article_detail_info`;

CREATE TABLE `m_td_article_detail_info` (
  `id` bigint(11) NOT NULL,
  `content` text COMMENT '内容',
  `status` int(11) DEFAULT NULL,
  `link_items` varchar(128) DEFAULT NULL COMMENT 'id  用，分割',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `m_td_article_detail_info` */

insert  into `m_td_article_detail_info`(`id`,`content`,`status`,`link_items`) values (3,'12312312',NULL,NULL),(4,'12312312',NULL,NULL),(5,'12312312',NULL,NULL),(6,'12312312',NULL,NULL),(7,'12312312',NULL,NULL);

/*Table structure for table `m_td_article_info` */

DROP TABLE IF EXISTS `m_td_article_info`;

CREATE TABLE `m_td_article_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) DEFAULT NULL COMMENT '标题',
  `thumb` varchar(1024) DEFAULT NULL COMMENT '缩略图',
  `time_created` datetime DEFAULT NULL COMMENT '创建时间',
  `time_modefied` datetime DEFAULT NULL COMMENT '修改时间',
  `author` varchar(256) DEFAULT NULL COMMENT '作者',
  `show_index` int(11) DEFAULT NULL COMMENT '排序',
  `tags` varchar(256) DEFAULT NULL COMMENT '标签  用 | 分割',
  `ulr` varchar(1024) DEFAULT NULL COMMENT '链接地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `m_td_article_info` */

insert  into `m_td_article_info`(`id`,`title`,`thumb`,`time_created`,`time_modefied`,`author`,`show_index`,`tags`,`ulr`) values (3,'jvm内存溢出1111',NULL,'2020-09-15 16:41:43','2020-09-15 17:06:58','mg驿站',0,NULL,NULL),(4,'jvm内存溢出1111',NULL,'2020-09-15 16:42:05','2020-09-15 17:07:11','mg驿站',0,NULL,NULL),(5,'jvm内存溢出',NULL,'2020-09-15 16:43:20','2020-09-15 16:43:20','mg驿站',0,NULL,NULL),(6,'jvm内存溢出',NULL,'2020-09-15 16:46:46','2020-09-15 16:46:46','mg驿站',0,NULL,NULL),(7,'jvm内存溢出',NULL,'2020-09-15 16:46:56','2020-09-15 16:46:56','mg驿站',0,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
