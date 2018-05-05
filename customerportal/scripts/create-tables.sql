DROP DATABASE  IF EXISTS `century_link_db`;

CREATE DATABASE  IF NOT EXISTS `century_link_db`;
USE `century_link_db`;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int NOT NULL,
  `customer_name` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `contact_number` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `customer`
--

INSERT INTO `customer` 
VALUES 
(1,'john','MI','9872625363'),
(2,'kamal','MI','9876625363'),
(3,'josh','MI','9877775363'),
(4,'ram','MI','9992625363'),
(5,'naveen','MI','9672625363'),
(6,'akbar','MI','9882625363'),
(7,'barkan','MI','9899925363'),
(8,'sherkan','MI','9872629863'),
(9,'chiru','MI','9872625773'),
(10,'raj','MI','9872625673');


--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
`customer_id` int NOT NULL,
`id` int NOT NULL,
  `task_type` varchar(50) NOT NULL,
  `task_status` varchar(50) NOT NULL,
    `due_date` date NOT NULL,
  `miss_commit` varchar(50) NOT NULL,
    `notification_sent` varchar(50) NOT NULL,
  `return_message` varchar(50) NOT NULL,
  CONSTRAINT `job_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `job`
--

INSERT INTO `job` 
VALUES 
(1,21,'Fxb987','unscheduled','2017-01-01','no','yes','no'),
(2,22,'Fxb7','completed','2018-02-01','no','no','no'),
(3,23,'Fw87','completed','2018-04-02','no','yes','no'),
(4,24,'GFb987','inprogress','2018-03-04','no','yes','yes'),
(5,25,'Fxb000','completed','2018-04-01','no','yes','no'),
(6,26,'Fxb111','inprogress','2018-03-01','no','no','no'),
(7,27,'Fggh87','unscheduled','2018-04-04','no','no','yes'),
(8,28,'F78h87','unscheduled','2018-01-01','no','yes','no'),
(9,29,'Fsns87','unscheduled','2018-02-03','no','yes','no'),
(1,30,'Fxb007','completed','2018-01-04','no','no','yes'),
(10,31,'F0b987','notstarted','2018-02-02','no','yes','no'),
(5,32,'F00987','completed','2018-01-09','no','yes','no'),
(3,33,'F00087','scheduled','2018-02-09','no','yes','no'),
(8,34,'Fagh87','completed','2018-02-06','no','no','yes'),
(2,35,'Faaa87','inprogress','2018-05-05','no','no','no'),
(1,36,'Fkjh87','unscheduled','2018-08-08','no','yes','no');



