-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 19, 2020 at 04:25 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `credit_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `S.No` int(11) NOT NULL,
  `Transfer From` char(80) NOT NULL,
  `Transfer To` char(80) NOT NULL,
  `Credit Transferred` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`S.No`, `Transfer From`, `Transfer To`, `Credit Transferred`) VALUES
(1, 'Shubham Kumar', 'Niraj Kumar', 300),
(2, 'Alok Kumar', 'Shubham Kumar', 135),
(3, 'Mukesh Dwivedi', 'Alok Kumar', 90);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `S.No` int(255) NOT NULL,
  `Name` char(50) NOT NULL,
  `Email` varchar(80) NOT NULL,
  `Credit` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`S.No`, `Name`, `Email`, `Credit`) VALUES
(1, 'Naveen Singh', 'naveen.ece.1728@iiitbh.ac.in', 10005),
(2, 'Shubham Kumar', 'skp92360@gmail.com', 295),
(3, 'Niraj Kumar', 'niraj.ece.1730@iiitbh.ac.in', 850),
(4, 'Animesh Ranjan', 'animesh.cse.1711@iiitbh.ac.in', 300),
(5, 'Alok Kumar', 'alok.ece.1702@iiitbh.ac.in', 90),
(6, 'Ria', 'ria@gmail.com', 1280),
(7, 'Ankur Rathore', 'ankur@rediffmail.com', 751),
(8, 'Mehwish Zaidi', 'mahi@gmail.com', 786),
(9, 'Mukesh Dwivedi', 'muko@yahoo.in', 4905),
(10, 'Tony Stark', 'iron@man.com', 205);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`S.No`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`S.No`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `S.No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `S.No` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
