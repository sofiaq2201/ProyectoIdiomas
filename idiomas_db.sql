-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-05-2020 a las 16:54:05
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `idiomas_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `id_alum` int(11) NOT NULL,
  `alum_email` varchar(30) NOT NULL,
  `alum_nombre` varchar(15) NOT NULL,
  `alum_password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id_alum`, `alum_email`, `alum_nombre`, `alum_password`) VALUES
(1, 'sofia@gmail.com', 'Sofia', '123456'),
(2, 'fran@gmail.com', 'Francisco', '0asdfg'),
(3, '22borntobe@gmail.com', 'Sofia Nelly', '12345'),
(10, 'marioq0366@gmail.com', 'pepe', 'dddd'),
(12, 'soso@gmail.com', 'Soso', '123'),
(13, 'alumno1@gmail.com', 'Alumno1', '12345'),
(14, 'alumno2@gmail.com', 'Alumno3', '12345'),
(15, 'alumno3@gmail.com', 'Alu 3', '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clases`
--

CREATE TABLE `clases` (
  `id_clase` int(11) NOT NULL,
  `clase_profe_id` int(11) NOT NULL,
  `clase_alumno_id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `horario` time NOT NULL,
  `clase_estado_id` int(11) NOT NULL,
  `clase_dispo_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clases`
--

INSERT INTO `clases` (`id_clase`, `clase_profe_id`, `clase_alumno_id`, `fecha`, `horario`, `clase_estado_id`, `clase_dispo_id`) VALUES
(11, 1, 1, '2020-05-27', '05:30:00', 1, 8),
(12, 2, 1, '2017-06-15', '13:00:00', 2, 1),
(13, 5, 1, '2020-06-30', '14:30:00', 1, 19),
(14, 1, 14, '2020-05-27', '05:30:00', 1, 8),
(15, 1, 15, '2020-05-31', '05:30:00', 1, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `disponibilidad`
--

CREATE TABLE `disponibilidad` (
  `id_disponibilidad` int(11) NOT NULL,
  `dispo_id_profe` int(11) NOT NULL,
  `dispo_fecha` date NOT NULL,
  `dispo_horario` varchar(255) NOT NULL,
  `estado` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `disponibilidad`
--

INSERT INTO `disponibilidad` (`id_disponibilidad`, `dispo_id_profe`, `dispo_fecha`, `dispo_horario`, `estado`) VALUES
(1, 2, '2017-06-15', '13:00:00', b'0'),
(2, 1, '2020-08-10', '18:00:00', b'1'),
(3, 1, '2020-02-10', '08:00:00', b'0'),
(4, 1, '2020-05-03', '15:00:00', b'0'),
(5, 1, '2020-05-29', '05:30:00', b'1'),
(6, 1, '2020-05-31', '05:30:00', b'1'),
(7, 1, '2020-05-31', '05:30:00', b'1'),
(8, 1, '2020-05-27', '05:30:00', b'1'),
(9, 1, '2020-05-20', '05:30:00', b'0'),
(10, 1, '2020-04-27', '08:30:00', b'0'),
(13, 1, '2020-07-09', '15:30:00', b'1'),
(14, 1, '2020-05-19', '08:30:00', b'0'),
(15, 1, '2020-05-27', '08:01:00', b'0'),
(17, 5, '2020-06-23', '10:00:00', b'1'),
(19, 5, '2020-06-30', '14:30:00', b'1'),
(20, 5, '2020-06-04', '14:00:00', b'1'),
(21, 5, '2020-06-25', '10:00:00', b'1'),
(23, 28, '2020-05-28', '14:36:00', b'1'),
(24, 5, '2020-05-28', '19:20', b'0'),
(25, 29, '2020-05-28', '10:30', b'0'),
(26, 29, '2020-05-30', '14:00', b'1'),
(27, 30, '2020-05-27', '10:25', b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados_clases`
--

CREATE TABLE `estados_clases` (
  `id_estado` int(11) NOT NULL,
  `estado_nombre` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estados_clases`
--

INSERT INTO `estados_clases` (`id_estado`, `estado_nombre`) VALUES
(1, 'Cancelado'),
(2, 'Reservado'),
(3, 'Finalizado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `idiomas`
--

CREATE TABLE `idiomas` (
  `id_idioma` int(11) NOT NULL,
  `idioma_nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `idiomas`
--

INSERT INTO `idiomas` (`id_idioma`, `idioma_nombre`) VALUES
(1, 'Inglés'),
(2, 'Español'),
(3, 'Japonés'),
(4, 'Italiano');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `id_prof` int(11) NOT NULL,
  `prof_email` varchar(30) NOT NULL,
  `prof_nombre` varchar(30) NOT NULL,
  `prof_pass` varchar(30) NOT NULL,
  `prof_idioma_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`id_prof`, `prof_email`, `prof_nombre`, `prof_pass`, `prof_idioma_id`) VALUES
(1, 'profe1@gmail.com', 'Profesor 1', '12345', 2),
(2, 'profe2@gmail.com', 'Profesor 2', 'a1s2d3', 1),
(3, 'profe3@gmail.com', 'Profesor 3', '01230', 4),
(4, 'marioq0366@gmail.com', 'Mario', '234343', 3),
(5, 'sofiaq2201@gmail.com', 'Sofia Nelly', '12345', 3),
(7, 'pepe@gmail.com', 'pepe', '12345', 3),
(28, 'profesor4@gmail.com', 'Profesor 4', '12345', 4),
(29, 'profesor5@gmail.com', 'Prof 5', '12345', 3),
(30, 'profesor6@gmail.com', 'Prof 6', '12345', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`id_alum`);

--
-- Indices de la tabla `clases`
--
ALTER TABLE `clases`
  ADD PRIMARY KEY (`id_clase`),
  ADD KEY `clase_estado_id` (`clase_estado_id`),
  ADD KEY `clase_profe_id` (`clase_profe_id`,`clase_alumno_id`),
  ADD KEY `clase_alumno_id` (`clase_alumno_id`),
  ADD KEY `clase_dispo_id` (`clase_dispo_id`);

--
-- Indices de la tabla `disponibilidad`
--
ALTER TABLE `disponibilidad`
  ADD PRIMARY KEY (`id_disponibilidad`),
  ADD KEY `id_profe` (`dispo_id_profe`);

--
-- Indices de la tabla `estados_clases`
--
ALTER TABLE `estados_clases`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indices de la tabla `idiomas`
--
ALTER TABLE `idiomas`
  ADD PRIMARY KEY (`id_idioma`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`id_prof`),
  ADD KEY `prof_idioma_id` (`prof_idioma_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `id_alum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `clases`
--
ALTER TABLE `clases`
  MODIFY `id_clase` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `disponibilidad`
--
ALTER TABLE `disponibilidad`
  MODIFY `id_disponibilidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `estados_clases`
--
ALTER TABLE `estados_clases`
  MODIFY `id_estado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `idiomas`
--
ALTER TABLE `idiomas`
  MODIFY `id_idioma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `profesores`
--
ALTER TABLE `profesores`
  MODIFY `id_prof` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clases`
--
ALTER TABLE `clases`
  ADD CONSTRAINT `clases_ibfk_1` FOREIGN KEY (`clase_estado_id`) REFERENCES `estados_clases` (`id_estado`),
  ADD CONSTRAINT `clases_ibfk_2` FOREIGN KEY (`clase_alumno_id`) REFERENCES `alumnos` (`id_alum`),
  ADD CONSTRAINT `clases_ibfk_3` FOREIGN KEY (`clase_profe_id`) REFERENCES `profesores` (`id_prof`),
  ADD CONSTRAINT `clases_ibfk_4` FOREIGN KEY (`clase_dispo_id`) REFERENCES `disponibilidad` (`id_disponibilidad`);

--
-- Filtros para la tabla `disponibilidad`
--
ALTER TABLE `disponibilidad`
  ADD CONSTRAINT `disponibilidad_ibfk_1` FOREIGN KEY (`dispo_id_profe`) REFERENCES `profesores` (`id_prof`);

--
-- Filtros para la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD CONSTRAINT `profesores_ibfk_1` FOREIGN KEY (`prof_idioma_id`) REFERENCES `idiomas` (`id_idioma`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
