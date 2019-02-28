-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.3.9-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- hrdb 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `hrdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hrdb`;

-- 테이블 hrdb.employee 구조 내보내기
CREATE TABLE IF NOT EXISTS `employee` (
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_NUM` varchar(10) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `HOME_ADDR1` varchar(200) DEFAULT NULL,
  `HOME_ADDR2` varchar(200) DEFAULT NULL,
  `HOME_ZIPCODE` varchar(10) DEFAULT NULL,
  `BIRTH_YEAR` int(11) DEFAULT NULL,
  `TEAM_ID` int(11) DEFAULT NULL,
  `JOINED_DATE` date DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 테이블 데이터 hrdb.employee:~7 rows (대략적) 내보내기
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`EMPLOYEE_ID`, `EMPLOYEE_NUM`, `NAME`, `HOME_ADDR1`, `HOME_ADDR2`, `HOME_ZIPCODE`, `BIRTH_YEAR`, `TEAM_ID`, `JOINED_DATE`) VALUES
	(1, '1234567890', '최범균', '서울시', '관악구', '123456', 1977, 1, '2011-07-01'),
	(2, '1234567891', '홍길동', '전라남도 장성군', '황룡면', '515813', 1983, 1, '2013-01-02'),
	(3, '1234567892', '이순신', '서울시 중구', '인현동', '100282', 1982, 1, '2013-02-01'),
	(4, '1234567893', '김구', '황해도 해주', '백운방 텃골', '111222', 1979, 1, '2013-03-01'),
	(5, '1234567894', '전길남', '일본', '오사카', 'XXXYYY', 1943, 1, '2014-01-02'),
	(6, '1234567895', '제임스고슬링', '캐나다', '어딘가', 'XXXYYY', 1955, 1, '2014-06-01'),
	(7, '1234567896', '이도', '서울시 종로구', '통인동', ' 110043', 1996, 1, '2019-02-22');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- 테이블 hrdb.team 구조 내보내기
CREATE TABLE IF NOT EXISTS `team` (
  `TEAM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`TEAM_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 테이블 데이터 hrdb.team:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` (`TEAM_ID`, `NAME`) VALUES
	(1, 'SW팀');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
