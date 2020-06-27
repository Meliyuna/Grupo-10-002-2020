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
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--

LOCK TABLES `carrito` WRITE;
/*!40000 ALTER TABLE `carrito` DISABLE KEYS */;
INSERT INTO `carrito` VALUES (53,'2020-06-27 03:01:42',0,1,_binary '\0'),(54,'2020-06-27 03:07:00',0,1,_binary '\0'),(55,'2020-06-27 03:07:00',0,1,_binary '\0'),(56,'2020-06-27 03:07:00',0,1,_binary '\0'),(57,'2020-06-27 03:07:01',0,1,_binary '\0'),(58,'2020-06-27 03:10:03',0,1,_binary '\0'),(59,'2020-06-27 03:12:37',0,2,_binary '\0'),(60,'2020-06-27 03:13:13',0,2,_binary '\0'),(61,'2020-06-27 03:14:02',0,2,_binary '\0');
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
INSERT INTO `cliente` VALUES (68,'gonzalezSamara@gmail.com'),(69,'perezromina@gmail.com'),(70,'kpedro@gmail.com'),(71,'lunarocio@gmail.com'),(72,'ferngaston@gmail.com'),(73,'sanchezadrian@gmail.com'),(74,'garciakaren@gmail.com'),(75,'pedrazamarcos@gmail.com'),(76,'alvarezcristian@gmail.com'),(77,'suarezcarla@gmail.com'),(78,'ortizgabriela@gmail.com'),(79,'silvajuliana@gmail.com'),(80,'enzord07@gmail.com');
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
INSERT INTO `empleado` VALUES (46,_binary '',1,'Noche'),(47,_binary '',2,'tarde'),(48,_binary '',3,'noche'),(49,_binary '',7,'tarde'),(50,_binary '',8,'noche'),(51,_binary '',9,'tarde'),(52,_binary '',14,'noche'),(53,_binary '\0',1,'tarde'),(54,_binary '\0',1,'tarde'),(55,_binary '\0',2,'noche'),(56,_binary '\0',2,'tarde'),(57,_binary '\0',3,'noche'),(58,_binary '\0',3,'tarde'),(59,_binary '\0',7,'tarde'),(60,_binary '\0',7,'tarde'),(61,_binary '\0',8,'noche'),(62,_binary '\0',8,'tarde'),(63,_binary '\0',9,'tarde'),(64,_binary '\0',9,'tarde'),(65,_binary '\0',14,'noche'),(66,_binary '\0',14,'noche');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (8,53,'2020-06-27 03:08:28',70,46),(9,54,'2020-06-27 03:09:34',80,46),(10,58,'2020-06-27 03:10:26',80,46);
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'Valentin Vergara 1531',-34.742726,42423734,-58.394499,_binary '\0'),(2,'Italia 406',-34.765325,55307000,-58.401792,_binary '\0'),(3,'Av Espora 3306',-34.82799,42998496,-58.388335,_binary '\0'),(7,'Montevideo 1802',-34.721214,4252300,-58.310765,_binary '\0'),(8,'Juan Domingo Peron 3096',-34.670928,42086419,-58.409735,_binary '\0'),(9,'Calle 44 5835',-34.783289,45213621,-58.173549,_binary '\0'),(14,'Valentin Vergara 1700',-34.740637,43689563,-58.394217,_binary '\0');
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
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` VALUES (1,82,20,'2020-06-27',7,_binary '',1),(2,78,28,'2020-06-27',8,_binary '',1),(3,47,34,'2020-06-27',11,_binary '',1),(4,68,21,'2020-06-27',12,_binary '',1),(5,15,2,'2020-06-27',13,_binary '',1),(6,98,49,'2020-06-27',14,_binary '',1),(7,94,35,'2020-06-27',15,_binary '',1),(8,21,9,'2020-06-27',22,_binary '',1),(9,87,16,'2020-06-27',23,_binary '',1),(10,92,28,'2020-06-27',24,_binary '',1),(11,47,32,'2020-06-27',25,_binary '',1),(12,94,52,'2020-06-27',26,_binary '',1),(13,73,60,'2020-06-27',27,_binary '',1),(14,93,10,'2020-06-27',28,_binary '',1),(15,9,6,'2020-06-27',29,_binary '',1),(16,56,49,'2020-06-27',30,_binary '',1),(17,43,14,'2020-06-27',31,_binary '',1),(18,17,11,'2020-06-27',32,_binary '',1),(19,72,65,'2020-06-27',33,_binary '',1),(20,21,5,'2020-06-27',34,_binary '',1),(21,2,1,'2020-06-27',7,_binary '',2),(22,80,63,'2020-06-27',8,_binary '',2),(23,89,31,'2020-06-27',11,_binary '',2),(24,59,51,'2020-06-27',12,_binary '',2),(25,80,10,'2020-06-27',13,_binary '',2),(26,48,23,'2020-06-27',14,_binary '',2),(27,66,57,'2020-06-27',15,_binary '',2),(28,28,6,'2020-06-27',22,_binary '',2),(29,32,14,'2020-06-27',23,_binary '',2),(30,17,10,'2020-06-27',24,_binary '',2),(31,67,5,'2020-06-27',25,_binary '',2),(32,50,33,'2020-06-27',26,_binary '',2),(33,71,57,'2020-06-27',27,_binary '',2),(34,13,0,'2020-06-27',28,_binary '',2),(35,57,12,'2020-06-27',29,_binary '',2),(36,66,49,'2020-06-27',30,_binary '',2),(37,26,15,'2020-06-27',31,_binary '',2),(38,42,34,'2020-06-27',32,_binary '',2),(39,39,33,'2020-06-27',33,_binary '',2),(40,22,1,'2020-06-27',34,_binary '',2),(41,2,1,'2020-06-27',7,_binary '',3),(42,63,61,'2020-06-27',8,_binary '',3),(43,48,41,'2020-06-27',11,_binary '',3),(44,62,38,'2020-06-27',12,_binary '',3),(45,46,26,'2020-06-27',13,_binary '',3),(46,41,23,'2020-06-27',14,_binary '',3),(47,51,4,'2020-06-27',15,_binary '',3),(48,1,0,'2020-06-27',22,_binary '',3),(49,20,5,'2020-06-27',23,_binary '',3),(50,40,20,'2020-06-27',24,_binary '',3),(51,1,0,'2020-06-27',25,_binary '',3),(52,78,47,'2020-06-27',26,_binary '',3),(53,59,47,'2020-06-27',27,_binary '',3),(54,25,13,'2020-06-27',28,_binary '',3),(55,21,18,'2020-06-27',29,_binary '',3),(56,40,17,'2020-06-27',30,_binary '',3),(57,91,45,'2020-06-27',31,_binary '',3),(58,10,7,'2020-06-27',32,_binary '',3),(59,29,1,'2020-06-27',33,_binary '',3),(60,74,63,'2020-06-27',34,_binary '',3),(61,93,57,'2020-06-27',7,_binary '',7),(62,74,11,'2020-06-27',8,_binary '',7),(63,27,11,'2020-06-27',11,_binary '',7),(64,47,44,'2020-06-27',12,_binary '',7),(65,91,36,'2020-06-27',13,_binary '',7),(66,52,44,'2020-06-27',14,_binary '',7),(67,47,26,'2020-06-27',15,_binary '',7),(68,46,6,'2020-06-27',22,_binary '',7),(69,71,45,'2020-06-27',23,_binary '',7),(70,65,9,'2020-06-27',24,_binary '',7),(71,85,41,'2020-06-27',25,_binary '',7),(72,28,4,'2020-06-27',26,_binary '',7),(73,20,8,'2020-06-27',27,_binary '',7),(74,40,35,'2020-06-27',28,_binary '',7),(75,43,12,'2020-06-27',29,_binary '',7),(76,37,5,'2020-06-27',30,_binary '',7),(77,23,8,'2020-06-27',31,_binary '',7),(78,73,32,'2020-06-27',32,_binary '',7),(79,2,1,'2020-06-27',33,_binary '',7),(80,52,48,'2020-06-27',34,_binary '',7),(81,93,5,'2020-06-27',7,_binary '',8),(82,74,41,'2020-06-27',8,_binary '',8),(83,93,48,'2020-06-27',11,_binary '',8),(84,72,34,'2020-06-27',12,_binary '',8),(85,31,5,'2020-06-27',13,_binary '',8),(86,94,24,'2020-06-27',14,_binary '',8),(87,48,20,'2020-06-27',15,_binary '',8),(88,74,49,'2020-06-27',22,_binary '',8),(89,21,11,'2020-06-27',23,_binary '',8),(90,15,0,'2020-06-27',24,_binary '',8),(91,24,5,'2020-06-27',25,_binary '',8),(92,37,5,'2020-06-27',26,_binary '',8),(93,63,9,'2020-06-27',27,_binary '',8),(94,43,42,'2020-06-27',28,_binary '',8),(95,29,4,'2020-06-27',29,_binary '',8),(96,8,2,'2020-06-27',30,_binary '',8),(97,68,9,'2020-06-27',31,_binary '',8),(98,12,4,'2020-06-27',32,_binary '',8),(99,74,63,'2020-06-27',33,_binary '',8),(100,47,41,'2020-06-27',34,_binary '',8),(101,65,35,'2020-06-27',7,_binary '',9),(102,96,62,'2020-06-27',8,_binary '',9),(103,63,61,'2020-06-27',11,_binary '',9),(104,49,10,'2020-06-27',12,_binary '',9),(105,67,17,'2020-06-27',13,_binary '',9),(106,87,65,'2020-06-27',14,_binary '',9),(107,25,23,'2020-06-27',15,_binary '',9),(108,43,9,'2020-06-27',22,_binary '',9),(109,65,27,'2020-06-27',23,_binary '',9),(110,14,11,'2020-06-27',24,_binary '',9),(111,23,20,'2020-06-27',25,_binary '',9),(112,7,0,'2020-06-27',26,_binary '',9),(113,98,65,'2020-06-27',27,_binary '',9),(114,63,1,'2020-06-27',28,_binary '',9),(115,48,2,'2020-06-27',29,_binary '',9),(116,51,5,'2020-06-27',30,_binary '',9),(117,38,0,'2020-06-27',31,_binary '',9),(118,62,37,'2020-06-27',32,_binary '',9),(119,6,1,'2020-06-27',33,_binary '',9),(120,8,0,'2020-06-27',34,_binary '',9),(121,39,6,'2020-06-27',7,_binary '',14),(122,46,6,'2020-06-27',8,_binary '',14),(123,56,17,'2020-06-27',11,_binary '',14),(124,72,47,'2020-06-27',12,_binary '',14),(125,55,41,'2020-06-27',13,_binary '',14),(126,35,27,'2020-06-27',14,_binary '',14),(127,18,14,'2020-06-27',15,_binary '',14),(128,94,48,'2020-06-27',22,_binary '',14),(129,3,0,'2020-06-27',23,_binary '',14),(130,98,44,'2020-06-27',24,_binary '',14),(131,93,73,'2020-06-27',25,_binary '',14),(132,13,2,'2020-06-27',26,_binary '',14),(133,34,0,'2020-06-27',27,_binary '',14),(134,36,2,'2020-06-27',28,_binary '',14),(135,76,44,'2020-06-27',29,_binary '',14),(136,42,14,'2020-06-27',30,_binary '',14),(137,25,11,'2020-06-27',31,_binary '',14),(138,45,6,'2020-06-27',32,_binary '',14),(139,23,10,'2020-06-27',33,_binary '',14),(140,15,8,'2020-06-27',34,_binary '',14);
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
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (94,7,8,46,NULL,32000,_binary '',53,_binary '\0'),(95,14,4,46,NULL,34960,_binary '',53,_binary '\0'),(96,22,1,46,NULL,3500,_binary '',53,_binary '\0'),(97,7,1,46,NULL,4000,_binary '',54,_binary '\0'),(98,13,1,46,NULL,3000,_binary '',54,_binary '\0'),(99,22,1,46,NULL,3500,_binary '',54,_binary '\0'),(100,13,1,46,NULL,3000,_binary '',58,_binary '\0'),(101,8,1,46,NULL,4199,_binary '',58,_binary '\0'),(102,7,1,46,NULL,4000,_binary '',58,_binary '\0'),(103,8,3,46,NULL,12597,_binary '',55,_binary '\0'),(104,11,3,46,NULL,5247,_binary '',55,_binary '\0'),(105,34,4,46,NULL,7596,_binary '',55,_binary '\0'),(106,7,4,46,NULL,16000,_binary '',56,_binary '\0'),(107,28,7,46,NULL,20895,_binary '',56,_binary '\0'),(108,7,4,47,NULL,16000,_binary '',59,_binary '\0'),(109,14,9,47,NULL,78660,_binary '',60,_binary '\0'),(110,13,7,47,NULL,21000,_binary '',60,_binary '\0'),(111,7,3,47,NULL,12000,_binary '',61,_binary '\0'),(112,11,5,47,NULL,8745,_binary '',61,_binary '\0');
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
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (46,'Jose','Gutierrez','2020-06-27',24543643,_binary '\0'),(47,'Carlos','Null','2002-06-02',35256363,_binary '\0'),(48,'Pedro','Pellegrio','2002-06-03',35335323,_binary '\0'),(49,'Carla','Cortez','2002-02-12',54333212,_binary '\0'),(50,'Fernando','Fernandez','2001-02-11',45332253,_binary '\0'),(51,'Agustin','Quizor','2001-12-04',46433643,_binary '\0'),(52,'Gustavo','Martinez','1998-06-09',33333222,_binary '\0'),(53,'Damian','Santos','1998-02-27',25363356,_binary '\0'),(54,'Ernesto','Baez','1999-02-27',32363312,_binary '\0'),(55,'Alejandro','Muniz','1998-06-08',32456322,_binary '\0'),(56,'Joaquin','Perez','1991-03-19',43323234,_binary '\0'),(57,'Teresa','Reina','2002-06-05',32356323,_binary '\0'),(58,'Guillermo','Obaya','2001-12-10',262644223,_binary '\0'),(59,'Gonzalo','Silva','2001-11-11',32352355,_binary '\0'),(60,'Lucila','Ortiz','2001-05-13',453353632,_binary '\0'),(61,'Diego','Torres','2001-11-12',43424644,_binary '\0'),(62,'Cristina','Gonzales','2002-02-11',43423532,_binary '\0'),(63,'Enzo','Romero','2000-10-16',44323523,_binary '\0'),(64,'Pedro','Perez','2001-11-12',23452642,_binary '\0'),(65,'Lucia','Ortiz','2001-09-09',43466423,_binary '\0'),(66,'Hernan','Merlino','2001-08-12',12342221,_binary '\0'),(68,'Samara','Gonzalez','1993-06-03',36821900,_binary '\0'),(69,'Romina','Perez','1993-04-23',37584120,_binary '\0'),(70,'Pedro','Korsa','2002-06-23',32101251,_binary '\0'),(71,'Rocio','Luna','1980-10-07',25896321,_binary '\0'),(72,'Gaston','Fernandez','1987-08-30',21542369,_binary '\0'),(73,'Adrian','Sanchez','1992-06-13',12365412,_binary '\0'),(74,'Karen','Garcia','1964-02-13',18965230,_binary '\0'),(75,'Marcos','Pedraza','1984-06-03',24156321,_binary '\0'),(76,'Cristian','Alvarez','1979-06-06',25841230,_binary '\0'),(77,'Carla','Suarez','1972-07-22',25693124,_binary '\0'),(78,'Gabriela','Ortiz','1981-02-17',17589412,_binary '\0'),(79,'Juliana','Silva','1990-01-25',28598712,_binary '\0'),(80,'Damian','Ramos','2020-06-02',39926758,_binary '\0');
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
  `baja` bit(1) DEFAULT b'0',
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (5,'pelota','pelota adidas de futbol 5',1500,'2020-05-20',_binary ''),(7,'zapatillas Nike','zapatillas Nike de correr Revolution',4000,'2020-05-21',_binary '\0'),(8,'zapatillas Adidas para correr ','zapatillas Adidas para correr Altrun',4199,'2020-05-21',_binary '\0'),(11,'Ojotas Reebook','Ojotas Rebok Classic Slide color negro con gris',1749,'2020-05-21',_binary '\0'),(12,'Pelota de tenis','Pelota de tenis para jugar tenis',1000,'2020-05-20',_binary '\0'),(13,'Raqueta de tenis ','Raqueta de tenis color rojo autografiada',3000,'2020-05-22',_binary '\0'),(14,'Guantes Adidas de Futbol','Guantes Adidas de Futbol Predator Training',8740,'2020-05-22',_binary '\0'),(15,'Mochila Rebbok','Mochila Rebbok Active Core  color azul',3993,'2020-01-22',_binary '\0'),(22,'Zapatilla Topper','Zapatilla Topper casual',3500,'2020-06-27',_binary '\0'),(23,'Zapatilla reebok busquet','Zapatilla rebok para jugar al busquet',5000,'2020-06-27',_binary '\0'),(24,'Pantalón corto Adidas futbol River','Pantalón corto Adidas de fubol d River Plate',949,'2020-06-27',_binary '\0'),(25,'Pantalón corto Adidas futbol Boca','Pantalón corto Adidas de fubol de Boja Junior',949,'2020-06-27',_binary '\0'),(26,'Campera Puma ','Campera Puuma Urban Mujer ',5549,'2020-06-27',_binary '\0'),(27,'Remera Adidas niño','Remera Adidas Uban Favorite kids',1699,'2020-06-27',_binary '\0'),(28,'Skate','Skate doble cola',2985,'2020-06-27',_binary '\0'),(29,'Colchoneta Merco','Colchoneta deportiva Merco',1260,'2020-06-27',_binary '\0'),(30,'Mancuerna Atletic','Mancuerna Atletic Deluxe 5kg',4430,'2020-06-27',_binary '\0'),(31,'Guantin R2F','Guantin de box R2F',4430,'2020-06-27',_binary '\0'),(32,'Bolsa box R2F','Bolsa de box R2F vinilica',3470,'2020-06-27',_binary '\0'),(33,'Gorra X Capslab','Gorra X Capslab Sylvester',3299,'2020-06-27',_binary '\0'),(34,'Mochila Reebbok','Mochila Reebbok Active Core color negra',1899,'2020-06-27',_binary '\0');
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudstock`
--

