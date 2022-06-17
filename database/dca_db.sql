/*
SQLyog Ultimate v8.82 
MySQL - 5.5.5-10.4.6-MariaDB : Database - open_recruitment_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`open_recruitment_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `open_recruitment_db`;

/*Table structure for table `job_seeker_hobby` */

DROP TABLE IF EXISTS `job_seeker_hobby`;

CREATE TABLE `job_seeker_hobby` (
  `hobbyId` varchar(255) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `userId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hobbyId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_seeker_hobby` */

insert  into `job_seeker_hobby`(`hobbyId`,`createdBy`,`createdDate`,`hobby`,`updatedBy`,`updatedDate`,`userId`) values ('1cb2a567-2e3e-4abd-9c71-a6c191c1618c','8f844077-9e23-49c7-86e6-82ada741ec14','2022-06-10 09:43:44','c',NULL,NULL,'8f844077-9e23-49c7-86e6-82ada741ec14'),('57c6778b-b436-4555-a815-9f727c200d96','b4de62e5-0858-479d-8949-b8234002d837','2022-06-10 09:45:05','apple',NULL,NULL,'b4de62e5-0858-479d-8949-b8234002d837'),('8c4014f0-8514-4767-9d09-1e459bb1c149','13924136-a821-4c34-af8c-123243682cb4','2022-06-15 11:08:08','byh',NULL,NULL,'13924136-a821-4c34-af8c-123243682cb4');

/*Table structure for table `job_seeker_info` */

DROP TABLE IF EXISTS `job_seeker_info`;

CREATE TABLE `job_seeker_info` (
  `jobSeekerInfoId` varchar(255) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `cid` varchar(255) DEFAULT NULL,
  `currentAddress` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `dzongkhag` varchar(255) DEFAULT NULL,
  `fatherName` varchar(255) DEFAULT NULL,
  `geog` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `userId` varchar(255) DEFAULT NULL,
  `village` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`jobSeekerInfoId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_seeker_info` */

insert  into `job_seeker_info`(`jobSeekerInfoId`,`createdBy`,`createdDate`,`cid`,`currentAddress`,`description`,`dob`,`dzongkhag`,`fatherName`,`geog`,`updatedBy`,`updatedDate`,`userId`,`village`) values ('b86d63d3-56bc-4b64-946a-1513a9e805c8','13924136-a821-4c34-af8c-123243682cb4','2022-06-15 11:08:07','23423','Bhuta','ar','2022-06-13 18:00:00',NULL,NULL,NULL,NULL,NULL,'13924136-a821-4c34-af8c-123243682cb4',NULL),('d952ba46-ea88-4de5-9cd1-9e1d7197ce7f','b4de62e5-0858-479d-8949-b8234002d837','2022-06-10 09:45:05','212','apple','apple','2022-06-16 18:00:00',NULL,NULL,NULL,NULL,NULL,'b4de62e5-0858-479d-8949-b8234002d837',NULL),('e7228864-75ed-481a-b71e-dfb4ca59f8c9','8f844077-9e23-49c7-86e6-82ada741ec14','2022-06-10 09:43:44','11514000454','ba','a','1990-12-31 18:00:00',NULL,NULL,NULL,NULL,NULL,'8f844077-9e23-49c7-86e6-82ada741ec14',NULL);

/*Table structure for table `job_seeker_skill` */

DROP TABLE IF EXISTS `job_seeker_skill`;

CREATE TABLE `job_seeker_skill` (
  `skillId` varchar(255) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `skill` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `userId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`skillId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_seeker_skill` */

insert  into `job_seeker_skill`(`skillId`,`createdBy`,`createdDate`,`skill`,`updatedBy`,`updatedDate`,`userId`) values ('1b73cf89-43d4-4a9c-841d-03ac09473073','8f844077-9e23-49c7-86e6-82ada741ec14','2022-06-10 09:43:44','b',NULL,NULL,'8f844077-9e23-49c7-86e6-82ada741ec14'),('84522954-ebba-41b0-9e40-cf42722642a3','13924136-a821-4c34-af8c-123243682cb4','2022-06-15 11:08:08','dgg',NULL,NULL,'13924136-a821-4c34-af8c-123243682cb4'),('eb6f1a98-0a53-4f9e-ae99-3c0d1085a8e1','b4de62e5-0858-479d-8949-b8234002d837','2022-06-10 09:45:05','apple',NULL,NULL,'b4de62e5-0858-479d-8949-b8234002d837');

/*Table structure for table `sa_roles` */

DROP TABLE IF EXISTS `sa_roles`;

CREATE TABLE `sa_roles` (
  `roleId` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sa_roles` */

insert  into `sa_roles`(`roleId`,`name`) values (1,'ROLE_USER'),(2,'ROLE_MODERATOR'),(3,'ROLE_ADMIN');

/*Table structure for table `sa_user_roles` */

DROP TABLE IF EXISTS `sa_user_roles`;

CREATE TABLE `sa_user_roles` (
  `userId` varchar(255) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `FKtgbcn0y50rx9fhbub55ys443j` (`roleId`),
  CONSTRAINT `FK9qkd7k12h5mo04mhch7840miu` FOREIGN KEY (`userId`) REFERENCES `sa_users` (`userId`),
  CONSTRAINT `FKtgbcn0y50rx9fhbub55ys443j` FOREIGN KEY (`roleId`) REFERENCES `sa_roles` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sa_user_roles` */

insert  into `sa_user_roles`(`userId`,`roleId`) values ('13924136-a821-4c34-af8c-123243682cb4',1),('8f844077-9e23-49c7-86e6-82ada741ec14',1),('ae8d5653-b92a-41c7-87d6-fee6983a2009',1),('b4de62e5-0858-479d-8949-b8234002d837',1),('b8cb852d-7f2d-4e96-b3f8-76508ac069a3',1);

/*Table structure for table `sa_users` */

DROP TABLE IF EXISTS `sa_users`;

CREATE TABLE `sa_users` (
  `userId` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `UK3u6eijf4cc4fhq00ant24ca96` (`username`),
  UNIQUE KEY `UK6rktuyxypfb5q1yb4qy2db08e` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sa_users` */

insert  into `sa_users`(`userId`,`email`,`fullName`,`password`,`username`) values ('13924136-a821-4c34-af8c-123243682cb4','ndsfa@gmail.com',NULL,'$2a$10$mJ9oPlXZLjEpBB8xc7gazOoywLfgn3THaWkAxFlf9jmx6vloe3Am.',NULL),('8f844077-9e23-49c7-86e6-82ada741ec14','z@gmail.com',NULL,'$2a$10$pPC0ghdT6Y7n46DV73KP.e92cOZIDuWqNsbrOhrVfbSARkMT0fqly','dsfsd'),('ae8d5653-b92a-41c7-87d6-fee6983a2009','mm@mfa.com',NULL,'$2a$10$gwZQbRgYfLAl2yrbcXFCjOJDLlw1Z6LDgMHG9CBZCnfdL/d1/1QFW','ff'),('b4de62e5-0858-479d-8949-b8234002d837','apple',NULL,'$2a$10$MBNdyrqvlzxUL41V/BonQO.U6Px3BG55zGdamSX.pmlDhC5.wQUGy','apple'),('b8cb852d-7f2d-4e96-b3f8-76508ac069a3','zepa@gmail.com','Zepa','$2a$10$1clNkrFHFaXZ4FZZaB/QMunDa6a.6CEhI1zwEqtmie0YxZtZPDSXG','zepa');

/*Table structure for table `social_media` */

DROP TABLE IF EXISTS `social_media`;

CREATE TABLE `social_media` (
  `socialMediaId` varchar(255) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `userId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`socialMediaId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `social_media` */

insert  into `social_media`(`socialMediaId`,`createdBy`,`createdDate`,`link`,`updatedBy`,`updatedDate`,`userId`) values ('68a25699-041c-4732-bc6f-35132992aa25','b4de62e5-0858-479d-8949-b8234002d837','2022-06-10 09:45:05','apple',NULL,NULL,'b4de62e5-0858-479d-8949-b8234002d837'),('6a8f7009-503d-4ac4-b209-7969807e8505','8f844077-9e23-49c7-86e6-82ada741ec14','2022-06-10 09:43:44','a',NULL,NULL,'8f844077-9e23-49c7-86e6-82ada741ec14'),('7e86bef5-5f1a-407c-a0e6-6700c186e695','13924136-a821-4c34-af8c-123243682cb4','2022-06-15 11:08:08','c',NULL,NULL,'13924136-a821-4c34-af8c-123243682cb4'),('7ee5bd70-3bd2-479d-9a5a-e6fc0128cbed','13924136-a821-4c34-af8c-123243682cb4','2022-06-15 11:08:08','b',NULL,NULL,'13924136-a821-4c34-af8c-123243682cb4'),('e03b3105-da1b-436e-a103-be2d4c7e27ea','13924136-a821-4c34-af8c-123243682cb4','2022-06-15 11:08:08','a',NULL,NULL,'13924136-a821-4c34-af8c-123243682cb4'),('f48399f0-3fdd-4a94-8c72-d812cd9ce85b','b4de62e5-0858-479d-8949-b8234002d837','2022-06-10 09:45:05','b',NULL,NULL,'b4de62e5-0858-479d-8949-b8234002d837'),('fb1d1c6f-d78f-4dae-a759-c1351d829f1e','8f844077-9e23-49c7-86e6-82ada741ec14','2022-06-10 09:43:44','b',NULL,NULL,'8f844077-9e23-49c7-86e6-82ada741ec14');

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `access_token` varchar(255) DEFAULT NULL,
  `created_on` decimal(19,2) DEFAULT NULL,
  `expires_in` int(11) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `token_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `token` */

insert  into `token`(`id`,`access_token`,`created_on`,`expires_in`,`scope`,`token_type`) values (3,'d6412e57-5600-3253-8985-2d80c958c83b','1655117327683.00',665,'am_application_scope default','Bearer');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
