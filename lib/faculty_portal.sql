-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2017 at 08:02 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `faculty_portal`
--
CREATE DATABASE IF NOT EXISTS `faculty_portal` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `faculty_portal`;

-- --------------------------------------------------------

--
-- Table structure for table `backup_emp_leave_info`
--

DROP TABLE IF EXISTS `backup_emp_leave_info`;
CREATE TABLE `backup_emp_leave_info` (
  `Year` varchar(10) NOT NULL,
  `UserID` int(11) NOT NULL,
  `SLTaken` float NOT NULL,
  `CLTaken` float NOT NULL,
  `DLTaken` float NOT NULL,
  `PLTaken` float NOT NULL DEFAULT '-1',
  `MLTaken` float DEFAULT '-1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `backup_emp_leave_info`:
--

-- --------------------------------------------------------

--
-- Table structure for table `backup_emp_leave_request`
--

DROP TABLE IF EXISTS `backup_emp_leave_request`;
CREATE TABLE `backup_emp_leave_request` (
  `Year` varchar(10) NOT NULL,
  `EmpLeaveID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `LeaveType` int(5) NOT NULL,
  `ApplyDate` date NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `ApproveDate` date DEFAULT NULL,
  `NoOfDays` float NOT NULL,
  `Reason` varchar(50) NOT NULL,
  `AddressDuringLeave` varchar(50) NOT NULL,
  `Remark` varchar(50) DEFAULT NULL,
  `HodRemark` varchar(50) DEFAULT NULL,
  `Status` varchar(20) NOT NULL DEFAULT 'pending'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `backup_emp_leave_request`:
--

-- --------------------------------------------------------

--
-- Table structure for table `backup_load_arrangement`
--

DROP TABLE IF EXISTS `backup_load_arrangement`;
CREATE TABLE `backup_load_arrangement` (
  `Year` varchar(10) NOT NULL,
  `EmpLeaveID` int(11) NOT NULL,
  `Date` date NOT NULL DEFAULT '0000-00-00',
  `Time` varchar(10) NOT NULL,
  `Semester` int(11) DEFAULT NULL,
  `DivBatch` varchar(5) DEFAULT NULL,
  `RoomNo` int(11) DEFAULT NULL,
  `SubjectName` varchar(50) DEFAULT NULL,
  `AssignedFaculty` int(11) DEFAULT NULL,
  `Status` varchar(20) NOT NULL DEFAULT 'pending',
  `ApproveDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `backup_load_arrangement`:
--

-- --------------------------------------------------------

--
-- Table structure for table `backup_slot_preference`
--

DROP TABLE IF EXISTS `backup_slot_preference`;
CREATE TABLE `backup_slot_preference` (
  `Year` varchar(10) NOT NULL,
  `UserID` int(11) NOT NULL,
  `Slot` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `backup_slot_preference`:
--

-- --------------------------------------------------------

--
-- Table structure for table `backup_subject_preferences`
--

DROP TABLE IF EXISTS `backup_subject_preferences`;
CREATE TABLE `backup_subject_preferences` (
  `Year` varchar(10) NOT NULL,
  `UserID` int(11) NOT NULL,
  `SubID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `backup_subject_preferences`:
--

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments` (
  `DepID` int(11) NOT NULL,
  `DepName` varchar(30) NOT NULL,
  `ShortName` varchar(3) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `departments`:
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `ID` int(11) NOT NULL,
  `FirstName` varchar(15) NOT NULL,
  `MiddleName` varchar(15) DEFAULT NULL,
  `LastName` varchar(15) DEFAULT NULL,
  `BirthDate` date DEFAULT NULL,
  `JoinDate` date DEFAULT NULL,
  `LeaveDate` date DEFAULT NULL,
  `Working` int(11) DEFAULT NULL,
  `Gender` enum('M','F') DEFAULT NULL,
  `DepID` int(11) NOT NULL,
  `Designation` varchar(50) NOT NULL,
  `Category` varchar(30) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `Signature` longblob,
  `Salutation` varchar(10) DEFAULT 'Prof.'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `employees`:
--

-- --------------------------------------------------------

--
-- Table structure for table `emp_leave_info`
--

DROP TABLE IF EXISTS `emp_leave_info`;
CREATE TABLE `emp_leave_info` (
  `UserID` int(11) NOT NULL,
  `SLTaken` float NOT NULL,
  `CLTaken` float NOT NULL,
  `DLTaken` float NOT NULL,
  `PLTaken` float NOT NULL DEFAULT '-1',
  `MLTaken` float DEFAULT '-1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `emp_leave_info`:
--

-- --------------------------------------------------------

--
-- Table structure for table `emp_leave_request`
--

DROP TABLE IF EXISTS `emp_leave_request`;
CREATE TABLE `emp_leave_request` (
  `EmpLeaveID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `LeaveType` int(5) NOT NULL,
  `ApplyDate` date NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `ApproveDate` date DEFAULT NULL,
  `NoOfDays` float NOT NULL,
  `Reason` varchar(50) NOT NULL,
  `AddressDuringLeave` varchar(50) NOT NULL,
  `Remark` varchar(50) DEFAULT NULL,
  `HodRemark` varchar(50) DEFAULT NULL,
  `Status` varchar(20) NOT NULL DEFAULT 'pending'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `emp_leave_request`:
--

-- --------------------------------------------------------

--
-- Table structure for table `leave_info`
--

DROP TABLE IF EXISTS `leave_info`;
CREATE TABLE `leave_info` (
  `LID` int(5) NOT NULL,
  `LeaveName` varchar(20) NOT NULL,
  `LeaveShortName` varchar(10) NOT NULL,
  `Allowed` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `leave_info`:
--

-- --------------------------------------------------------

--
-- Table structure for table `load_arrangement`
--

DROP TABLE IF EXISTS `load_arrangement`;
CREATE TABLE `load_arrangement` (
  `EmpLeaveID` int(11) NOT NULL,
  `Date` date NOT NULL DEFAULT '0000-00-00',
  `Time` varchar(10) NOT NULL,
  `Semester` int(11) DEFAULT NULL,
  `DivBatch` varchar(5) DEFAULT NULL,
  `RoomNo` int(11) DEFAULT NULL,
  `SubjectName` varchar(50) DEFAULT NULL,
  `AssignedFaculty` int(11) DEFAULT NULL,
  `Status` varchar(20) NOT NULL DEFAULT 'pending',
  `ApproveDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `load_arrangement`:
--

-- --------------------------------------------------------

--
-- Table structure for table `semester_wise_subjects`
--

DROP TABLE IF EXISTS `semester_wise_subjects`;
CREATE TABLE `semester_wise_subjects` (
  `Semester` varchar(10) NOT NULL,
  `SubID` int(11) NOT NULL,
  `Offered` int(11) DEFAULT NULL,
  `SemNo` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `semester_wise_subjects`:
--

-- --------------------------------------------------------

--
-- Table structure for table `slot_preference`
--

DROP TABLE IF EXISTS `slot_preference`;
CREATE TABLE `slot_preference` (
  `UserID` int(11) NOT NULL,
  `Slot` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `slot_preference`:
--

-- --------------------------------------------------------

--
-- Table structure for table `subjects_master`
--

DROP TABLE IF EXISTS `subjects_master`;
CREATE TABLE `subjects_master` (
  `SubID` int(11) NOT NULL,
  `SubName` varchar(50) NOT NULL,
  `SubCode` varchar(10) DEFAULT NULL,
  `SubShortName` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `subjects_master`:
--

-- --------------------------------------------------------

--
-- Table structure for table `subject_preferences`
--

DROP TABLE IF EXISTS `subject_preferences`;
CREATE TABLE `subject_preferences` (
  `UserID` int(11) NOT NULL,
  `SubID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `subject_preferences`:
--

-- --------------------------------------------------------

--
-- Table structure for table `subject_preference_settings`
--

DROP TABLE IF EXISTS `subject_preference_settings`;
CREATE TABLE `subject_preference_settings` (
  `DepID` int(11) NOT NULL,
  `SemType` varchar(5) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `subject_preference_settings`:
--   `DepID`
--       `departments` -> `DepID`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `UserName` varchar(10) NOT NULL,
  `Password` varchar(64) NOT NULL,
  `UserID` int(11) NOT NULL,
  `UserType` varchar(15) NOT NULL,
  `Initials` varchar(3) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `users`:
--

--
-- Indexes for dumped tables
--

--
-- Indexes for table `backup_emp_leave_info`
--
ALTER TABLE `backup_emp_leave_info`
  ADD PRIMARY KEY (`Year`,`UserID`);

--
-- Indexes for table `backup_emp_leave_request`
--
ALTER TABLE `backup_emp_leave_request`
  ADD PRIMARY KEY (`Year`,`EmpLeaveID`);

--
-- Indexes for table `backup_load_arrangement`
--
ALTER TABLE `backup_load_arrangement`
  ADD PRIMARY KEY (`Year`,`EmpLeaveID`,`Date`,`Time`);

--
-- Indexes for table `backup_slot_preference`
--
ALTER TABLE `backup_slot_preference`
  ADD PRIMARY KEY (`Year`,`UserID`);

--
-- Indexes for table `backup_subject_preferences`
--
ALTER TABLE `backup_subject_preferences`
  ADD PRIMARY KEY (`Year`,`UserID`,`SubID`);

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`DepID`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `DepID` (`DepID`);

--
-- Indexes for table `emp_leave_info`
--
ALTER TABLE `emp_leave_info`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `emp_leave_request`
--
ALTER TABLE `emp_leave_request`
  ADD PRIMARY KEY (`EmpLeaveID`);

--
-- Indexes for table `leave_info`
--
ALTER TABLE `leave_info`
  ADD PRIMARY KEY (`LID`);

--
-- Indexes for table `load_arrangement`
--
ALTER TABLE `load_arrangement`
  ADD PRIMARY KEY (`EmpLeaveID`,`Date`,`Time`);

--
-- Indexes for table `semester_wise_subjects`
--
ALTER TABLE `semester_wise_subjects`
  ADD PRIMARY KEY (`Semester`,`SubID`),
  ADD KEY `SubID` (`SubID`);

--
-- Indexes for table `slot_preference`
--
ALTER TABLE `slot_preference`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `subjects_master`
--
ALTER TABLE `subjects_master`
  ADD PRIMARY KEY (`SubID`);

--
-- Indexes for table `subject_preferences`
--
ALTER TABLE `subject_preferences`
  ADD PRIMARY KEY (`UserID`,`SubID`);

--
-- Indexes for table `subject_preference_settings`
--
ALTER TABLE `subject_preference_settings`
  ADD PRIMARY KEY (`DepID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserName`),
  ADD KEY `UserID` (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `departments`
--
ALTER TABLE `departments`
  MODIFY `DepID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `emp_leave_request`
--
ALTER TABLE `emp_leave_request`
  MODIFY `EmpLeaveID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=214;
--
-- AUTO_INCREMENT for table `leave_info`
--
ALTER TABLE `leave_info`
  MODIFY `LID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `subjects_master`
--
ALTER TABLE `subjects_master`
  MODIFY `SubID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
