-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 15-02-2021 a las 14:42:56
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sellercenter`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `address_type`
--

CREATE TABLE `address_type` (
  `address_type_id` decimal(10,0) DEFAULT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `approval_type`
--

CREATE TABLE `approval_type` (
  `approval_type_id` decimal(10,0) DEFAULT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrier`
--

CREATE TABLE `carrier` (
  `carrier_id` decimal(10,0) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `commission_type`
--

CREATE TABLE `commission_type` (
  `commission_type_id` decimal(10,0) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contact_type`
--

CREATE TABLE `contact_type` (
  `contact_type_id` decimal(10,0) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `contact_type`
--

INSERT INTO `contact_type` (`contact_type_id`, `name`) VALUES
('1', 'Negotiation'),
('2', 'Marketing'),
('3', 'AfterSale'),
('4', 'Warehouse'),
('5', 'Contact'),
('6', 'Accounting');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dispatch_type`
--

CREATE TABLE `dispatch_type` (
  `dispatch_type_id` decimal(10,0) DEFAULT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `document_format`
--

CREATE TABLE `document_format` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `document_format`
--

INSERT INTO `document_format` (`id`, `name`) VALUES
(1, 'docx');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ecommerce`
--

CREATE TABLE `ecommerce` (
  `ecommerce_id` decimal(10,0) DEFAULT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `email_type`
--

CREATE TABLE `email_type` (
  `email_type_id` decimal(10,0) DEFAULT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `phone_type`
--

CREATE TABLE `phone_type` (
  `phone_type_id` decimal(10,0) DEFAULT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `required_seller_document`
--

CREATE TABLE `required_seller_document` (
  `id` int(11) NOT NULL,
  `seller_id` decimal(10,0) DEFAULT NULL,
  `document_name` varchar(80) NOT NULL,
  `allowed_formats` varchar(150) NOT NULL,
  `maximun_size_allowed` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller`
--

CREATE TABLE `seller` (
  `id` int(11) NOT NULL,
  `ruc` varchar(20) DEFAULT NULL,
  `business_name` varchar(150) DEFAULT NULL,
  `trade_name` varchar(150) DEFAULT NULL,
  `dispatch_type_id` decimal(10,0) DEFAULT NULL,
  `terms_conditions` text DEFAULT NULL,
  `return_policy` text DEFAULT NULL,
  `company_logo` varchar(80) DEFAULT NULL,
  `company_description` varchar(100) DEFAULT NULL,
  `status_id` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller_address`
--

CREATE TABLE `seller_address` (
  `id` int(11) NOT NULL,
  `seller_id` decimal(10,0) DEFAULT NULL,
  `address_type_id` int(11) NOT NULL,
  `address` varchar(150) NOT NULL,
  `department` varchar(150) NOT NULL,
  `province` varchar(150) NOT NULL,
  `district` varchar(150) NOT NULL,
  `address_reference` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller_agreement_ecommerce`
--

CREATE TABLE `seller_agreement_ecommerce` (
  `id` int(11) NOT NULL,
  `seller_id` decimal(10,0) DEFAULT NULL,
  `ecommerce_id` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller_approval`
--

CREATE TABLE `seller_approval` (
  `seller_id` decimal(10,0) DEFAULT NULL,
  `approval_type_id` int(11) NOT NULL,
  `approved` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller_bank`
--

CREATE TABLE `seller_bank` (
  `id` int(11) NOT NULL,
  `seller_id` decimal(10,0) DEFAULT NULL,
  `bank_name` varchar(50) NOT NULL,
  `account_type` varchar(100) NOT NULL,
  `account_number` varchar(20) NOT NULL,
  `cci` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller_brand`
--

CREATE TABLE `seller_brand` (
  `id` int(11) NOT NULL,
  `seller_id` decimal(10,0) DEFAULT NULL,
  `brand` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller_carrier`
--

CREATE TABLE `seller_carrier` (
  `seller_carrier_id` decimal(10,0) DEFAULT NULL,
  `carrier_id` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller_commission`
--

CREATE TABLE `seller_commission` (
  `id` int(11) NOT NULL,
  `seller_id` decimal(10,0) DEFAULT NULL,
  `commission_type_id` decimal(10,0) DEFAULT NULL,
  `commission` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller_contact`
--

CREATE TABLE `seller_contact` (
  `id` int(11) NOT NULL,
  `seller_id` decimal(10,0) DEFAULT NULL,
  `contact_name` varchar(100) NOT NULL,
  `contact_email` varchar(100) NOT NULL,
  `contact_phone_number` varchar(80) NOT NULL,
  `contact_type_id` decimal(10,0) NOT NULL,
  `principal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller_document`
--

CREATE TABLE `seller_document` (
  `id` int(11) NOT NULL,
  `seller_id` decimal(10,0) DEFAULT NULL,
  `document_name` varchar(100) NOT NULL,
  `document_format_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller_email`
--

CREATE TABLE `seller_email` (
  `id` int(11) NOT NULL,
  `seller_id` decimal(10,0) DEFAULT NULL,
  `email` varchar(80) NOT NULL,
  `email_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller_opening_hours`
--

CREATE TABLE `seller_opening_hours` (
  `id` int(11) NOT NULL,
  `seller_id` decimal(10,0) DEFAULT NULL,
  `day` decimal(10,0) DEFAULT NULL,
  `start_time` varchar(20) DEFAULT NULL,
  `end_time` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seller_phone`
--

CREATE TABLE `seller_phone` (
  `id` int(11) NOT NULL,
  `seller_id` decimal(10,0) DEFAULT NULL,
  `phone_number` varchar(80) NOT NULL,
  `phone_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `document_format`
--
ALTER TABLE `document_format`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `required_seller_document`
--
ALTER TABLE `required_seller_document`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seller`
--
ALTER TABLE `seller`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seller_address`
--
ALTER TABLE `seller_address`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seller_agreement_ecommerce`
--
ALTER TABLE `seller_agreement_ecommerce`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seller_bank`
--
ALTER TABLE `seller_bank`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seller_brand`
--
ALTER TABLE `seller_brand`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seller_commission`
--
ALTER TABLE `seller_commission`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seller_contact`
--
ALTER TABLE `seller_contact`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seller_document`
--
ALTER TABLE `seller_document`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seller_email`
--
ALTER TABLE `seller_email`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seller_opening_hours`
--
ALTER TABLE `seller_opening_hours`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seller_phone`
--
ALTER TABLE `seller_phone`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `document_format`
--
ALTER TABLE `document_format`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `required_seller_document`
--
ALTER TABLE `required_seller_document`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seller`
--
ALTER TABLE `seller`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seller_address`
--
ALTER TABLE `seller_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seller_agreement_ecommerce`
--
ALTER TABLE `seller_agreement_ecommerce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seller_bank`
--
ALTER TABLE `seller_bank`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seller_brand`
--
ALTER TABLE `seller_brand`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seller_commission`
--
ALTER TABLE `seller_commission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seller_contact`
--
ALTER TABLE `seller_contact`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seller_document`
--
ALTER TABLE `seller_document`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seller_email`
--
ALTER TABLE `seller_email`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seller_opening_hours`
--
ALTER TABLE `seller_opening_hours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seller_phone`
--
ALTER TABLE `seller_phone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
