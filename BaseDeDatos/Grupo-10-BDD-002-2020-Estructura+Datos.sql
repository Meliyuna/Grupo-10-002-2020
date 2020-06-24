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
  `idLocal` int(11) DEFAULT NULL,
  `baja` bit(1) DEFAULT b'0',
  PRIMARY KEY (`idCarrito`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--

LOCK TABLES `carrito` WRITE;
/*!40000 ALTER TABLE `carrito` DISABLE KEYS */;
INSERT INTO `carrito` VALUES (1,NULL,0,2,_binary '\0'),(2,NULL,0,7,_binary '\0'),(3,NULL,0,7,_binary '\0'),(4,NULL,0,8,_binary '\0'),(5,NULL,0,1,_binary '\0'),(6,NULL,0,1,_binary '\0'),(7,NULL,0,2,_binary '\0'),(8,NULL,0,7,_binary '\0'),(9,NULL,0,7,_binary ''),(10,NULL,0,8,_binary '\0'),(11,NULL,0,3,_binary '\0'),(13,NULL,0,1,_binary '\0'),(14,'2020-06-17 18:00:00',0,1,_binary '\0'),(15,'2020-06-17 18:00:00',0,7,_binary '\0'),(24,NULL,0,7,_binary ''),(29,NULL,0,7,_binary ''),(31,NULL,0,7,_binary ''),(32,NULL,0,7,_binary ''),(33,NULL,0,7,_binary ''),(34,NULL,0,7,_binary ''),(35,NULL,0,2,_binary '\0'),(36,NULL,0,3,_binary '\0'),(37,NULL,0,7,_binary ''),(38,NULL,0,7,_binary ''),(39,NULL,0,7,_binary ''),(40,'2020-06-24 14:32:03',0,7,_binary '\0'),(41,'2020-06-24 17:19:19',0,7,_binary '\0'),(42,'2020-06-24 17:22:08',0,7,_binary '\0'),(43,'2020-06-24 17:39:49',0,7,_binary '\0'),(44,'2020-06-24 17:40:34',0,7,_binary '\0'),(45,'2020-06-24 17:44:03',0,2,_binary '\0'),(46,'2020-06-24 17:47:03',0,2,_binary '\0');
/*!40000 ALTER TABLE `carrito` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (25,'martinp@facebook.com'),(26,'meliyunis@facebook.com'),(27,'meliyunis@facebook.com'),(33,''),(34,'rrrrrrrrrrrrrrrr'),(35,'enzord07@gmail.com'),(36,'enzord07@gmail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

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
  `password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `perteneceaolcal_idx` (`idLocal`),
  CONSTRAINT `herencia_persona` FOREIGN KEY (`idEmpleado`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `perteneceaolcal` FOREIGN KEY (`idLocal`) REFERENCES `local` (`idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (28,_binary '\0',7,'tarde','$2a$10$hqom0e7qydsiH8HQo4la0.BFK6N9U.FqtC2pLyyrBr3W8BqlJhypy'),(29,_binary '\0',8,'maÃ±ana',NULL),(30,_binary '',1,'noche',NULL),(31,_binary '\0',2,'tarde',NULL),(32,_binary '',3,'noche',NULL);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `idFactura` int(11) NOT NULL AUTO_INCREMENT,
  `idCarrito` int(11) DEFAULT NULL,
  `fechaFacturado` datetime DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idEmpleadoFactura` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `fkcarrito_idx` (`idCarrito`),
  KEY `fk_clienteee_idx` (`idCliente`),
  KEY `fkemmpleadofact_idx` (`idEmpleadoFactura`),
  CONSTRAINT `fk_clienteee` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkcarrito4` FOREIGN KEY (`idCarrito`) REFERENCES `carrito` (`idCarrito`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkempleadofactira` FOREIGN KEY (`idEmpleadoFactura`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,46,'2020-06-24 17:47:58',36,31);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'Valentin Vergara 1531',-34.742726,42423734,-58.394499,_binary '\0'),(2,'Italia 406',-34.765325,55307000,-58.401792,_binary '\0'),(3,'Av Espora 3306',-34.82799,42998496,-58.388335,_binary '\0'),(7,'Montevideo 1802',-34.721214,42523006,-58.310765,_binary '\0'),(8,'Juan Domingo Peron 3096',-34.670928,42086419,-58.409735,_binary '\0'),(9,'',0,0,0,_binary '');
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` VALUES (1,86,33,'2020-06-06',5,_binary '',1),(2,86,7,'2020-06-06',7,_binary '',1),(3,94,42,'2020-06-06',8,_binary '',1),(4,48,0,'2020-06-06',11,_binary '',1),(5,41,38,'2020-06-06',12,_binary '',1),(6,66,47,'2020-06-06',13,_binary '',1),(7,79,0,'2020-06-06',14,_binary '',1),(8,5,2,'2020-06-06',15,_binary '',1),(9,15,0,'2020-06-06',5,_binary '',2),(10,58,6,'2020-06-06',7,_binary '',2),(11,38,35,'2020-06-06',8,_binary '',2),(12,16,0,'2020-06-06',11,_binary '',2),(13,1,0,'2020-06-06',12,_binary '',2),(14,19,8,'2020-06-06',13,_binary '',2),(15,5,4,'2020-06-06',14,_binary '',2),(16,21,0,'2020-06-06',15,_binary '',2),(17,30,21,'2020-06-06',5,_binary '',3),(18,74,66,'2020-06-06',7,_binary '',3),(19,71,18,'2020-06-06',8,_binary '',3),(20,63,0,'2020-06-06',11,_binary '',3),(21,83,30,'2020-06-06',12,_binary '',3),(22,27,15,'2020-06-06',13,_binary '',3),(23,46,2,'2020-06-06',14,_binary '',3),(24,43,28,'2020-06-06',15,_binary '',3),(25,92,35,'2020-06-06',5,_binary '',7),(26,71,36,'2020-06-06',7,_binary '',7),(27,19,6,'2020-06-06',8,_binary '',7),(28,37,14,'2020-06-06',11,_binary '',7),(29,92,44,'2020-06-06',12,_binary '',7),(30,59,40,'2020-06-06',13,_binary '',7),(31,26,16,'2020-06-06',14,_binary '',7),(32,60,12,'2020-06-06',15,_binary '',7),(33,25,8,'2020-06-06',5,_binary '',8),(34,86,4,'2020-06-06',7,_binary '',8),(35,57,33,'2020-06-06',8,_binary '',8),(36,97,0,'2020-06-06',11,_binary '',8),(37,18,13,'2020-06-06',12,_binary '',8),(38,75,8,'2020-06-06',13,_binary '',8),(39,51,36,'2020-06-06',14,_binary '',8),(40,5,3,'2020-06-06',15,_binary '',8),(41,5,0,'2020-06-18',5,_binary '',1),(42,51,22,'2020-06-18',7,_binary '',1),(43,6,5,'2020-06-18',8,_binary '',1),(44,36,23,'2020-06-18',11,_binary '',1),(45,57,14,'2020-06-18',12,_binary '',1),(46,49,39,'2020-06-18',13,_binary '',1),(47,12,4,'2020-06-18',14,_binary '',1),(48,73,40,'2020-06-18',15,_binary '',1),(49,84,24,'2020-06-18',16,_binary '',1),(50,41,14,'2020-06-18',17,_binary '',1),(51,83,59,'2020-06-18',18,_binary '',1),(52,46,30,'2020-06-18',19,_binary '',1),(53,66,16,'2020-06-18',20,_binary '',1),(54,93,62,'2020-06-18',21,_binary '',1),(55,38,26,'2020-06-18',5,_binary '',2),(56,44,14,'2020-06-18',7,_binary '',2),(57,32,6,'2020-06-18',8,_binary '',2),(58,16,13,'2020-06-18',11,_binary '',2),(59,93,11,'2020-06-18',12,_binary '',2),(60,95,10,'2020-06-18',13,_binary '',2),(61,84,37,'2020-06-18',14,_binary '',2),(62,63,8,'2020-06-18',15,_binary '',2),(63,88,68,'2020-06-18',16,_binary '',2),(64,39,10,'2020-06-18',17,_binary '',2),(65,34,18,'2020-06-18',18,_binary '',2),(66,67,59,'2020-06-18',19,_binary '',2),(67,70,47,'2020-06-18',20,_binary '',2),(68,15,10,'2020-06-18',21,_binary '',2),(69,85,80,'2020-06-18',5,_binary '',3),(70,53,18,'2020-06-18',7,_binary '',3),(71,45,11,'2020-06-18',8,_binary '',3),(72,64,50,'2020-06-18',11,_binary '',3),(73,6,5,'2020-06-18',12,_binary '',3),(74,91,59,'2020-06-18',13,_binary '',3),(75,10,7,'2020-06-18',14,_binary '',3),(76,89,33,'2020-06-18',15,_binary '',3),(77,81,28,'2020-06-18',16,_binary '',3),(78,64,41,'2020-06-18',17,_binary '',3),(79,37,31,'2020-06-18',18,_binary '',3),(80,46,10,'2020-06-18',19,_binary '',3),(81,67,8,'2020-06-18',20,_binary '',3),(82,50,36,'2020-06-18',21,_binary '',3),(83,95,23,'2020-06-18',5,_binary '',7),(84,8,7,'2020-06-18',7,_binary '',7),(85,3,0,'2020-06-18',8,_binary '',7),(86,11,9,'2020-06-18',11,_binary '',7),(87,32,29,'2020-06-18',12,_binary '',7),(88,18,14,'2020-06-18',13,_binary '',7),(89,12,11,'2020-06-18',14,_binary '',7),(90,91,57,'2020-06-18',15,_binary '',7),(91,35,18,'2020-06-18',16,_binary '',7),(92,40,2,'2020-06-18',17,_binary '',7),(93,34,22,'2020-06-18',18,_binary '',7),(94,54,53,'2020-06-18',19,_binary '',7),(95,26,21,'2020-06-18',20,_binary '',7),(96,83,24,'2020-06-18',21,_binary '',7),(97,91,70,'2020-06-18',5,_binary '',8),(98,41,5,'2020-06-18',7,_binary '',8),(99,61,58,'2020-06-18',8,_binary '',8),(100,83,14,'2020-06-18',11,_binary '',8),(101,66,33,'2020-06-18',12,_binary '',8),(102,86,55,'2020-06-18',13,_binary '',8),(103,28,4,'2020-06-18',14,_binary '',8),(104,60,2,'2020-06-18',15,_binary '',8),(105,20,6,'2020-06-18',16,_binary '',8),(106,39,10,'2020-06-18',17,_binary '',8),(107,82,10,'2020-06-18',18,_binary '',8),(108,74,26,'2020-06-18',19,_binary '',8),(109,83,7,'2020-06-18',20,_binary '',8),(110,62,38,'2020-06-18',21,_binary '',8);
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;

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
  `idVendedorOriginal` int(11) DEFAULT NULL,
  `idVendedorAuxiliar` int(11) DEFAULT NULL,
  `subtotal` float DEFAULT NULL,
  `aceptado` bit(1) DEFAULT b'0',
  `idCarrito` int(11) DEFAULT NULL,
  `baja` bit(1) DEFAULT b'0',
  PRIMARY KEY (`idPedido`),
  KEY `fkproducto2_idx` (`idProducto`),
  KEY `fkvendedororigianl_idx` (`idVendedorOriginal`),
  KEY `fkvendedorauxoloar_idx` (`idVendedorAuxiliar`),
  KEY `fkcarrito_idx` (`idCarrito`),
  CONSTRAINT `fkcarrito` FOREIGN KEY (`idCarrito`) REFERENCES `carrito` (`idCarrito`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkproducto2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkvendedorauxoloar` FOREIGN KEY (`idVendedorAuxiliar`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkvendedororigianl` FOREIGN KEY (`idVendedorOriginal`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,5,4,31,NULL,6000,_binary '',1,_binary '\0'),(2,11,7,31,NULL,14000,_binary '',1,_binary '\0'),(3,7,7,31,NULL,28000,_binary '',1,_binary '\0'),(4,5,8,28,NULL,12000,_binary '',2,_binary '\0'),(5,12,14,28,NULL,14000,_binary '',2,_binary '\0'),(6,15,16,28,NULL,63888,_binary '',2,_binary ''),(7,8,11,28,NULL,49500,_binary '',2,_binary '\0'),(8,7,15,28,NULL,60000,_binary '',2,_binary '\0'),(9,7,1,28,NULL,4000,_binary '',3,_binary '\0'),(10,5,8,29,NULL,12000,_binary '',4,_binary '\0'),(11,8,10,29,NULL,45000,_binary '',4,_binary '\0'),(12,13,11,29,NULL,33000,_binary '',4,_binary '\0'),(13,13,8,30,NULL,24000,_binary '',5,_binary '\0'),(14,13,7,30,NULL,21000,_binary '',6,_binary '\0'),(15,7,9,31,NULL,36000,_binary '',7,_binary '\0'),(16,5,4,31,NULL,6000,_binary '',7,_binary '\0'),(17,13,6,31,NULL,18000,_binary '',7,_binary '\0'),(18,11,30,28,NULL,60000,_binary '',2,_binary ''),(19,7,14,28,NULL,56000,_binary '',8,_binary ''),(20,5,7,28,31,10500,_binary '',8,_binary '\0'),(21,5,15,28,NULL,22500,_binary '',NULL,_binary ''),(22,11,28,29,NULL,56000,_binary '',4,_binary '\0'),(23,11,31,30,NULL,62000,_binary '',5,_binary '\0'),(24,11,31,32,NULL,62000,_binary '',11,_binary '\0'),(25,7,10,30,NULL,40000,_binary '',6,_binary '\0'),(26,7,1,30,NULL,4000,_binary '',14,_binary '\0'),(27,13,6,28,NULL,18000,_binary '',8,_binary '\0'),(28,12,7,28,NULL,7000,_binary '',8,_binary '\0'),(29,7,6,28,NULL,24000,_binary '',15,_binary '\0'),(30,13,6,28,NULL,18000,_binary '',15,_binary '\0'),(31,12,6,28,NULL,6000,_binary '',15,_binary '\0'),(32,8,4,28,NULL,18000,_binary '',15,_binary '\0'),(33,14,6,28,NULL,12000,_binary '',15,_binary '\0'),(34,14,10,28,NULL,20000,_binary '',2,_binary ''),(35,5,1,28,NULL,1500,_binary '',29,_binary ''),(36,7,1,28,NULL,4000,_binary '',29,_binary ''),(37,8,1,28,NULL,4500,_binary '',29,_binary ''),(38,11,1,28,NULL,2000,_binary '',29,_binary ''),(39,12,1,28,NULL,1000,_binary '',29,_binary ''),(40,13,1,28,NULL,3000,_binary '',29,_binary ''),(41,15,1,28,NULL,3993,_binary '',29,_binary ''),(42,14,1,28,NULL,2000,_binary '',29,_binary ''),(43,16,1,28,NULL,3514,_binary '',29,_binary ''),(44,17,1,28,NULL,316,_binary '',29,_binary ''),(45,18,1,28,NULL,5723,_binary '',29,_binary ''),(46,19,1,28,NULL,4453,_binary '',29,_binary ''),(47,20,1,28,NULL,355,_binary '',29,_binary ''),(48,21,1,28,NULL,7347,_binary '',29,_binary ''),(49,5,7,28,NULL,10500,_binary '',NULL,_binary ''),(50,20,2,28,NULL,710,_binary '',29,_binary ''),(51,11,9,28,NULL,18000,_binary '',2,_binary ''),(52,11,1,28,31,2000,_binary '',2,_binary ''),(53,11,1,28,NULL,2000,_binary '',2,_binary ''),(54,5,1,31,NULL,1500,_binary '',35,_binary '\0'),(55,5,1,32,NULL,1500,_binary '',11,_binary ''),(56,5,3,28,NULL,4500,_binary '',37,_binary ''),(57,7,2,28,NULL,8000,_binary '',37,_binary ''),(58,5,1,28,NULL,1500,_binary '',NULL,_binary ''),(59,5,1,28,NULL,1500,_binary '',NULL,_binary ''),(60,5,1,28,NULL,1500,_binary '',NULL,_binary ''),(61,5,1,28,NULL,1500,_binary '',NULL,_binary ''),(62,5,1,28,NULL,1500,_binary '',9,_binary ''),(63,5,12,28,NULL,18000,_binary '',32,_binary ''),(64,7,10,30,28,40000,_binary '',5,_binary '\0'),(65,5,13,30,28,19500,_binary '',5,_binary '\0'),(66,11,9,28,NULL,18000,_binary '',15,_binary '\0'),(67,5,10,28,NULL,15000,_binary '',40,_binary '\0'),(68,7,9,28,NULL,36000,_binary '',40,_binary '\0'),(69,11,8,28,NULL,16000,_binary '',40,_binary '\0'),(70,5,8,28,NULL,12000,_binary '',34,_binary ''),(71,5,10,28,NULL,15000,_binary '',38,_binary ''),(72,5,5,28,NULL,7500,_binary '',NULL,_binary ''),(73,8,6,28,NULL,27000,_binary '',39,_binary ''),(74,7,6,28,NULL,24000,_binary '',41,_binary '\0'),(75,8,1,28,NULL,4500,_binary '',41,_binary '\0'),(76,5,1,28,NULL,1500,_binary '',42,_binary '\0'),(77,5,1,28,NULL,1500,_binary '',3,_binary '\0'),(78,5,1,31,NULL,1500,_binary '',45,_binary '\0'),(79,7,1,31,NULL,4000,_binary '',45,_binary '\0'),(80,8,1,31,NULL,4500,_binary '',45,_binary '\0'),(81,11,1,31,NULL,2000,_binary '',45,_binary '\0'),(82,15,14,31,28,55902,_binary '',45,_binary '\0'),(83,13,1,31,28,3000,_binary '',46,_binary '\0');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (25,'Martin','Perez',NULL,1111111,_binary '\0'),(26,'eaegag','fdgafgfg',NULL,23233333,_binary ''),(27,'Melisa','Romero',NULL,35719592,_binary '\0'),(28,'Marcelo','Gomez',NULL,35754872,_binary '\0'),(29,'Ezequiel','Martinez',NULL,5242222,_binary '\0'),(30,'Jose','Aguirre',NULL,2365288,_binary '\0'),(31,'Carlos','Null','2002-06-01',40553765,_binary '\0'),(32,'Luis','pellegrio','2001-01-16',332214525,_binary '\0'),(33,'','',NULL,0,_binary ''),(34,'aaaaaaaaa','aaaaaaaaaaaa','2020-06-09',1111111111111111111,_binary ''),(35,'Damian','Ramos','2020-06-15',3425135,_binary ''),(36,'Damian','Ramos','2020-01-27',39926758,_binary '\0');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `fechaAlta` date DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (5,'pelota','pelota adidas de futbol 5',1500,'2020-05-20'),(7,'zapatillas nike','zapatillas nike de correr',4000,'2020-05-21'),(8,'zapatillas adidas','zapatillas adidas para correr',4500,'2020-05-21'),(11,'ojotas reebook','ojotas para correr muy bien',2000,'2020-05-21'),(12,'pelota de tenis','pelota de tenis para jugar tenis',1000,'2020-05-20'),(13,'raqueta de tenis ','raqueta de tenis para jugar tenis, no sirve para otra cosa',3000,'2020-05-22'),(14,'anteojos de futbolista','anteojos que mejoran la vision a larga distancia, pero empeora a corta distancia',2000,'2020-05-22'),(15,'sombrero de basquet','sombrero para jugar al basquet y distraer al rival',3993,'2020-01-22'),(16,'productox1','desc',3514,NULL),(17,'productox2','desc',316,NULL),(18,'productox3','desc',5723,NULL),(19,'productox4','desc',4453,NULL),(20,'productox5','desc',355,NULL),(21,NULL,NULL,7347,NULL);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudstock`
--

DROP TABLE IF EXISTS `solicitudstock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitudstock` (
  `idSolicitudStock` int(11) NOT NULL AUTO_INCREMENT,
  `fechaAbierta` date DEFAULT NULL,
  `fechaCerrada` date DEFAULT NULL,
  `aceptado` bit(1) DEFAULT NULL,
  `pendiente` bit(1) DEFAULT b'0',
  `idPedido` int(11) DEFAULT NULL,
  `idLocal` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSolicitudStock`),
  KEY `fkpedido2_idx` (`idPedido`),
  KEY `fklocal3_idx` (`idLocal`),
  CONSTRAINT `fklocal3` FOREIGN KEY (`idLocal`) REFERENCES `local` (`idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkpedido2` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudstock`
--

LOCK TABLES `solicitudstock` WRITE;
/*!40000 ALTER TABLE `solicitudstock` DISABLE KEYS */;
INSERT INTO `solicitudstock` VALUES (1,'2020-06-06',NULL,_binary '\0',_binary '',2,8),(2,'2020-06-06','2020-06-18',_binary '\0',_binary '\0',7,2),(3,'2020-06-06','2020-06-18',_binary '\0',_binary '\0',8,2),(4,'2020-06-06',NULL,_binary '\0',_binary '',12,3),(5,'2020-06-06',NULL,_binary '\0',_binary '',14,8),(6,'2020-06-10',NULL,_binary '\0',_binary '',16,3),(7,'2020-06-10',NULL,_binary '\0',_binary '',19,1),(8,'2020-06-10','2020-06-10',_binary '',_binary '\0',20,2),(9,'2020-06-19',NULL,_binary '\0',_binary '',51,2),(10,'2020-06-19','2020-06-19',_binary '',_binary '\0',52,2),(11,'2020-06-19',NULL,_binary '\0',_binary '',53,2),(12,'2020-06-24','2020-06-24',_binary '',_binary '\0',64,7),(13,'2020-06-24','2020-06-24',_binary '',_binary '\0',65,7),(14,'2020-06-24',NULL,_binary '\0',_binary '',77,2),(15,'2020-06-24',NULL,_binary '\0',_binary '',78,7),(16,'2020-06-24',NULL,_binary '\0',_binary '',79,7),(17,'2020-06-24',NULL,_binary '\0',_binary '',80,7),(18,'2020-06-24',NULL,_binary '\0',_binary '',81,7),(19,'2020-06-24','2020-06-24',_binary '',_binary '\0',82,7),(20,'2020-06-24','2020-06-24',_binary '',_binary '\0',83,7);
/*!40000 ALTER TABLE `solicitudstock` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2020-06-24 17:53:47
