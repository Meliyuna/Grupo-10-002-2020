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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--

LOCK TABLES `carrito` WRITE;
/*!40000 ALTER TABLE `carrito` DISABLE KEYS */;
INSERT INTO `carrito` VALUES (1,NULL,0,NULL,2),(2,NULL,0,NULL,7),(3,NULL,0,NULL,7),(4,NULL,0,NULL,8),(5,NULL,0,NULL,1),(6,NULL,0,NULL,1);
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
INSERT INTO `cliente` VALUES (25,'martinp@facebook.com'),(26,'meliyunis@facebook.com'),(27,'meliyunis@facebook.com');
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
INSERT INTO `empleado` VALUES (28,_binary '\0',7,'tarde'),(29,_binary '\0',8,'maÃ±ana'),(30,_binary '',1,'noche'),(31,_binary '\0',2,'tarde'),(32,_binary '',3,'noche');
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
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'Valentin Vergara 1531',-34.742726,42423734,-58.394499,_binary '\0'),(2,'Italia 406',-34.765325,55307000,-58.401792,_binary '\0'),(3,'Av Espora 3306',-34.82799,42998496,-58.388335,_binary '\0'),(7,'Montevideo 1802',-34.721214,42523006,-58.310765,_binary '\0'),(8,'Juan Domingo Peron 3096',-34.670928,42086419,-58.409735,_binary '\0');
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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` VALUES (1,86,33,'2020-06-06',5,_binary '',1),(2,86,18,'2020-06-06',7,_binary '',1),(3,94,42,'2020-06-06',8,_binary '',1),(4,48,31,'2020-06-06',11,_binary '',1),(5,41,38,'2020-06-06',12,_binary '',1),(6,66,47,'2020-06-06',13,_binary '',1),(7,79,0,'2020-06-06',14,_binary '',1),(8,5,2,'2020-06-06',15,_binary '',1),(9,15,7,'2020-06-06',5,_binary '',2),(10,58,15,'2020-06-06',7,_binary '',2),(11,38,35,'2020-06-06',8,_binary '',2),(12,16,0,'2020-06-06',11,_binary '',2),(13,1,0,'2020-06-06',12,_binary '',2),(14,19,14,'2020-06-06',13,_binary '',2),(15,5,4,'2020-06-06',14,_binary '',2),(16,21,0,'2020-06-06',15,_binary '',2),(17,30,21,'2020-06-06',5,_binary '',3),(18,74,66,'2020-06-06',7,_binary '',3),(19,71,18,'2020-06-06',8,_binary '',3),(20,63,31,'2020-06-06',11,_binary '',3),(21,83,30,'2020-06-06',12,_binary '',3),(22,27,15,'2020-06-06',13,_binary '',3),(23,46,2,'2020-06-06',14,_binary '',3),(24,43,28,'2020-06-06',15,_binary '',3),(25,92,15,'2020-06-06',5,_binary '',7),(26,71,67,'2020-06-06',7,_binary '',7),(27,19,10,'2020-06-06',8,_binary '',7),(28,37,30,'2020-06-06',11,_binary '',7),(29,92,57,'2020-06-06',12,_binary '',7),(30,59,53,'2020-06-06',13,_binary '',7),(31,26,22,'2020-06-06',14,_binary '',7),(32,60,10,'2020-06-06',15,_binary '',7),(33,25,8,'2020-06-06',5,_binary '',8),(34,86,4,'2020-06-06',7,_binary '',8),(35,57,33,'2020-06-06',8,_binary '',8),(36,97,28,'2020-06-06',11,_binary '',8),(37,18,13,'2020-06-06',12,_binary '',8),(38,75,8,'2020-06-06',13,_binary '',8),(39,51,36,'2020-06-06',14,_binary '',8),(40,5,3,'2020-06-06',15,_binary '',8);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,5,4,NULL,31,NULL,6000,_binary '',1),(2,11,7,NULL,31,NULL,14000,_binary '',1),(3,7,7,NULL,31,NULL,28000,_binary '',1),(4,5,8,NULL,28,NULL,12000,_binary '',2),(5,12,14,NULL,28,NULL,14000,_binary '',2),(6,15,16,NULL,28,NULL,63888,_binary '',2),(7,8,11,NULL,28,NULL,49500,_binary '',2),(8,7,15,NULL,28,NULL,60000,_binary '',2),(9,7,1,NULL,28,NULL,4000,_binary '',3),(10,5,8,NULL,29,NULL,12000,_binary '',4),(11,8,10,NULL,29,NULL,45000,_binary '',4),(12,13,11,NULL,29,NULL,33000,_binary '',4),(13,13,8,NULL,30,NULL,24000,_binary '',5),(14,13,7,NULL,30,NULL,21000,_binary '',6);
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (25,'Martin','Perez',NULL,1111111,_binary '\0'),(26,'eaegag','fdgafgfg',NULL,23233333,_binary ''),(27,'Melisa','Romero',NULL,35719592,_binary '\0'),(28,'Marcelo','Gomez',NULL,35754872,_binary '\0'),(29,'Ezequiel','Martinez',NULL,5242222,_binary '\0'),(30,'Jose','Aguirre',NULL,2365288,_binary '\0'),(31,'Carlos','Null','2002-06-01',40553765,_binary '\0'),(32,'Luis','pellegrio','2001-01-16',332214525,_binary '\0');
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (5,'pelota','pelota adidas de futbol 5',1500,'2020-05-20'),(7,'zapatillas nike','zapatillas nike de correr',4000,'2020-05-21'),(8,'zapatillas adidas','zapatillas adidas para correr',4500,'2020-05-21'),(11,'ojotas reebook','ojotas para correr muy bien',2000,'2020-05-21'),(12,'pelota de tenis','pelota de tenis para jugar tenis',1000,'2020-05-20'),(13,'raqueta de tenis ','raqueta de tenis para jugar tenis, no sirve para otra cosa',3000,'2020-05-22'),(14,'anteojos de futbolista','anteojos que mejoran la vision a larga distancia, pero empeora a corta distancia',2000,'2020-05-22'),(15,'sombrero de basquet','sombrero para jugar al basquet y distraer al rival',3993,'2020-01-22');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudstock`
--

LOCK TABLES `solicitudstock` WRITE;
/*!40000 ALTER TABLE `solicitudstock` DISABLE KEYS */;
INSERT INTO `solicitudstock` VALUES (1,'2020-06-06',NULL,_binary '\0',_binary '',2,8),(2,'2020-06-06',NULL,_binary '\0',_binary '',7,2),(3,'2020-06-06',NULL,_binary '\0',_binary '',8,2),(4,'2020-06-06',NULL,_binary '\0',_binary '',12,3),(5,'2020-06-06',NULL,_binary '\0',_binary '',14,8);
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

-- Dump completed on 2020-06-06 16:19:20
