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

insert  into `m_td_article_detail_info`(`id`,`content`,`status`,`link_items`) values (5,'12312312',NULL,NULL),(6,'12312312',NULL,NULL),(7,'12312312',NULL,NULL),(10001,'<p>\r\n    <strong>类加载器是做什么的，类需要加载到虚拟机中，类加载器负责将Java类加载到内存中，并生成Class类的实例对象。</strong>\r\n</p>\r\n<p>\r\n    <strong>一、简单使用类加载器</strong>\r\n</p>\r\n<p>\r\n    让我们一起通过一个例子来简单的使用类加载器加载class文件，并获取class对象\r\n</p>\r\n<p>\r\n    创建一个对象类\r\n</p>\r\n<blockquote>\r\n    <p>\r\n        public class DemoItem {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; public void demo()\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; System.out.println(&quot;demo!!&quot;);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; }\r\n    </p>\r\n    <p>\r\n        }\r\n    </p>\r\n</blockquote>\r\n<p>\r\n    将编译生成的class复制到E:/cltmp/路径下，并删除DemoItem这个类，防止会被默认加载，然后创建类加载器，并获取class文件加载类。\r\n</p>\r\n<div class=\"code-area\">\r\n<code>\r\n    <p>\r\n        URL url = new URL(&quot;file:/E:/cltmp/&quot;);\r\n    </p>\r\n    <p>\r\n        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});\r\n    </p>\r\n    <p>\r\n        Class cl = classLoader.loadClass(&quot;DemoItem&quot;);\r\n    </p>\r\n    <p>\r\n        System.out.println(cl.equals(cl));\r\n    </p>\r\n</code>\r\n</div>\r\n<p>\r\n    <strong>二、类加载器常用函数解析</strong>\r\n</p>\r\n<p>\r\n    现在已经使用类加载器获取到了DemoItem的class对象了。让我们一起看下类加载器中一个核心的函数loadClass(String name)，这个函数负责获取全名为name的类，返回对象为Class实例，代码如下\r\n</p>\r\n<blockquote>\r\n    <p>\r\n        protected Class&lt;?&gt; loadClass(String name, boolean resolve) throws ClassNotFoundException\r\n    </p>\r\n    <p>\r\n        {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; synchronized (getClassLoadingLock(name)) {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; // First, check if the class has already been loaded\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; Class&lt;?&gt; c = findLoadedClass(name);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; if (c == null) {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; long t0 = System.nanoTime();\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; try {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; if (parent != null) {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; c = parent.loadClass(name, false);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; } else {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; c = findBootstrapClassOrNull(name);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; }\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; } catch (ClassNotFoundException e) {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; // ClassNotFoundException thrown if class not found\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; // from the non-null parent class loader\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; }\r\n    </p>\r\n    <p>\r\n        <br/>\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; if (c == null) {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; // If still not found, then invoke findClass in order\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; // to find the class.\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; long t1 = System.nanoTime();\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; c = findClass(name);\r\n    </p>\r\n    <p>\r\n        <br/>\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; // this is the defining class loader; record the stats\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; sun.misc.PerfCounter.getFindClasses().increment();\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; }\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; }\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; if (resolve) {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; resolveClass(c);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; }\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; return c;\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; }\r\n    </p>\r\n    <p>\r\n        }\r\n    </p>\r\n</blockquote>\r\n<p>\r\n    loadClass中首先调用findLoadedClass查询类是否被当前类加载器加载，如果没有找到，则去父级类加载器，即扩展类加载器中parent.loadClass(name, false)查询是否已经加载，如果还是没有就到BootstrapClassLoader中查询是否加载，如果还是找不到，则类还没有加载，调用findClass()函数，查找加载路径下的class文件，如果还是找不到在findClass()函数中抛出ClassNotFoundException异常。\r\n</p>\r\n<p>\r\n    findClass这个函数负责将制定加载路径的class文件加载进虚拟机中，URLClassLoader中findClass函数代码如下\r\n</p>\r\n<blockquote>\r\n    <p>\r\n        protected Class&lt;?&gt; findClass(final String name) throws ClassNotFoundException\r\n    </p>\r\n    <p>\r\n        {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; final Class&lt;?&gt; result;\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; try {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; result = AccessController.doPrivileged(\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; new PrivilegedExceptionAction&lt;Class&lt;?&gt;&gt;() {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; public Class&lt;?&gt; run() throws ClassNotFoundException {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; String path = name.replace(&#39;.&#39;, &#39;/&#39;).concat(&quot;.class&quot;);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Resource res = ucp.getResource(path, false);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; if (res != null) {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; try {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; return defineClass(name, res);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; } catch (IOException e) {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; throw new ClassNotFoundException(name, e);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; }\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; } else {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; return null;\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; }\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; }\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; }, acc);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; } catch (java.security.PrivilegedActionException pae) {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; throw (ClassNotFoundException) pae.getException();\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; }\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; if (result == null) {\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; &nbsp; &nbsp; throw new ClassNotFoundException(name);\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; }\r\n    </p>\r\n    <p>\r\n        &nbsp; &nbsp; return result;\r\n    </p>\r\n    <p>\r\n        }\r\n    </p>\r\n</blockquote>\r\n<p>\r\n    到这里已经基本搞清楚类加载器怎么工作的了。\r\n</p>\r\n<p>\r\n    <br/>\r\n</p>',NULL,NULL),(10002,'<p>12312312</p>',NULL,NULL);

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
  `siteId` bigint(11) DEFAULT NULL COMMENT '栏目id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `m_td_article_info` */

insert  into `m_td_article_info`(`id`,`title`,`thumb`,`time_created`,`time_modefied`,`author`,`show_index`,`tags`,`ulr`,`siteId`) values (10001,'「JVM篇」初识类加载器',NULL,'2020-09-15 16:41:43','2020-09-15 17:06:58','mg驿站',0,NULL,'detail.html?id =10001',1),(10002,'「JVM篇」类加载器的三种分类及双亲委派模式原理详解',NULL,'2020-09-15 16:42:05','2020-09-15 17:07:11','mg驿站',0,NULL,'detail.html?id =10001',NULL),(10003,'jvm内存溢出',NULL,'2020-09-15 16:43:20','2020-09-15 16:43:20','mg驿站',0,NULL,'detail.html?id =10001',NULL),(10004,'jvm内存溢出',NULL,'2020-09-15 16:46:46','2020-09-15 16:46:46','mg驿站',0,NULL,'detail.html?id =10001',NULL),(10005,'jvm内存溢出',NULL,'2020-09-15 16:46:56','2020-09-15 16:46:56','mg驿站',0,NULL,'detail.html?id =10001',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
