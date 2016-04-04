/*
SQLyog Ultimate v12.09 (32 bit)
MySQL - 5.6.26-log : Database - vshop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vshop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vshop`;

/*Table structure for table `sys` */

DROP TABLE IF EXISTS `sys`;

CREATE TABLE `sys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_level` int(11) NOT NULL DEFAULT '1' COMMENT '1;B:2;C:3;D:4;E:5)',
  `user_min` int(11) NOT NULL COMMENT '最小金额',
  `user_max` int(11) NOT NULL COMMENT '最大金额',
  `user_money` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '奖金金额',
  `created_time` bigint(20) NOT NULL COMMENT '创建时间',
  `creator` varchar(50) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys` */

insert  into `sys`(`id`,`user_level`,`user_min`,`user_max`,`user_money`,`created_time`,`creator`) values (1,1,1,10,'100',1443084405656,'alison'),(2,2,21,30,'110',1443084405656,'alison'),(3,3,31,40,'120',1443084405656,'alison'),(4,4,41,50,'130',1443084405656,'alison'),(5,5,51,60,'140',1443084405656,'alison');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户登录ID',
  `user_id` varchar(50) NOT NULL COMMENT '用户登录账号',
  `user_pass` varchar(50) NOT NULL COMMENT '用户登录密码',
  `user_level` int(11) DEFAULT '0' COMMENT '用户处在树形结构第几级',
  `left_num` int(11) NOT NULL DEFAULT '0' COMMENT '左侧树形',
  `right_num` int(11) NOT NULL DEFAULT '0' COMMENT '右侧树形',
  `user_name` varchar(50) NOT NULL COMMENT '登录用户名',
  `user_birthday` varchar(10) NOT NULL COMMENT '出生日期，格式"2015-12-21"',
  `user_answer` varchar(100) DEFAULT NULL COMMENT '密保答案',
  `user_faq` int(11) DEFAULT '0' COMMENT '密保',
  `user_city` varchar(200) NOT NULL COMMENT '城市',
  `user_creator` varchar(50) NOT NULL COMMENT '创建人',
  `created_time` bigint(20) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`user_id`,`user_pass`,`user_level`,`left_num`,`right_num`,`user_name`,`user_birthday`,`user_answer`,`user_faq`,`user_city`,`user_creator`,`created_time`) values (1,'alison','6512bd43d9caa6e02c990b0a82652dca',1,1,10,'默然','1992-09-24','广师西区',3,'广州','alison',1443084405656),(30,'pamgo','b59c67bf196a4758191e42f76670ceba',2,2,7,'墨冰','2011-12-07',NULL,0,'上海','alison',1450853709766),(31,'Tom','b0baee9d279d34fa1dfd71aadb908c3f',3,3,4,'汤姆','2015-11-30',NULL,0,'上海','pamgo',1450853803458),(32,'pamgoTom','b59c67bf196a4758191e42f76670ceba',3,5,6,'pt','2011-12-06',NULL,0,'上海','pamgo',1450854013940),(33,'alisontom','b59c67bf196a4758191e42f76670ceba',2,8,9,'at','2010-11-11',NULL,0,'上海','alison',1450854252987);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
