-- phpMyAdmin SQL Dump
-- version 3.3.7deb2build0.10.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 20, 2010 at 12:59 AM
-- Server version: 5.1.49
-- PHP Version: 5.3.3-1ubuntu9.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sister_krs`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_krs`
--

CREATE TABLE IF NOT EXISTS `detail_krs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wktu` varchar(30) NOT NULL,
  `nim` varchar(8) NOT NULL,
  `kd_mk` char(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `detail_krs`
--


-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE IF NOT EXISTS `dosen` (
  `kd_dosen` char(5) NOT NULL,
  `dosen` varchar(50) NOT NULL,
  `pwd` varchar(30) NOT NULL,
  PRIMARY KEY (`kd_dosen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`kd_dosen`, `dosen`, `pwd`) VALUES
('01', 'Hero', '01');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE IF NOT EXISTS `mahasiswa` (
  `nim` varchar(8) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `prodi` enum('TP','TF','TI','TM','TE') NOT NULL,
  `kd_dosen` char(5) NOT NULL,
  `jumlah_krs` int(11) DEFAULT NULL,
  `pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim`, `nama`, `prodi`, `kd_dosen`, `jumlah_krs`, `pwd`) VALUES
('08030035', 'Bahrie', 'TF', '01', 0, '08030035');

-- --------------------------------------------------------

--
-- Table structure for table `mk`
--

CREATE TABLE IF NOT EXISTS `mk` (
  `kd_mk` char(5) NOT NULL,
  `mk` varchar(30) NOT NULL,
  `sks` int(11) NOT NULL,
  `jurusan` char(2) NOT NULL,
  `kd_dosen` char(5) NOT NULL,
  PRIMARY KEY (`kd_mk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mk`
--


-- --------------------------------------------------------

--
-- Table structure for table `waktu_krs`
--

CREATE TABLE IF NOT EXISTS `waktu_krs` (
  `id_wktu` varchar(30) NOT NULL,
  `nim` varchar(8) NOT NULL,
  `semester` enum('genap','ganjil') NOT NULL,
  `ta` enum('2008/2009','2009/2010','2010/2011','2011/2012','2012/2013') NOT NULL,
  `tgl_pengisian` date DEFAULT NULL,
  PRIMARY KEY (`id_wktu`),
  KEY `fk_mhs_wkrs` (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `waktu_krs`
--

INSERT INTO `waktu_krs` (`id_wktu`, `nim`, `semester`, `ta`, `tgl_pengisian`) VALUES
('1287959118138', '12', 'ganjil', '2010/2011', '2010-10-25'),
('1287959197142', '12', 'ganjil', '2010/2011', '2010-10-25'),
('1288629021801', '13', 'ganjil', '2010/2011', '2010-11-01');
