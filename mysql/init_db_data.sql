-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `korisnickoIme` varchar(20) NOT NULL,
  `lozinka` varchar(20) NOT NULL,
  PRIMARY KEY (`korisnickoIme`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES ('admin','admin');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distributer`
--

DROP TABLE IF EXISTS `distributer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distributer` (
  `idDistributer` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `napon` decimal(10,4) NOT NULL,
  `SNABDJEVAC_idSnabdjevac` int NOT NULL,
  `MJESTO_posta` varchar(8) NOT NULL,
  `telefon` varchar(12) NOT NULL,
  `lozinka` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idDistributer`),
  KEY `fk_DISTRIBUTER_SNABDJEVAC1_idx` (`SNABDJEVAC_idSnabdjevac`),
  KEY `fk_DISTRIBUTER_MJESTO1_idx` (`MJESTO_posta`),
  CONSTRAINT `fk_DISTRIBUTER_MJESTO1` FOREIGN KEY (`MJESTO_posta`) REFERENCES `mjesto` (`posta`),
  CONSTRAINT `fk_DISTRIBUTER_SNABDJEVAC1` FOREIGN KEY (`SNABDJEVAC_idSnabdjevac`) REFERENCES `snabdjevac` (`idSnabdjevac`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distributer`
--

LOCK TABLES `distributer` WRITE;
/*!40000 ALTER TABLE `distributer` DISABLE KEYS */;
INSERT INTO `distributer` VALUES (1,'Elektrodistribucija AD',20000.0000,1,'78420','051300201','test'),(2,'Elektrokrajina ',24000.0000,1,'78000','051300202','test');
/*!40000 ALTER TABLE `distributer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dokument`
--

DROP TABLE IF EXISTS `dokument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dokument` (
  `idDokument` int NOT NULL AUTO_INCREMENT,
  `poziv` varchar(16) NOT NULL,
  `datumIzdavanja` date NOT NULL,
  `KNJIGOVODJA_JMBG` varchar(15) NOT NULL,
  `POTROSAC_PIB` varchar(20) NOT NULL,
  `placen` tinyint DEFAULT '0',
  PRIMARY KEY (`idDokument`),
  KEY `fk_DOKUMENT_KNJIGOVODJA1_idx` (`KNJIGOVODJA_JMBG`),
  KEY `fk_DOKUMENT_POTROSAC1_idx` (`POTROSAC_PIB`),
  CONSTRAINT `fk_DOKUMENT_KNJIGOVODJA1` FOREIGN KEY (`KNJIGOVODJA_JMBG`) REFERENCES `knjigovodja` (`JMBG`),
  CONSTRAINT `fk_DOKUMENT_POTROSAC1` FOREIGN KEY (`POTROSAC_PIB`) REFERENCES `potrosac` (`PIB`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dokument`
--

LOCK TABLES `dokument` WRITE;
/*!40000 ALTER TABLE `dokument` DISABLE KEYS */;
INSERT INTO `dokument` VALUES (1,'051300201','2024-03-05','1007000101472','01357246801',1),(11,'051300201','2024-05-23','1007000101472','01357246801',0),(13,'051300201','2024-05-23','1007000101472','01357246801',0),(14,'051300201','2024-05-23','1007000101472','01357246801',0);
/*!40000 ALTER TABLE `dokument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elektricar`
--

DROP TABLE IF EXISTS `elektricar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `elektricar` (
  `JMBG` varchar(15) NOT NULL,
  `ime` varchar(16) NOT NULL,
  `prezime` varchar(32) NOT NULL,
  `DISTRIBUTER_idDistributer` int NOT NULL,
  `lozinka` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`JMBG`),
  KEY `fk_ELEKTRICAR_DISTRIBUTER_idx` (`DISTRIBUTER_idDistributer`),
  CONSTRAINT `fk_ELEKTRICAR_DISTRIBUTER` FOREIGN KEY (`DISTRIBUTER_idDistributer`) REFERENCES `distributer` (`idDistributer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elektricar`
--

LOCK TABLES `elektricar` WRITE;
/*!40000 ALTER TABLE `elektricar` DISABLE KEYS */;
INSERT INTO `elektricar` VALUES ('0103999224003','Djordje','Djordjic',1,'test'),('0203999224004','Petar','Petric',2,'test'),('0303999224005','Milan','Milankovic',2,'test'),('1702967224001','Zoran','Komadina',1,'test'),('1802964224002','Goran','Komadina',1,'test');
/*!40000 ALTER TABLE `elektricar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iskljucenje`
--

DROP TABLE IF EXISTS `iskljucenje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `iskljucenje` (
  `ZAHTJEV_idZahtjev` int NOT NULL,
  PRIMARY KEY (`ZAHTJEV_idZahtjev`),
  CONSTRAINT `fk_ISKLJUCENJE_ZAHTJEV1` FOREIGN KEY (`ZAHTJEV_idZahtjev`) REFERENCES `zahtjev` (`idZahtjev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iskljucenje`
--

LOCK TABLES `iskljucenje` WRITE;
/*!40000 ALTER TABLE `iskljucenje` DISABLE KEYS */;
/*!40000 ALTER TABLE `iskljucenje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `izdane_opomene`
--

DROP TABLE IF EXISTS `izdane_opomene`;
/*!50001 DROP VIEW IF EXISTS `izdane_opomene`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `izdane_opomene` AS SELECT 
 1 AS `idDokument`,
 1 AS `poziv`,
 1 AS `datumIzdavanja`,
 1 AS `KNJIGOVODJA_JMBG`,
 1 AS `POTROSAC_PIB`,
 1 AS `placen`,
 1 AS `dugovanje`,
 1 AS `rok`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `izdani_racuni`
--

DROP TABLE IF EXISTS `izdani_racuni`;
/*!50001 DROP VIEW IF EXISTS `izdani_racuni`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `izdani_racuni` AS SELECT 
 1 AS `idDokument`,
 1 AS `poziv`,
 1 AS `datumIzdavanja`,
 1 AS `KNJIGOVODJA_JMBG`,
 1 AS `POTROSAC_PIB`,
 1 AS `placen`,
 1 AS `potroseno`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `knjigovodja`
--

DROP TABLE IF EXISTS `knjigovodja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `knjigovodja` (
  `JMBG` varchar(15) NOT NULL,
  `PIB` varchar(20) NOT NULL,
  `ime` varchar(16) NOT NULL,
  `prezime` varchar(32) NOT NULL,
  `lozinka` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`JMBG`),
  UNIQUE KEY `PIB_UNIQUE` (`PIB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knjigovodja`
--

LOCK TABLES `knjigovodja` WRITE;
/*!40000 ALTER TABLE `knjigovodja` DISABLE KEYS */;
INSERT INTO `knjigovodja` VALUES ('1007000101472','246813570','Marko','Markovic','test'),('1107000101473','246813571','Petar','Petrovic','test'),('1207000101474','246813572','Aleksandra','Aleksic','test');
/*!40000 ALTER TABLE `knjigovodja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mjesto`
--

DROP TABLE IF EXISTS `mjesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mjesto` (
  `posta` varchar(8) NOT NULL,
  `naziv` varchar(40) NOT NULL,
  PRIMARY KEY (`posta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mjesto`
--

LOCK TABLES `mjesto` WRITE;
/*!40000 ALTER TABLE `mjesto` DISABLE KEYS */;
INSERT INTO `mjesto` VALUES ('78000','Banja Luka'),('78206','Bocac'),('78420','Srbac'),('89000','Trebinje');
/*!40000 ALTER TABLE `mjesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opomena`
--

DROP TABLE IF EXISTS `opomena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opomena` (
  `dugovanje` decimal(6,3) NOT NULL,
  `rok` date NOT NULL,
  `DOKUMENT_idDokument` int NOT NULL,
  PRIMARY KEY (`DOKUMENT_idDokument`),
  CONSTRAINT `fk_OPOMENA_DOKUMENT1` FOREIGN KEY (`DOKUMENT_idDokument`) REFERENCES `dokument` (`idDokument`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opomena`
--

LOCK TABLES `opomena` WRITE;
/*!40000 ALTER TABLE `opomena` DISABLE KEYS */;
INSERT INTO `opomena` VALUES (199.000,'2024-06-23',14);
/*!40000 ALTER TABLE `opomena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ormar`
--

DROP TABLE IF EXISTS `ormar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ormar` (
  `prikljucak` bit(1) NOT NULL,
  `brojilo` decimal(8,2) NOT NULL,
  `POTROSAC_PIB` varchar(20) NOT NULL,
  `iskljucen` bit(1) NOT NULL,
  PRIMARY KEY (`POTROSAC_PIB`),
  CONSTRAINT `fk_ORMAR_POTROSAC1` FOREIGN KEY (`POTROSAC_PIB`) REFERENCES `potrosac` (`PIB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ormar`
--

LOCK TABLES `ormar` WRITE;
/*!40000 ALTER TABLE `ormar` DISABLE KEYS */;
INSERT INTO `ormar` VALUES (_binary '\0',150.00,'01357246801',_binary ''),(_binary '',1592.00,'01357246802',_binary '\0');
/*!40000 ALTER TABLE `ormar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `potrosac`
--

DROP TABLE IF EXISTS `potrosac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `potrosac` (
  `PIB` varchar(20) NOT NULL,
  `naziv` varchar(45) NOT NULL,
  `MJESTO_posta` varchar(8) NOT NULL,
  `telefon` varchar(12) NOT NULL,
  `lozinka` varchar(45) DEFAULT NULL,
  `DISTRIBUTER_idDistributer` int DEFAULT NULL,
  PRIMARY KEY (`PIB`),
  KEY `fk_POTROSAC_MJESTO1_idx` (`MJESTO_posta`),
  KEY `fk_distributer` (`DISTRIBUTER_idDistributer`),
  CONSTRAINT `fk_distributer` FOREIGN KEY (`DISTRIBUTER_idDistributer`) REFERENCES `distributer` (`idDistributer`),
  CONSTRAINT `fk_POTROSAC_MJESTO1` FOREIGN KEY (`MJESTO_posta`) REFERENCES `mjesto` (`posta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `potrosac`
--

LOCK TABLES `potrosac` WRITE;
/*!40000 ALTER TABLE `potrosac` DISABLE KEYS */;
INSERT INTO `potrosac` VALUES ('01357246801','Zoran Komadina','78420','065123001','test',1),('01357246802','Petar Komadina','78420','065123002','test',1),('01357246803','Nikola Bozic','78420','065123003','test',1),('01357246804','Dragan Torbica','78420','065123004','test',2),('01357246805','Dejan Dejanovic','78420','065123005','test',1),('01357246806','Mara Delevic','78000','065123006','test',1),('01357246807','Nebojsa Milankovic','78000','065123007','test',2),('11357246801','PUB \"Eight\"','78420','051123001','test',1),('11357246802','Caffe Bar \"Dom Mlaidh\'','78420','051123002','test',2),('11357246803','Pizzeria \"Qui-Qui\"','78420','051123003','test',1),('11357246804','Restoran \"Monumental\"','78420','051123004','test',1),('11357246805','Caffe Bar \"Candela\"','78000','051123005','test',1),('11357246806','Pekoteka \"Manja\"','78000','051123006','test',1),('11357246807','PUB \"K.S.E.T Pab\"','78000','051123007','test',1);
/*!40000 ALTER TABLE `potrosac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `predracun`
--

DROP TABLE IF EXISTS `predracun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `predracun` (
  `potroseno` decimal(6,2) NOT NULL,
  `idPredracun` int NOT NULL AUTO_INCREMENT,
  `ELEKTRICAR_JMBG` varchar(15) NOT NULL,
  `KNJIGOVODJA_JMBG` varchar(15) NOT NULL,
  `POTROSAC_PIB` varchar(20) NOT NULL,
  PRIMARY KEY (`idPredracun`),
  KEY `fk_PREDRACUN_ELEKTRICAR1_idx` (`ELEKTRICAR_JMBG`),
  KEY `fk_PREDRACUN_KNJIGOVODJA1_idx` (`KNJIGOVODJA_JMBG`),
  KEY `fk_PREDRACUN_POTROSAC1_idx` (`POTROSAC_PIB`),
  CONSTRAINT `fk_PREDRACUN_ELEKTRICAR1` FOREIGN KEY (`ELEKTRICAR_JMBG`) REFERENCES `elektricar` (`JMBG`),
  CONSTRAINT `fk_PREDRACUN_KNJIGOVODJA1` FOREIGN KEY (`KNJIGOVODJA_JMBG`) REFERENCES `knjigovodja` (`JMBG`),
  CONSTRAINT `fk_PREDRACUN_POTROSAC1` FOREIGN KEY (`POTROSAC_PIB`) REFERENCES `potrosac` (`PIB`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predracun`
--

LOCK TABLES `predracun` WRITE;
/*!40000 ALTER TABLE `predracun` DISABLE KEYS */;
INSERT INTO `predracun` VALUES (199.00,1,'0103999224003','1007000101472','01357246801'),(200.00,2,'0103999224003','1007000101472','01357246801'),(150.00,4,'0103999224003','1007000101472','01357246801'),(150.00,5,'0103999224003','1007000101472','01357246801');
/*!40000 ALTER TABLE `predracun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prikljucenje`
--

DROP TABLE IF EXISTS `prikljucenje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prikljucenje` (
  `ZAHTJEV_idZahtjev` int NOT NULL,
  PRIMARY KEY (`ZAHTJEV_idZahtjev`),
  CONSTRAINT `fk_PRIKLJUCENJE_ZAHTJEV1` FOREIGN KEY (`ZAHTJEV_idZahtjev`) REFERENCES `zahtjev` (`idZahtjev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prikljucenje`
--

LOCK TABLES `prikljucenje` WRITE;
/*!40000 ALTER TABLE `prikljucenje` DISABLE KEYS */;
/*!40000 ALTER TABLE `prikljucenje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `racun`
--

DROP TABLE IF EXISTS `racun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `racun` (
  `potroseno` decimal(10,4) NOT NULL,
  `DOKUMENT_idDokument` int NOT NULL,
  PRIMARY KEY (`potroseno`,`DOKUMENT_idDokument`),
  KEY `fk_RACUN_DOKUMENT1_idx` (`DOKUMENT_idDokument`),
  CONSTRAINT `fk_RACUN_DOKUMENT1` FOREIGN KEY (`DOKUMENT_idDokument`) REFERENCES `dokument` (`idDokument`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `racun`
--

LOCK TABLES `racun` WRITE;
/*!40000 ALTER TABLE `racun` DISABLE KEYS */;
INSERT INTO `racun` VALUES (140.0000,1),(199.0000,11);
/*!40000 ALTER TABLE `racun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snabdjevac`
--

DROP TABLE IF EXISTS `snabdjevac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `snabdjevac` (
  `idSnabdjevac` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `napon` decimal(10,4) NOT NULL,
  `MJESTO_posta` varchar(8) NOT NULL,
  `telefon` varchar(12) NOT NULL,
  `lozinka` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idSnabdjevac`),
  KEY `fk_SNABDJEVAC_MJESTO1_idx` (`MJESTO_posta`),
  CONSTRAINT `fk_SNABDJEVAC_MJESTO1` FOREIGN KEY (`MJESTO_posta`) REFERENCES `mjesto` (`posta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snabdjevac`
--

LOCK TABLES `snabdjevac` WRITE;
/*!40000 ALTER TABLE `snabdjevac` DISABLE KEYS */;
INSERT INTO `snabdjevac` VALUES (1,'MH Elektroprivreda RS',50000.0000,'89000','051000301','test');
/*!40000 ALTER TABLE `snabdjevac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zahtjev`
--

DROP TABLE IF EXISTS `zahtjev`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zahtjev` (
  `idZahtjev` int NOT NULL AUTO_INCREMENT,
  `iskljucenje` tinyint DEFAULT NULL,
  `datum` date NOT NULL,
  `odobren` bit(1) DEFAULT NULL,
  `DISTRIBUTER_idDistributer` int NOT NULL,
  `POTROSAC_PIB` varchar(20) NOT NULL,
  PRIMARY KEY (`idZahtjev`),
  KEY `fk_ZAHTJEV_DISTRIBUTER1_idx` (`DISTRIBUTER_idDistributer`),
  KEY `fk_ZAHTJEV_POTROSAC1_idx` (`POTROSAC_PIB`),
  CONSTRAINT `fk_ZAHTJEV_DISTRIBUTER1` FOREIGN KEY (`DISTRIBUTER_idDistributer`) REFERENCES `distributer` (`idDistributer`),
  CONSTRAINT `fk_ZAHTJEV_POTROSAC1` FOREIGN KEY (`POTROSAC_PIB`) REFERENCES `potrosac` (`PIB`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zahtjev`
--

LOCK TABLES `zahtjev` WRITE;
/*!40000 ALTER TABLE `zahtjev` DISABLE KEYS */;
INSERT INTO `zahtjev` VALUES (1,0,'2024-05-23',_binary '\0',1,'01357246801'),(2,0,'2024-05-23',_binary '',1,'01357246801'),(3,1,'2024-05-03',NULL,1,'01357246801');
/*!40000 ALTER TABLE `zahtjev` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `izdane_opomene`
--

/*!50001 DROP VIEW IF EXISTS `izdane_opomene`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`ognjen`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `izdane_opomene` AS select `d`.`idDokument` AS `idDokument`,`d`.`poziv` AS `poziv`,`d`.`datumIzdavanja` AS `datumIzdavanja`,`d`.`KNJIGOVODJA_JMBG` AS `KNJIGOVODJA_JMBG`,`d`.`POTROSAC_PIB` AS `POTROSAC_PIB`,`d`.`placen` AS `placen`,`o`.`dugovanje` AS `dugovanje`,`o`.`rok` AS `rok` from (`opomena` `o` join `dokument` `d` on((`o`.`DOKUMENT_idDokument` = `d`.`idDokument`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `izdani_racuni`
--

/*!50001 DROP VIEW IF EXISTS `izdani_racuni`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`ognjen`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `izdani_racuni` AS select `d`.`idDokument` AS `idDokument`,`d`.`poziv` AS `poziv`,`d`.`datumIzdavanja` AS `datumIzdavanja`,`d`.`KNJIGOVODJA_JMBG` AS `KNJIGOVODJA_JMBG`,`d`.`POTROSAC_PIB` AS `POTROSAC_PIB`,`d`.`placen` AS `placen`,`r`.`potroseno` AS `potroseno` from (`racun` `r` join `dokument` `d` on((`r`.`DOKUMENT_idDokument` = `d`.`idDokument`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-24  0:37:34
