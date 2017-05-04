-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2017 at 01:48 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `donordarah`
--

-- --------------------------------------------------------

--
-- Table structure for table `darah`
--

CREATE TABLE IF NOT EXISTS `darah` (
  `id_darah` int(25) NOT NULL,
  `gol_darah` varchar(2) NOT NULL,
  `volume` int(3) NOT NULL,
  `jumlah_darah` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pendonor`
--

CREATE TABLE IF NOT EXISTS `pendonor` (
  `id_pendonor` int(25) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `alamat` varchar(25) NOT NULL,
  `umur` int(3) NOT NULL,
  `kelamin` varchar(10) NOT NULL,
  `pekerjaan` varchar(20) NOT NULL,
  `tgl_lahir` varchar(25) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `gol_darah` varchar(2) NOT NULL,
  `tek_darah` int(5) NOT NULL,
  `suhu_tubuh` int(5) NOT NULL,
  `kadar_hb` int(5) NOT NULL,
  `denyut_nadi` int(5) NOT NULL,
  `darah_diambil` int(3) NOT NULL,
  `donor_ke` int(3) NOT NULL,
  `donor_terakhir` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pendonor`
--

INSERT INTO `pendonor` (`id_pendonor`, `nama`, `alamat`, `umur`, `kelamin`, `pekerjaan`, `tgl_lahir`, `telp`, `gol_darah`, `tek_darah`, `suhu_tubuh`, `kadar_hb`, `denyut_nadi`, `darah_diambil`, `donor_ke`, `donor_terakhir`) VALUES
(1, 'aaa', 'fdsfsd', 34, 'Wanita', 'Polisi', 'MMM d, yyyy', '232312', 'A', 23, 12, 12, 32, 250, 43, 'MMM d, yyyy'),
(2, 'Andi', 'Gg.anita', 20, 'Pria', 'Rumah Tangga', 'MMM d, yyyy', '082350125534', 'A', 12, 12, 20, 12, 350, 2, 'MMM d, yyyy');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE IF NOT EXISTS `petugas` (
  `id_admin` int(25) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `kelamin` varchar(10) NOT NULL,
  `alamat` varchar(25) NOT NULL,
  `telp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(25) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `level` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `darah`
--
ALTER TABLE `darah`
  ADD PRIMARY KEY (`id_darah`);

--
-- Indexes for table `pendonor`
--
ALTER TABLE `pendonor`
  ADD PRIMARY KEY (`id_pendonor`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `darah`
--
ALTER TABLE `darah`
  MODIFY `id_darah` int(25) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pendonor`
--
ALTER TABLE `pendonor`
  MODIFY `id_pendonor` int(25) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
  MODIFY `id_admin` int(25) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(25) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
