CREATE DATABASE  IF NOT EXISTS `grupo-10-bdd-002-2020` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `grupo-10-bdd-002-2020`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: grupo-10-bdd-002-2020
-- ------------------------------------------------------
-- Server version	5.7.29-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito` (
  `idCarrito` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `total` float DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idLocal` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCarrito`),
  KEY `fkcliente_idx` (`idCliente`),
  CONSTRAINT `fkcliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  CONSTRAINT `herencia_clitnepersonaj` FOREIGN KEY (`idCliente`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `tipoEmpleado` bit(1) DEFAULT NULL,
  `idLocal` int(11) DEFAULT NULL,
  `franjaHoraria` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `perteneceaolcal_idx` (`idLocal`),
  CONSTRAINT `herencia_persona` FOREIGN KEY (`idEmpleado`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `perteneceaolcal` FOREIGN KEY (`idLocal`) REFERENCES `local` (`idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `idFactura` int(11) NOT NULL AUTO_INCREMENT,
  `idLocal` int(11) DEFAULT NULL,
  `idCarrito` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `fklocal4_idx` (`idLocal`),
  KEY `fkcarrito_idx` (`idCarrito`),
  CONSTRAINT `fkcarrito4` FOREIGN KEY (`idCarrito`) REFERENCES `carrito` (`idCarrito`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fklocal4` FOREIGN KEY (`idLocal`) REFERENCES `local` (`idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `local` (
  `idLocal` int(11) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(40) DEFAULT NULL,
  `latitud` double DEFAULT NULL,
  `telefono` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  `baja` bit(1) DEFAULT b'0',
  PRIMARY KEY (`idLocal`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lote`
--

DROP TABLE IF EXISTS `lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lote` (
  `idLote` int(11) NOT NULL AUTO_INCREMENT,
  `cantidadInicial` int(11) DEFAULT NULL,
  `cantidadActual` int(11) DEFAULT NULL,
  `fechaIngreso` date DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  `idLocal` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLote`),
  KEY `fklocal_idx` (`idLocal`),
  KEY `fkproducto_idx` (`idProducto`),
  CONSTRAINT `fklocal` FOREIGN KEY (`idLocal`) REFERENCES `local` (`idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkproducto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `idLocal` int(11) DEFAULT NULL,
  `idVendedorOriginal` int(11) DEFAULT NULL,
  `idVendedorAuxiliar` int(11) DEFAULT NULL,
  `subtotal` float DEFAULT NULL,
  `aceptado` bit(1) DEFAULT b'0',
  `idCarrito` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `fkproducto2_idx` (`idProducto`),
  KEY `fklocall_idx` (`idLocal`),
  KEY `fkvendedororigianl_idx` (`idVendedorOriginal`),
  KEY `fkvendedorauxoloar_idx` (`idVendedorAuxiliar`),
  KEY `fkcarrito_idx` (`idCarrito`),
  CONSTRAINT `fkcarrito` FOREIGN KEY (`idCarrito`) REFERENCES `carrito` (`idCarrito`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fklocall` FOREIGN KEY (`idLocal`) REFERENCES `local` (`idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkproducto2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkvendedorauxoloar` FOREIGN KEY (`idVendedorAuxiliar`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkvendedororigianl` FOREIGN KEY (`idVendedorOriginal`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `dni` bigint(20) DEFAULT NULL,
  `baja` bit(1) DEFAULT b'0',
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `fechaAlta` date DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `solicitudstock`
--

DROP TABLE IF EXISTS `solicitudstock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitudstock` (
  `idSolicitudStock` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `aceptado` bit(1) DEFAULT NULL,
  `idPedido` int(11) DEFAULT NULL,
  `idLocal` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSolicitudStock`),
  KEY `fkpedido2_idx` (`idPedido`),
  KEY `fklocal3_idx` (`idLocal`),
  CONSTRAINT `fklocal3` FOREIGN KEY (`idLocal`) REFERENCES `local` (`idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkpedido2` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'grupo-10-bdd-002-2020'
--

--
-- Dumping routines for database 'grupo-10-bdd-002-2020'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-21 20:37:08
