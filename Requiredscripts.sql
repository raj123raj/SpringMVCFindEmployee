DROP DATABASE IF EXISTS test;

CREATE DATABASE test;

USE test;

DROP TABLE test.employeesdetails;

CREATE TABLE `employeesdetails` (
  `id` int(6) unsigned NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `AvailableDays` varchar(200) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `qualification` varchar(20) DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

INSERT INTO `test`.`employeesdetails`
(`id`,`Name`,`AvailableDays`,`location`,`qualification`,
`experience`,`gender`) VALUES
(1,'EmployeeA','Monday,Tuesday,Friday','Location1','BE',5,'Female');

INSERT INTO `test`.`employeesdetails`
(`id`,`Name`,`AvailableDays`,`location`,`qualification`,
`experience`,`gender`) VALUES
(2,'EmployeeB','Monday,Wednesday,Friday','Location1','MCA',3,'Female');

INSERT INTO `test`.`employeesdetails`
(`id`,`Name`,`AvailableDays`,`location`,`qualification`,
`experience`,`gender`) VALUES
(3,'EmployeeC', 'Wednesday,Thursday','Location2','BE',5,'Female');

INSERT INTO `test`.`employeesdetails`
(`id`,`Name`,`AvailableDays`,`location`,`qualification`,
`experience`,`gender`) VALUES
(4,'EmployeeD','Saturday,Sunday','Location2','MBA',4,'Male');

INSERT INTO `test`.`employeesdetails`
(`id`,`Name`,`AvailableDays`,`location`,`qualification`,
`experience`,`gender`) VALUES
(5,'EmployeeE','Tuesday,Thursday','Location2','MCA',3,'Female');

INSERT INTO `test`.`employeesdetails`
(`id`,`Name`,`AvailableDays`,`location`,`qualification`,
`experience`,`gender`) VALUES
(6,'EmployeeA','Wednesday,Thursday','Location2','BE',5,'Female');

SELECT * FROM test.employeesdetails;

truncate table test.employeesdetails;



