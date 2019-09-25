/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.15 : Database - crm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `crm`;

/*Table structure for table `base_dict` */

DROP TABLE IF EXISTS `base_dict`;

CREATE TABLE `base_dict` (
  `dict_id` varchar(32) NOT NULL COMMENT '数据字典id(主键)',
  `dict_type_code` varchar(10) NOT NULL COMMENT '数据字典类别代码',
  `dict_type_name` varchar(64) NOT NULL COMMENT '数据字典类别名称',
  `dict_item_name` varchar(64) NOT NULL COMMENT '数据字典项目名称',
  `dict_item_code` varchar(10) DEFAULT NULL COMMENT '数据字典项目(可为空)',
  `dict_sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `dict_enable` char(1) NOT NULL COMMENT '1:使用 0:停用',
  `dict_memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `base_dict` */

insert  into `base_dict`(`dict_id`,`dict_type_code`,`dict_type_name`,`dict_item_name`,`dict_item_code`,`dict_sort`,`dict_enable`,`dict_memo`) values ('1','001','客户行业','教育培训 ',NULL,1,'1',NULL),('10','003','公司性质','民企',NULL,3,'1',NULL),('12','004','年营业额','1-10万',NULL,1,'1',NULL),('13','004','年营业额','10-20万',NULL,2,'1',NULL),('14','004','年营业额','20-50万',NULL,3,'1',NULL),('15','004','年营业额','50-100万',NULL,4,'1',NULL),('16','004','年营业额','100-500万',NULL,5,'1',NULL),('17','004','年营业额','500-1000万',NULL,6,'1',NULL),('18','005','客户状态','基础客户',NULL,1,'1',NULL),('19','005','客户状态','潜在客户',NULL,2,'1',NULL),('2','001','客户行业','电子商务',NULL,2,'1',NULL),('20','005','客户状态','成功客户',NULL,3,'1',NULL),('21','005','客户状态','无效客户',NULL,4,'1',NULL),('22','006','客户级别','普通客户',NULL,1,'1',NULL),('23','006','客户级别','VIP客户',NULL,2,'1',NULL),('24','007','商机状态','意向客户',NULL,1,'1',NULL),('25','007','商机状态','初步沟通',NULL,2,'1',NULL),('26','007','商机状态','深度沟通',NULL,3,'1',NULL),('27','007','商机状态','签订合同',NULL,4,'1',NULL),('3','001','客户行业','对外贸易',NULL,3,'1',NULL),('30','008','商机类型','新业务',NULL,1,'1',NULL),('31','008','商机类型','现有业务',NULL,2,'1',NULL),('32','009','商机来源','电话营销',NULL,1,'1',NULL),('33','009','商机来源','网络营销',NULL,2,'1',NULL),('34','009','商机来源','推广活动',NULL,3,'1',NULL),('4','001','客户行业','酒店旅游',NULL,4,'1',NULL),('5','001','客户行业','房地产',NULL,5,'1',NULL),('6','002','客户信息来源','电话营销',NULL,1,'1',NULL),('7','002','客户信息来源','网络营销',NULL,2,'1',NULL),('8','003','公司性质','合资',NULL,1,'1',NULL),('9','003','公司性质','国企',NULL,2,'1',NULL);

/*Table structure for table `cst_customer` */

DROP TABLE IF EXISTS `cst_customer`;

CREATE TABLE `cst_customer` (
  `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
  `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
  `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
  `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
  `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
  `cust_phone` varchar(64) DEFAULT NULL COMMENT '固定电话',
  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '移动电话',
  `cust_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`),
  KEY `FKeh5g36duab8g1h051pdjfwcgd` (`cust_source`),
  KEY `FK2xhr3arwp3tkuae1da4lqv352` (`cust_industry`),
  KEY `FKrty52nvbjg1echf0se39eng49` (`cust_level`),
  CONSTRAINT `FK2xhr3arwp3tkuae1da4lqv352` FOREIGN KEY (`cust_industry`) REFERENCES `base_dict` (`dict_id`),
  CONSTRAINT `FKeh5g36duab8g1h051pdjfwcgd` FOREIGN KEY (`cust_source`) REFERENCES `base_dict` (`dict_id`),
  CONSTRAINT `FKrty52nvbjg1echf0se39eng49` FOREIGN KEY (`cust_level`) REFERENCES `base_dict` (`dict_id`),
  CONSTRAINT `cst_customer_0001` FOREIGN KEY (`cust_source`) REFERENCES `base_dict` (`dict_id`),
  CONSTRAINT `cst_customer_0002` FOREIGN KEY (`cust_level`) REFERENCES `base_dict` (`dict_id`),
  CONSTRAINT `cst_customer_0003` FOREIGN KEY (`cust_industry`) REFERENCES `base_dict` (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `cst_customer` */

insert  into `cst_customer`(`cust_id`,`cust_name`,`cust_source`,`cust_industry`,`cust_level`,`cust_phone`,`cust_mobile`,`cust_image`) values (1,'张无忌','6','2','22','10086','10011',NULL),(2,'殷素素','6','2','22','10086','10011',NULL),(3,'张翠山','6','2','22','10086','10011',NULL),(4,'殷野王222','6','2','22','10086','10011',''),(6,'杨逍','6','2','22','10086','10011',NULL),(7,'金庸','6','1','22','123','456',NULL),(8,'萧峰','7','1','22','12345','456','F:/upload/1/2/a07967f43ef64f9f8b4adc8d87de2c60.jpg'),(9,'深圳有限公司','7','1','23','312','123','F:/upload/10/7/85a2e75158554350b6e0e802e639e62d.jpg');

/*Table structure for table `cst_linkman` */

DROP TABLE IF EXISTS `cst_linkman`;

CREATE TABLE `cst_linkman` (
  `lkm_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '联系人编号(主键)',
  `lkm_name` varchar(16) DEFAULT NULL COMMENT '联系人姓名',
  `lkm_cust_id` bigint(32) DEFAULT NULL COMMENT '客户id',
  `lkm_gender` char(1) DEFAULT NULL COMMENT '联系人性别',
  `lkm_phone` varchar(16) DEFAULT NULL COMMENT '联系人办公电话',
  `lkm_mobile` varchar(16) DEFAULT NULL COMMENT '联系人手机',
  `lkm_email` varchar(64) DEFAULT NULL COMMENT '联系人邮箱',
  `lkm_qq` varchar(16) DEFAULT NULL COMMENT '联系人qq',
  `lkm_position` varchar(16) DEFAULT NULL COMMENT '联系人职位',
  `lkm_memo` varchar(512) DEFAULT NULL COMMENT '联系人备注',
  PRIMARY KEY (`lkm_id`),
  KEY `FK_cst_linkman_lkm_cust_id` (`lkm_cust_id`),
  CONSTRAINT `FK_cst_linkman_lkm_cust_id` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`),
  CONSTRAINT `FKh9yp1nql5227xxcopuxqx2e7q` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `cst_linkman` */

insert  into `cst_linkman`(`lkm_id`,`lkm_name`,`lkm_cust_id`,`lkm_gender`,`lkm_phone`,`lkm_mobile`,`lkm_email`,`lkm_qq`,`lkm_position`,`lkm_memo`) values (3,'张无忌',1,'1','123','123 ','123@qq.com','123','经理',NULL),(4,'殷素素',2,'2','123','123','123@qq.com','123','员工',NULL),(5,'张翠山',3,'1','12345','123','123@qq.com','123','员工',''),(6,'张三丰',4,'1','123','123','123@qq.com','123','经理',NULL);

/*Table structure for table `sale_visit` */

DROP TABLE IF EXISTS `sale_visit`;

CREATE TABLE `sale_visit` (
  `visit_id` varchar(32) NOT NULL,
  `visit_cust_id` bigint(32) DEFAULT NULL COMMENT '客户id',
  `visit_user_id` bigint(32) DEFAULT NULL COMMENT '负责人id',
  `visit_time` datetime DEFAULT NULL COMMENT '拜访时间',
  `visit_addr` varchar(128) DEFAULT NULL COMMENT '拜访地点',
  `visit_detail` varchar(256) DEFAULT NULL COMMENT '拜访详情',
  `visit_nexttime` date DEFAULT NULL COMMENT '下次拜访时间',
  PRIMARY KEY (`visit_id`),
  KEY `FK_sale_visit_cust_id` (`visit_cust_id`),
  KEY `FK_sale_visit_user_id` (`visit_user_id`),
  CONSTRAINT `FK_sale_visit_cust_id` FOREIGN KEY (`visit_cust_id`) REFERENCES `cst_customer` (`cust_id`),
  CONSTRAINT `FK_sale_visit_user_id` FOREIGN KEY (`visit_user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `FKc92iepd26mixxfiris92hccjx` FOREIGN KEY (`visit_user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `FKgr4aivocixwcvkwxcmc0b4css` FOREIGN KEY (`visit_cust_id`) REFERENCES `cst_customer` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sale_visit` */

insert  into `sale_visit`(`visit_id`,`visit_cust_id`,`visit_user_id`,`visit_time`,`visit_addr`,`visit_detail`,`visit_nexttime`) values ('1',1,1,'2019-06-19 15:29:57','深圳宝安区','洽谈购买','2019-06-19'),('2',2,1,'2019-06-19 15:29:59','深圳福田区','洽谈购买','2019-06-20'),('3',1,1,'2019-05-30 15:30:01','深圳南山区','洽谈购买','2019-06-14'),('4',2,1,'2019-06-08 15:30:04','深圳罗湖区','洽谈购买','2019-06-06'),('402812816b6eeb61016b6eebe2ac0000',1,2,'2019-06-19 00:00:00','光明顶','第一次切磋','2019-06-20');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_code` varchar(32) NOT NULL COMMENT '用户账号',
  `user_name` varchar(64) NOT NULL COMMENT '用户名称',
  `user_password` varchar(32) NOT NULL COMMENT '用户密码',
  `user_state` char(1) NOT NULL COMMENT '1:正常,0:暂停',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`user_code`,`user_name`,`user_password`,`user_state`) values (1,'fff','发方法','343d9040a671c45832ee5381860e2996','1'),(2,'duanyu','段誉','343d9040a671c45832ee5381860e2996','1'),(3,'dzc','段正淳','343d9040a671c45832ee5381860e2996','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
