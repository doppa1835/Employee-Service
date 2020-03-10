-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2020 at 05:21 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employee_service`
--

-- --------------------------------------------------------

--
-- Table structure for table `deductions`
--

CREATE TABLE `deductions` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL,
  `amount` int(10) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `designation`
--

CREATE TABLE `designation` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `grade` varchar(100) DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `employee_id` varchar(60) NOT NULL,
  `manager` bigint(20) DEFAULT NULL,
  `user` bigint(20) DEFAULT NULL,
  `designation` bigint(20) DEFAULT NULL,
  `joining_date` bigint(30) NOT NULL,
  `leaving_date` bigint(30) NOT NULL,
  `is_active` bit(1) DEFAULT b'0',
  `total_experience` int(5) DEFAULT 0,
  `salary` int(15) NOT NULL,
  `ctc` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `experience`
--

CREATE TABLE `experience` (
  `id` bigint(20) NOT NULL,
  `type` varchar(30) NOT NULL,
  `employee` bigint(20) DEFAULT NULL,
  `designation` varchar(100) DEFAULT NULL,
  `years` int(10) DEFAULT 0,
  `ctc` double NOT NULL DEFAULT 0,
  `from_date` bigint(30) NOT NULL,
  `to_date` bigint(30) NOT NULL,
  `created_on` bigint(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `id` bigint(20) NOT NULL,
  `gross_salary` double DEFAULT 0,
  `net_salary` double DEFAULT 0,
  `basic` double DEFAULT 0,
  `hra` double DEFAULT 0,
  `ltc` double DEFAULT 0,
  `city_allowances` double DEFAULT 0,
  `medical_allowances` double DEFAULT 0,
  `meal_card_allowances` double DEFAULT 0,
  `uniform_allowances` double DEFAULT 0,
  `phone_allowances` double DEFAULT 0,
  `da` double DEFAULT 0,
  `other` double DEFAULT 0,
  `created_on` bigint(30) DEFAULT NULL,
  `payment_type` varchar(100) DEFAULT NULL,
  `employee` bigint(20) DEFAULT NULL,
  `accountant` bigint(20) DEFAULT NULL,
  `from_date` bigint(30) DEFAULT NULL,
  `to_date` bigint(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `deductions`
--
ALTER TABLE `deductions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `emp_service_deductions_salary_id_fk` (`salary`);

--
-- Indexes for table `designation`
--
ALTER TABLE `designation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `emp_service_employee_designation_fk` (`designation`),
  ADD KEY `emp_service_employee_manager_fk` (`manager`);

--
-- Indexes for table `experience`
--
ALTER TABLE `experience`
  ADD PRIMARY KEY (`id`),
  ADD KEY `emp_service_employee_id_fk` (`employee`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`id`),
  ADD KEY `emp_service_salary_employee_id_fk` (`employee`),
  ADD KEY `emp_service_salary_accountant_id_fk` (`accountant`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `deductions`
--
ALTER TABLE `deductions`
  ADD CONSTRAINT `emp_service_deductions_salary_id_fk` FOREIGN KEY (`salary`) REFERENCES `salary` (`id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `emp_service_employee_designation_fk` FOREIGN KEY (`designation`) REFERENCES `designation` (`id`),
  ADD CONSTRAINT `emp_service_employee_manager_fk` FOREIGN KEY (`manager`) REFERENCES `employee` (`id`);

--
-- Constraints for table `experience`
--
ALTER TABLE `experience`
  ADD CONSTRAINT `emp_service_employee_id_fk` FOREIGN KEY (`employee`) REFERENCES `employee` (`id`);

--
-- Constraints for table `salary`
--
ALTER TABLE `salary`
  ADD CONSTRAINT `emp_service_salary_accountant_id_fk` FOREIGN KEY (`accountant`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `emp_service_salary_employee_id_fk` FOREIGN KEY (`employee`) REFERENCES `employee` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
