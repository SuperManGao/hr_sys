-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.1.17-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 hr 的数据库结构
DROP DATABASE IF EXISTS `hr`;
CREATE DATABASE IF NOT EXISTS `hr` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hr`;


-- 导出  表 hr.hr_admin 结构
DROP TABLE IF EXISTS `hr_admin`;
CREATE TABLE IF NOT EXISTS `hr_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `adminlevel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  hr.hr_admin 的数据：~2 rows (大约)
DELETE FROM `hr_admin`;
/*!40000 ALTER TABLE `hr_admin` DISABLE KEYS */;
INSERT INTO `hr_admin` (`id`, `username`, `password`, `adminlevel`) VALUES
	(1, 'zhangsan', '111', '管理员'),
	(2, 'lisi', '111', '操作员'),
	(3, 'admin', 'admin', '管理员');
/*!40000 ALTER TABLE `hr_admin` ENABLE KEYS */;


-- 导出  表 hr.hr_dept 结构
DROP TABLE IF EXISTS `hr_dept`;
CREATE TABLE IF NOT EXISTS `hr_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(20) DEFAULT NULL,
  `dloc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  hr.hr_dept 的数据：~5 rows (大约)
DELETE FROM `hr_dept`;
/*!40000 ALTER TABLE `hr_dept` DISABLE KEYS */;
INSERT INTO `hr_dept` (`id`, `dname`, `dloc`) VALUES
	(1, '服务部', '1楼'),
	(2, '信息部', '7楼'),
	(3, '销售部', '3楼'),
	(4, '产品部', '4楼'),
	(5, '生产部', '6楼'),
	(6, '餐饮部', '2楼');
/*!40000 ALTER TABLE `hr_dept` ENABLE KEYS */;


-- 导出  表 hr.hr_emp 结构
DROP TABLE IF EXISTS `hr_emp`;
CREATE TABLE IF NOT EXISTS `hr_emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `etel` varchar(20) DEFAULT NULL,
  `edate` varchar(40) DEFAULT NULL,
  `esal` int(11) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dept_fk` (`did`),
  KEY `job_fk` (`jid`),
  CONSTRAINT `dept_fk` FOREIGN KEY (`did`) REFERENCES `hr_dept` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `job_fk` FOREIGN KEY (`jid`) REFERENCES `hr_job` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  hr.hr_emp 的数据：~5 rows (大约)
DELETE FROM `hr_emp`;
/*!40000 ALTER TABLE `hr_emp` DISABLE KEYS */;
INSERT INTO `hr_emp` (`id`, `ename`, `email`, `etel`, `edate`, `esal`, `did`, `jid`) VALUES
	(1, '张伟', '962163445@qq.com', '15641696968', '2014-9-8', 4, 2, 1),
	(2, '斯塔克', 'stack@dingtalk.com', '15641685', '2015-6-7', 3500, 2, 2),
	(3, '小桃红', 'xiaotaohong@qq.com', '18355943253', '2018-7-9', 7000, 4, 4),
	(4, '三等', '962163445@qq.com', '15641696968', '2013-11-8', 5000, 5, 3),
	(5, '更何况', '346545@qq.com', '15745312342', '2018-9-7', 3800, 2, 1);
/*!40000 ALTER TABLE `hr_emp` ENABLE KEYS */;


-- 导出  表 hr.hr_job 结构
DROP TABLE IF EXISTS `hr_job`;
CREATE TABLE IF NOT EXISTS `hr_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jname` varchar(255) DEFAULT NULL,
  `jlow` int(11) DEFAULT NULL,
  `jhig` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  hr.hr_job 的数据：~5 rows (大约)
DELETE FROM `hr_job`;
/*!40000 ALTER TABLE `hr_job` DISABLE KEYS */;
INSERT INTO `hr_job` (`id`, `jname`, `jlow`, `jhig`) VALUES
	(1, '文员', 1500, 3000),
	(2, '技术工', 3000, 10000),
	(3, '产品经理', 5000, 10000),
	(4, '设计师', 6000, 9000),
	(5, '老总', 80000, 1000000);
/*!40000 ALTER TABLE `hr_job` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