LOCK TABLES `solicitudstock` WRITE;
/*!40000 ALTER TABLE `solicitudstock` DISABLE KEYS */;
INSERT INTO `solicitudstock` VALUES (25,'2020-06-27',NULL,_binary '\0',_binary '',104,2),(26,'2020-06-27',NULL,_binary '\0',_binary '',108,1),(27,'2020-06-27',NULL,_binary '\0',_binary '',111,1);
/*!40000 ALTER TABLE `solicitudstock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idEmpleado` int(11) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `idempleadofk_idx` (`idEmpleado`),
  CONSTRAINT `idempleadofk` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (46,'$2a$10$b/8e/FGd/ZVpYDdFO5hIhOcqQJEl/SkOXj/CcdnEhrTtKeiqkeCNC',10,'24543643'),(47,'$2a$10$TV9eJgKU7OVaNscAmRyvPeOZPBO4akTzh2VPOhfXzwa.GmWfmdv2W',11,'35256363'),(48,'$2a$10$tOmM2cMe7PqwVvxnd80Uie.FB9jz1bpEgvlj/EWgv40dqGqrB8vTK',12,'35335323'),(49,'$2a$10$in.JQ4mRK4E5b4JsR./bhujtIIkesxCKL3UsAssTkZjRoHKD8uOxC',13,'54333212'),(50,'$2a$10$08u6TUn6fCKLHzcKRuMvHO9A4dqyHAActakNG72p3EklhLPMN01Ve',14,'45332253'),(51,'$2a$10$wKumujM837RyaUZolNwLVufssVQQGOz60WoZr8.BekF/DOlu47lT.',15,'46433643'),(52,'$2a$10$aVqfmr7fLqgAPXBrOOpJ2OllaQSkHMXAVFw7UzJwsk4CxRZ.T45mi',16,'33333222'),(53,'$2a$10$pVip0B8s.0a9WqV4I9Hqve./LtDlWfMz1lxt1AQHMWswbIqeYrS0e',17,'25363356'),(54,'$2a$10$sX/vUye2syqwkUxeRN1tjuS5V7tUW8rBjTMqkS3AGiQS0cM41f0Vy',18,'32363312'),(55,'$2a$10$KnXX/6buPIkiUAl/oY8xOO0..LcZiCRkDcT6hWLVYS6NK9lMDWrOK',19,'32456322'),(56,'$2a$10$zkh16SB8Nyp8qtkyPNLWcuC8cXpJyilFN0Cn.PCQHrVzNZWJogbWe',20,'43323234'),(57,'$2a$10$62kx8lYObrlNnXNRZer/lujW2P2BJKNO16RwRywC7fmtlSvzFn4/O',21,'32356323'),(58,'$2a$10$IHtdsvKil.uz4WV7niyBQ.L9Q3dWAQhHyZKNFqmtMs7D92o/rEpki',22,'262644223'),(59,'$2a$10$lkGYwzzyo7v/6RqctxcyH.XegCjFMgaMdO9BdzVaNgqaNvYNeqGqO',23,'32352355'),(60,'$2a$10$RzzlonqvtefWbOVdfuiHqeF9rJI.gIwd7GtkgZBBHU125MHCPrVQO',24,'453353632'),(61,'$2a$10$GIolfmgO7ciC5ZyPr9yzv.ahKe1NyQLe.Z0rhOjvCLo.E4nxu5GC6',25,'43424644'),(62,'$2a$10$lpPwFiYVr/BgefqjYUy9AuWyYGMuE122ZYnsg7aTlB7hZRBMTOcfu',26,'43423532'),(63,'$2a$10$DAEJUOIcUv5k3vsH5RD8WuuAMjBw.t2/gxhfxDT9hKSDFrUKpns3u',27,'44323523'),(64,'$2a$10$k2ZgIXUb/gKs46lLjn8TxeRTDuYZF.28ZobZccehZGUjri/RvYHwu',28,'23452642'),(65,'$2a$10$h1e4ASrzXCcHdlNAleMSU.YpIwbAmeldvn9DvWL61IV7jSzAbIVla',29,'43466423'),(66,'$2a$10$p2pFwBjQkiPuj9GLYEtzqujWAy34IsV2f6DXuL6xY9Hfx/.feIqgm',30,'12342221');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
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

-- Dump completed on 2020-06-27  3:40:48
