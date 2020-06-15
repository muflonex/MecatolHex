-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Jun 15, 2020 at 11:47 AM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `catalogo_juegos`
--
CREATE DATABASE IF NOT EXISTS `catalogo_juegos` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `catalogo_juegos`;

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nombre`) VALUES
(1001, 'política'),
(1016, 'ciencia ficción'),
(1023, 'engaño'),
(1039, 'deducción'),
(1064, 'películas/series'),
(1081, 'espías'),
(1113, 'exploración de espacio');

-- --------------------------------------------------------

--
-- Table structure for table `copia`
--

DROP TABLE IF EXISTS `copia`;
CREATE TABLE IF NOT EXISTS `copia` (
  `id_copia` int(11) NOT NULL AUTO_INCREMENT,
  `estanteria_id_estanteria` int(2) NOT NULL,
  `estante_id_estante` int(4) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  `juego_id_juego` int(11) NOT NULL,
  PRIMARY KEY (`id_copia`),
  KEY `fk_copia_estante` (`estante_id_estante`) USING BTREE,
  KEY `fk_copia_estanteria` (`estanteria_id_estanteria`) USING BTREE,
  KEY `fk_juego` (`juego_id_juego`) USING BTREE,
  KEY `fk_usuario` (`usuario_id_usuario`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `copia`
--

INSERT INTO `copia` (`id_copia`, `estanteria_id_estanteria`, `estante_id_estante`, `usuario_id_usuario`, `juego_id_juego`) VALUES
(2, 1, 1, 1, 37111),
(3, 1, 1, 2, 37111),
(5, 1, 1, 1, 85905),
(6, 1, 1, 1, 105136),
(7, 1, 1, 1, 141648),
(8, 7, 2, 1, 3076),
(9, 20, 5, 1, 30549),
(10, 14, 3, 1, 40692),
(11, 5, 3, 1, 70919),
(12, 3, 4, 1, 96848),
(13, 3, 4, 2, 96848),
(14, 2, 2, 1, 98778),
(15, 2, 2, 2, 98778),
(16, 6, 1, 1, 104162),
(17, 8, 3, 2, 108745),
(18, 2, 2, 2, 139030),
(19, 5, 2, 1, 158899),
(20, 3, 3, 1, 163412),
(21, 4, 1, 1, 174430);

-- --------------------------------------------------------

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
CREATE TABLE IF NOT EXISTS `direccion` (
  `id_direccion` int(11) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `lat` decimal(17,14) DEFAULT NULL,
  `lng` decimal(17,14) DEFAULT NULL,
  PRIMARY KEY (`id_direccion`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `direccion`
--

INSERT INTO `direccion` (`id_direccion`, `direccion`, `lat`, `lng`) VALUES
(1, 'Calle de Matilde Hernández, 36, 28019 Madrid', '40.39428300000000', '-3.72922160000000'),
(2, 'Calle de Rascón, 25, 28019 Madrid, Spain', '40.39425252603947', '-3.72703184667541'),
(40, 'Puerta del Sol, 10, 28013 Madrid, Spain', '40.41700795706201', '-3.70433313022529');

-- --------------------------------------------------------

--
-- Table structure for table `estante`
--

DROP TABLE IF EXISTS `estante`;
CREATE TABLE IF NOT EXISTS `estante` (
  `id_estante` int(4) NOT NULL AUTO_INCREMENT,
  `estanteria_id_estanteria` int(2) NOT NULL,
  `numero` int(4) NOT NULL,
  PRIMARY KEY (`id_estante`),
  KEY `fk_estante_estanteria` (`estanteria_id_estanteria`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `estante`
--

INSERT INTO `estante` (`id_estante`, `estanteria_id_estanteria`, `numero`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 2, 1),
(6, 2, 2),
(7, 2, 3),
(8, 2, 4),
(9, 3, 1),
(10, 3, 2),
(11, 3, 3),
(12, 3, 4),
(13, 4, 1),
(14, 4, 2),
(15, 4, 3),
(16, 4, 4),
(17, 5, 1),
(18, 5, 2),
(19, 5, 3),
(20, 6, 1),
(21, 6, 2),
(22, 6, 3),
(23, 6, 4),
(24, 7, 1),
(25, 7, 2),
(26, 7, 3),
(27, 7, 4),
(28, 8, 1),
(29, 8, 2),
(30, 8, 3),
(31, 8, 4),
(32, 9, 1),
(33, 9, 2),
(34, 9, 3),
(35, 9, 4),
(36, 10, 1),
(37, 10, 2),
(38, 10, 3),
(39, 10, 4),
(40, 11, 1),
(41, 11, 2),
(42, 11, 3),
(43, 11, 4),
(44, 12, 1),
(45, 12, 2),
(46, 12, 3),
(47, 12, 4),
(48, 13, 1),
(49, 13, 2),
(50, 13, 3),
(51, 13, 4),
(52, 14, 1),
(53, 14, 2),
(54, 14, 3),
(55, 14, 4),
(56, 15, 1),
(57, 15, 2),
(58, 15, 3),
(59, 15, 4),
(60, 16, 1),
(61, 16, 2),
(62, 16, 3),
(63, 16, 4),
(64, 17, 1),
(65, 17, 2),
(66, 17, 3),
(67, 17, 4),
(68, 18, 1),
(69, 18, 2),
(70, 18, 3),
(71, 18, 4),
(72, 19, 1),
(73, 19, 2),
(74, 19, 3),
(75, 19, 4),
(76, 20, 1),
(77, 20, 2),
(78, 20, 3),
(79, 20, 4),
(80, 20, 5);

-- --------------------------------------------------------

--
-- Table structure for table `estanteria`
--

DROP TABLE IF EXISTS `estanteria`;
CREATE TABLE IF NOT EXISTS `estanteria` (
  `id_estanteria` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_estanteria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `estanteria`
--

INSERT INTO `estanteria` (`id_estanteria`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20),
(21),
(22),
(23),
(24),
(25);

-- --------------------------------------------------------

--
-- Table structure for table `juego`
--

DROP TABLE IF EXISTS `juego`;
CREATE TABLE IF NOT EXISTS `juego` (
  `id_juego` int(11) NOT NULL,
  `nombre` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nombre_original` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `complejidad` int(1) NOT NULL,
  `dependencia_ling` int(1) NOT NULL,
  `tiempo_jugar` int(11) NOT NULL,
  `min_edad` int(3) NOT NULL,
  `min_jugadores` int(2) NOT NULL,
  `max_jugadores` int(2) NOT NULL,
  `id_juego_expandido` int(11) DEFAULT NULL,
  `es_expansion` tinyint(4) NOT NULL,
  `imagen` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id_juego`),
  KEY `fk_juego_expandido` (`id_juego`) USING BTREE,
  KEY `fk_juego_juego_expandido` (`id_juego_expandido`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `juego`
--

INSERT INTO `juego` (`id_juego`, `nombre`, `nombre_original`, `complejidad`, `dependencia_ling`, `tiempo_jugar`, `min_edad`, `min_jugadores`, `max_jugadores`, `id_juego_expandido`, `es_expansion`, `imagen`) VALUES
(3076, 'Puerto Rico', 'Puerto Rico', 3, 3, 150, 12, 3, 5, NULL, 0, 'https://cf.geekdo-images.com/original/img/RvdWBkmDks7AN8sodR4PyVcponA=/0x0/pic158548.jpg'),
(30549, 'Pandemic', 'Pandemic', 2, 2, 45, 8, 2, 4, NULL, 0, 'https://cf.geekdo-images.com/original/img/j-pfXZ_0GmOowohzD_T6NDAWGSA=/0x0/pic1534148.jpg'),
(37111, 'Battlestar Galactica: El juego de tablero', 'Battlestar Galactica: The Board Game', 3, 4, 180, 14, 3, 6, NULL, 0, 'https://cf.geekdo-images.com/original/img/-hZFpTm-evjyuLD_bj-y845-4f8=/0x0/pic354500.jpg'),
(40692, 'Small World', 'Small World', 2, 1, 80, 8, 2, 5, NULL, 0, 'https://cf.geekdo-images.com/original/img/WvXe0YG-Mj2KBtyRSBNtRw4DIx0=/0x0/pic428828.jpg'),
(43539, 'Battlestar Galactica: Expansión Pegasus', 'Battlestar Galactica: The Board Game – Pegasus Expansion', 3, 4, 180, 14, 3, 6, 37111, 1, 'https://cf.geekdo-images.com/original/img/ZaoqzdwMSiDQoSWuEvZfYHMMaoU=/0x0/pic512021.jpg'),
(70919, 'Takenoko', 'Takenoko', 2, 1, 45, 8, 2, 4, NULL, 0, 'https://cf.geekdo-images.com/original/img/7SDbClO-4sN6LICvfySB3jrFUhU=/0x0/pic1912529.jpg'),
(85905, 'Battlestar Galactica: Expansión Éxodo', 'Battlestar Galactica: The Board Game – Exodus Expansion', 3, 4, 180, 14, 3, 6, 37111, 1, 'https://cf.geekdo-images.com/original/img/LEceoxPhjR5hN9pqK-J4skHq8_I=/0x0/pic834119.jpg\r\n'),
(96848, 'Mage Knight', 'Mage Knight Board Game', 5, 4, 240, 14, 1, 4, NULL, 0, 'https://cf.geekdo-images.com/original/img/AGyvx6NYd6Kq4HUztAObQVLEFWY=/0x0/pic1083380.jpg'),
(98778, 'Hanabi', 'Hanabi Pocket', 2, 1, 25, 8, 2, 5, NULL, 0, 'https://cf.geekdo-images.com/original/img/Wkrf8z3pMlOFKwxafbw9-Ob404s=/0x0/pic2007286.jpg'),
(104162, 'Descent: Viaje a las Tinieblas', 'Descent: Journeys in the Dark', 3, 4, 120, 14, 1, 5, NULL, 0, 'https://cf.geekdo-images.com/original/img/jGVm6aG5Ek-qxTIaWyzN67jjylc=/0x0/pic1180640.jpg'),
(105136, 'Battlestar Galactica: Reglas opcionales', 'Battlestar Galactica: Official Variant Rules', 3, 4, 120, 10, 1, 6, 37111, 1, 'https://cf.geekdo-images.com/original/img/DQWl7pM7aMCvLp_YbpEGecFvAA4=/0x0/pic1139469.jpg'),
(108745, 'Seasons', 'Seasons', 3, 4, 60, 14, 2, 4, NULL, 0, 'https://cf.geekdo-images.com/original/img/KIQ10GbCcfxPNQKUOMWEMVKA9Ao=/0x0/pic1299390.jpg'),
(139030, 'Mascarade', 'Mascarade', 1, 1, 30, 10, 2, 13, NULL, 0, 'https://cf.geekdo-images.com/original/img/659I4dOGhGMkUiGSZs-tpof9OSo=/0x0/pic1762410.jpg'),
(141648, 'Battlestar Galactica: Amanecer', 'Battlestar Galactica: The Board Game – Daybreak Expansion', 3, 4, 180, 14, 3, 7, 37111, 1, 'https://cf.geekdo-images.com/original/img/aQSHkcPG6clBL39KSfpW6RS8UFg=/0x0/pic1639528.jpg\r\n'),
(158899, 'Colt Express', 'Colt Express', 2, 1, 40, 10, 2, 6, NULL, 0, 'https://cf.geekdo-images.com/original/img/n9uCTxxSSZXPVnXRPSgGl6uZQ2w=/0x0/pic2869710.jpg'),
(163412, 'Patchwork', 'Patchwork', 2, 1, 30, 8, 2, 2, NULL, 0, 'https://cf.geekdo-images.com/original/img/Z8MYZktgvGTtIikMv9HSpD_ERAI=/0x0/pic2270442.jpg'),
(174430, 'Gloomhaven', 'Gloomhaven', 4, 4, 120, 12, 1, 4, NULL, 0, 'https://cf.geekdo-images.com/original/img/lDN358RgcYvQfYYN6Oy2TXpifyM=/0x0/pic2437871.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `juego_tiene_categoria`
--

DROP TABLE IF EXISTS `juego_tiene_categoria`;
CREATE TABLE IF NOT EXISTS `juego_tiene_categoria` (
  `juego_id_juego` int(11) NOT NULL,
  `categoria_id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`juego_id_juego`,`categoria_id_categoria`),
  KEY `fk_categoria` (`categoria_id_categoria`) USING BTREE,
  KEY `fk_juego` (`juego_id_juego`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `juego_tiene_categoria`
--

INSERT INTO `juego_tiene_categoria` (`juego_id_juego`, `categoria_id_categoria`) VALUES
(37111, 1001),
(43539, 1001),
(85905, 1001),
(105136, 1001),
(141648, 1001),
(37111, 1016),
(43539, 1016),
(85905, 1016),
(105136, 1016),
(141648, 1016),
(37111, 1023),
(43539, 1023),
(85905, 1023),
(105136, 1023),
(141648, 1023),
(37111, 1039),
(43539, 1039),
(85905, 1039),
(105136, 1039),
(141648, 1039),
(37111, 1064),
(43539, 1064),
(85905, 1064),
(105136, 1064),
(141648, 1064),
(37111, 1081),
(43539, 1081),
(85905, 1081),
(105136, 1081),
(141648, 1081),
(37111, 1113),
(43539, 1113),
(85905, 1113),
(105136, 1113),
(141648, 1113);

-- --------------------------------------------------------

--
-- Table structure for table `juego_tiene_mecanica`
--

DROP TABLE IF EXISTS `juego_tiene_mecanica`;
CREATE TABLE IF NOT EXISTS `juego_tiene_mecanica` (
  `juego_id_juego` int(11) NOT NULL,
  `mecanica_id_mecanica` int(11) NOT NULL,
  PRIMARY KEY (`juego_id_juego`,`mecanica_id_mecanica`),
  KEY `fk_juego` (`juego_id_juego`) USING BTREE,
  KEY `fk_mecanica` (`mecanica_id_mecanica`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `juego_tiene_mecanica`
--

INSERT INTO `juego_tiene_mecanica` (`juego_id_juego`, `mecanica_id_mecanica`) VALUES
(37111, 2015),
(37111, 2017),
(37111, 2019),
(37111, 2028),
(37111, 2040),
(37111, 2046),
(37111, 2072),
(37111, 2814),
(37111, 2846),
(37111, 2891),
(37111, 2897),
(43539, 2015),
(43539, 2017),
(43539, 2019),
(43539, 2028),
(43539, 2040),
(43539, 2046),
(43539, 2072),
(43539, 2814),
(43539, 2846),
(43539, 2891),
(43539, 2897),
(85905, 2015),
(85905, 2017),
(85905, 2019),
(85905, 2028),
(85905, 2040),
(85905, 2046),
(85905, 2072),
(85905, 2814),
(85905, 2846),
(85905, 2891),
(85905, 2897),
(105136, 2015),
(105136, 2017),
(105136, 2019),
(105136, 2028),
(105136, 2040),
(105136, 2046),
(105136, 2072),
(105136, 2814),
(105136, 2846),
(105136, 2891),
(105136, 2897),
(141648, 2015),
(141648, 2017),
(141648, 2019),
(141648, 2028),
(141648, 2040),
(141648, 2046),
(141648, 2072),
(141648, 2814),
(141648, 2846),
(141648, 2891),
(141648, 2897);

-- --------------------------------------------------------

--
-- Table structure for table `mecanica`
--

DROP TABLE IF EXISTS `mecanica`;
CREATE TABLE IF NOT EXISTS `mecanica` (
  `id_mecanica` int(11) NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id_mecanica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mecanica`
--

INSERT INTO `mecanica` (`id_mecanica`, `nombre`) VALUES
(2015, 'variación de poderes'),
(2017, 'votación'),
(2019, 'equipos'),
(2028, 'RPG'),
(2040, 'mano de cartas'),
(2046, 'campos'),
(2072, 'dados'),
(2814, 'traidor'),
(2846, '1 vez / partida'),
(2891, 'roles ocultos'),
(2897, 'variación de despliegue');

-- --------------------------------------------------------

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
CREATE TABLE IF NOT EXISTS `prestamo` (
  `id_prestamo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_inicio` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_fin` datetime DEFAULT NULL,
  `copia_id_copia` int(11) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_prestamo`),
  KEY `fk_copia` (`copia_id_copia`) USING BTREE,
  KEY `fk_usuario` (`usuario_id_usuario`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `prestamo`
--

INSERT INTO `prestamo` (`id_prestamo`, `fecha_inicio`, `fecha_fin`, `copia_id_copia`, `usuario_id_usuario`) VALUES
(1, '2020-06-15 09:29:37', '2020-06-15 09:40:35', 2, 2),
(2, '2020-06-14 23:21:18', '2020-06-14 23:41:52', 6, 2),
(3, '2020-05-23 19:15:20', '2020-05-23 22:00:00', 13, 8),
(4, '2020-05-27 20:11:12', '2020-05-27 20:45:12', 12, 2),
(5, '2020-06-10 20:50:11', NULL, 12, 8),
(8, '2020-06-15 11:55:07', NULL, 21, 2);

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_admin` tinyint(4) NOT NULL,
  `id_direccion` int(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `fk_direccion` (`id_direccion`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `email`, `nombre`, `password`, `is_admin`, `id_direccion`) VALUES
(1, 'comision_ludoteca@mecatolrex.com', 'Club', '1234', 1, 1),
(2, 'muflonex@gmail.com', 'Mikolaj', 'cQqV4OKP0Q', 1, 2),
(8, 'm.bernecki@gmail.com', 'muflonex', 'Altoemamra82', 0, 40);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `copia`
--
ALTER TABLE `copia`
  ADD CONSTRAINT `fk_copia_estante` FOREIGN KEY (`estante_id_estante`) REFERENCES `estante` (`id_estante`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_copia_estanteria` FOREIGN KEY (`estanteria_id_estanteria`) REFERENCES `estanteria` (`id_estanteria`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_copia_juego` FOREIGN KEY (`juego_id_juego`) REFERENCES `juego` (`id_juego`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_copia_usuario` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `estante`
--
ALTER TABLE `estante`
  ADD CONSTRAINT `fk_estante_estanteria` FOREIGN KEY (`estanteria_id_estanteria`) REFERENCES `estanteria` (`id_estanteria`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `juego`
--
ALTER TABLE `juego`
  ADD CONSTRAINT `fk_juego_juego_expandido` FOREIGN KEY (`id_juego_expandido`) REFERENCES `juego` (`id_juego`) ON UPDATE CASCADE;

--
-- Constraints for table `juego_tiene_categoria`
--
ALTER TABLE `juego_tiene_categoria`
  ADD CONSTRAINT `fk_categoria` FOREIGN KEY (`categoria_id_categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_juego` FOREIGN KEY (`juego_id_juego`) REFERENCES `juego` (`id_juego`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `juego_tiene_mecanica`
--
ALTER TABLE `juego_tiene_mecanica`
  ADD CONSTRAINT `fk_juego_tiene_mecanica_juego` FOREIGN KEY (`juego_id_juego`) REFERENCES `juego` (`id_juego`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_juego_tiene_mecanica_mecanica` FOREIGN KEY (`mecanica_id_mecanica`) REFERENCES `mecanica` (`id_mecanica`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `fk_prestamo_copia` FOREIGN KEY (`copia_id_copia`) REFERENCES `copia` (`id_copia`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_prestamo_usuario` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_direccion` FOREIGN KEY (`id_direccion`) REFERENCES `direccion` (`id_direccion`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
