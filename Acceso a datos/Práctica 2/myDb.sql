-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 24-10-2022 a las 12:35:50
-- Versión del servidor: 8.0.16
-- Versión de PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `myDb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Practica2`
--

CREATE TABLE `Practica2` (
  `Nombre` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Edad` int(32) NOT NULL,
  `Ciudad` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Padre` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Madre` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `Practica2`
--

INSERT INTO `Practica2` (`Nombre`, `Edad`, `Ciudad`, `Padre`, `Madre`) VALUES
('Luis', 31, 'Sevilla', 'Diosito', 'La Virgen'),
('Carlos', 27, 'Sevilla', 'Luis', 'Cristo'),
('Jesus', 13, 'Sevilla', 'Luis', 'Sara'),
('Jose Miguel', 32, 'Sevilla', 'Jesus Cristo', 'Maria Magdalena'),
('Alvaro', 20, 'Sevilla', 'Alfredo', 'Raul');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
