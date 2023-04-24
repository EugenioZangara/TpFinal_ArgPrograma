-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: prode
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `codigo_iso` varchar(5) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`codigo_iso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES ('ARG','Argentina'),('AUS','Australia'),('BEL','Bélgica'),('BRA','Brasil'),('CAN','Canadá'),('CMR','Camerún'),('CRC','Costa Rica'),('CRO','Croacia'),('DEN','Dinamarca'),('ECU','Ecuador'),('ESP','España'),('FRA','Francia'),('GBR','Inglaterra'),('GER','Alemania'),('GHA','Ghana'),('GLS','Gales'),('IRI','Irán'),('JPN','Japón'),('KOR','Corea'),('KSA','Arabia Saudita'),('MAR','Marruecos'),('MEX','México'),('NED','Países Bajos'),('POL','Polonia'),('POR','Portugal'),('QAT','Catar'),('SEN','Senegal'),('SRB','Serbia'),('SUI','Suiza'),('TUN','Túnez'),('URU','Uruguay'),('USA','Estados Unidos');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partido` (
  `id_partido` int NOT NULL AUTO_INCREMENT,
  `equipoA` varchar(5) NOT NULL,
  `equipoB` varchar(5) NOT NULL,
  `golesA` int DEFAULT NULL,
  `golesB` int DEFAULT NULL,
  `id_ronda` int NOT NULL,
  PRIMARY KEY (`id_partido`),
  UNIQUE KEY `equipoA` (`equipoA`,`equipoB`,`id_ronda`),
  KEY `id_ronda` (`id_ronda`),
  KEY `equipoB` (`equipoB`),
  CONSTRAINT `partido_ibfk_1` FOREIGN KEY (`equipoA`) REFERENCES `equipo` (`codigo_iso`),
  CONSTRAINT `partido_ibfk_2` FOREIGN KEY (`equipoB`) REFERENCES `equipo` (`codigo_iso`),
  CONSTRAINT `partido_ibfk_3` FOREIGN KEY (`id_ronda`) REFERENCES `ronda` (`id_ronda`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES (1,'QAT','ECU',4,1,1),(2,'SEN','NED',5,0,1),(3,'QAT','SEN',3,2,1),(4,'NED','ECU',5,0,1),(5,'NED','QAT',5,1,1),(6,'ECU','SEN',0,3,1),(7,'GBR','IRI',4,5,2),(8,'USA','GLS',5,2,2),(9,'GBR','USA',0,4,2),(10,'GLS','IRI',0,4,2),(11,'GLS','GBR',2,4,2),(12,'IRI','USA',1,2,2),(13,'ARG','KSA',3,3,3),(14,'MEX','POL',1,4,3),(15,'ARG','MEX',0,2,3),(16,'POL','KSA',0,5,3),(17,'POL','ARG',1,3,3),(18,'KSA','MEX',0,4,3),(19,'FRA','AUS',1,5,4),(20,'DEN','TUN',4,1,4),(21,'FRA','DEN',5,1,4),(22,'TUN','AUS',1,0,4),(23,'TUN','FRA',2,0,4),(24,'AUS','DEN',3,5,4),(25,'ESP','CRC',5,1,5),(26,'GER','JPN',3,1,5),(27,'ESP','GER',2,2,5),(28,'JPN','CRC',2,3,5),(29,'JPN','ESP',0,5,5),(30,'CRC','GER',4,4,5),(31,'BEL','CAN',2,4,6),(32,'MAR','CRO',1,3,6),(33,'BEL','MAR',2,4,6),(34,'CRO','CAN',2,3,6),(35,'CRO','BEL',2,3,6),(36,'CAN','MAR',5,2,6),(37,'BRA','SRB',1,4,7),(38,'SUI','CMR',1,0,7),(39,'BRA','SUI',2,3,7),(40,'CMR','SRB',0,4,7),(41,'CMR','BRA',1,3,7),(42,'SRB','SUI',5,1,7),(43,'POR','GHA',2,0,8),(44,'URU','KOR',1,5,8),(45,'POR','URU',2,1,8),(46,'KOR','GHA',1,2,8),(47,'KOR','POR',1,0,8),(48,'GHA','URU',4,4,8);
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pronostico`
--

DROP TABLE IF EXISTS `pronostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pronostico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_partido` int NOT NULL,
  `equipo` varchar(5) NOT NULL,
  `resultado` varchar(1) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `resultado` (`resultado`),
  KEY `equipo` (`equipo`),
  KEY `id_partido` (`id_partido`),
  CONSTRAINT `pronostico_ibfk_1` FOREIGN KEY (`id_partido`) REFERENCES `partido` (`id_partido`),
  CONSTRAINT `pronostico_ibfk_2` FOREIGN KEY (`equipo`) REFERENCES `equipo` (`codigo_iso`),
  CONSTRAINT `pronostico_ibfk_3` FOREIGN KEY (`resultado`) REFERENCES `resultado` (`resultado`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronostico`
--

LOCK TABLES `pronostico` WRITE;
/*!40000 ALTER TABLE `pronostico` DISABLE KEYS */;
INSERT INTO `pronostico` VALUES (1,1,'QAT','E','Eugenio'),(2,2,'SEN','E','Eugenio'),(3,3,'QAT','E','Eugenio'),(4,4,'NED','G','Eugenio'),(5,5,'NED','G','Eugenio'),(6,6,'ECU','E','Eugenio'),(7,7,'GBR','E','Eugenio'),(8,8,'USA','P','Eugenio'),(9,9,'GBR','P','Eugenio'),(10,10,'GLS','E','Eugenio'),(11,11,'GLS','E','Eugenio'),(12,12,'IRI','G','Eugenio'),(13,13,'ARG','G','Eugenio'),(14,14,'MEX','G','Eugenio'),(15,15,'ARG','E','Eugenio'),(16,16,'POL','G','Eugenio'),(17,17,'POL','P','Eugenio'),(18,18,'KSA','E','Eugenio'),(19,19,'FRA','P','Eugenio'),(20,20,'DEN','E','Eugenio'),(21,21,'FRA','P','Eugenio'),(22,22,'TUN','G','Eugenio'),(23,23,'TUN','P','Eugenio'),(24,24,'AUS','E','Eugenio'),(25,25,'ESP','P','Eugenio'),(26,26,'GER','E','Eugenio'),(27,27,'ESP','E','Eugenio'),(28,28,'JPN','E','Eugenio'),(29,29,'JPN','G','Eugenio'),(30,30,'CRC','G','Eugenio'),(31,31,'BEL','E','Eugenio'),(32,32,'MAR','E','Eugenio'),(33,33,'BEL','E','Eugenio'),(34,34,'CRO','P','Eugenio'),(35,35,'CRO','E','Eugenio'),(36,36,'CAN','P','Eugenio'),(37,37,'BRA','G','Eugenio'),(38,38,'SUI','E','Eugenio'),(39,39,'BRA','E','Eugenio'),(40,40,'CMR','G','Eugenio'),(41,41,'CMR','G','Eugenio'),(42,42,'SRB','P','Eugenio'),(43,43,'POR','E','Eugenio'),(44,44,'URU','G','Eugenio'),(45,45,'POR','G','Eugenio'),(46,46,'KOR','G','Eugenio'),(47,47,'KOR','E','Eugenio'),(48,48,'GHA','E','Eugenio');
/*!40000 ALTER TABLE `pronostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultado`
--

DROP TABLE IF EXISTS `resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resultado` (
  `resultado` varchar(1) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  `puntaje` int NOT NULL,
  PRIMARY KEY (`resultado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultado`
--

LOCK TABLES `resultado` WRITE;
/*!40000 ALTER TABLE `resultado` DISABLE KEYS */;
INSERT INTO `resultado` VALUES ('E','Empate',1),('G','Ganador',3),('P','Perdedor',0);
/*!40000 ALTER TABLE `resultado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ronda`
--

DROP TABLE IF EXISTS `ronda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ronda` (
  `id_ronda` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) NOT NULL,
  PRIMARY KEY (`id_ronda`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ronda`
--

LOCK TABLES `ronda` WRITE;
/*!40000 ALTER TABLE `ronda` DISABLE KEYS */;
INSERT INTO `ronda` VALUES (1,'Grupo A'),(2,'Grupo B'),(3,'Grupo C'),(4,'Grupo D'),(5,'Grupo E'),(6,'Grupo F'),(7,'Grupo G'),(8,'Grupo H'),(9,'Octavos'),(10,'Cuartos'),(11,'Semifinal'),(12,'Final');
/*!40000 ALTER TABLE `ronda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-24 19:52:31
