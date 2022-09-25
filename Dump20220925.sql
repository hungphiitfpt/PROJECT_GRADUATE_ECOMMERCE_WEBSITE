-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: project_graduate_ecommerce_website
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `fullname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `photo` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `activated` bit(1) DEFAULT NULL,
  `admin` bit(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `idcategory` varchar(10) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`idcategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('1','Thịt, Cá, Trứng, Hải Sản'),('2','Rau, Củ, Trái Cây'),('3','Thực Phẩm Đông Mát'),('4','Mì, Miến, Cháo, Phở'),('5','Gạo, Bột, Đồ Khô');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color` (
  `idcolor` varchar(10) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`idcolor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES ('1','Đỏ '),('2','Vàng'),('3','Đen'),('4','Xanh nước biển'),('5','Xanh lá cây'),('6','Trắng');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `orderid` int DEFAULT NULL,
  `productid` int DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKproduct_idx` (`productid`),
  KEY `FKorder_idx` (`orderid`),
  CONSTRAINT `FKorder` FOREIGN KEY (`orderid`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKproduct` FOREIGN KEY (`productid`) REFERENCES `products` (`idproduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaccounts_idx` (`username`),
  CONSTRAINT `FKaccounts` FOREIGN KEY (`username`) REFERENCES `accounts` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `idproduct` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `size` varchar(10) DEFAULT NULL,
  `color` varchar(10) DEFAULT NULL,
  `category` varchar(10) NOT NULL,
  `image` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantitysold` int DEFAULT NULL,
  `saleoff` int DEFAULT NULL,
  `quantity` int NOT NULL,
  `datecreate` date DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`idproduct`),
  KEY `FKcolor_idx` (`color`),
  KEY `fksize_idx` (`size`),
  KEY `fkcategory_idx` (`category`),
  CONSTRAINT `fkcategory` FOREIGN KEY (`category`) REFERENCES `category` (`idcategory`),
  CONSTRAINT `fkcolor` FOREIGN KEY (`color`) REFERENCES `color` (`idcolor`),
  CONSTRAINT `fksize` FOREIGN KEY (`size`) REFERENCES `size` (`idsize`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Cá basa cắt khúc khay 500g','2','2','2','product-1.jpg',109999,NULL,30,44,NULL,'Mô Tả chi tiết Cá ba sa'),(2,'Sườn non heo G khay 300g (2-4 miếng)','2','2','3','product-2.jpg',123000,NULL,NULL,55,NULL,'Mô tả sườn non'),(3,'Đùi bò Úc tươi Trung Đồng hút chân không khay 250g','1','1','3','product-3.jpg',213000,NULL,20,64,NULL,'đây là mô tả'),(4,'Cốt lết heo nhập khẩu đông lạnh khay 500g (2-4 miếng)','3','4','4','product-3.jpg',230111,NULL,NULL,324,NULL,'đây là mô tả'),(5,'Ức gà tươi phi lê C.P khay 500g (1-3 miếng)','2','2','2','product-4.jpg',23300,NULL,20,43,NULL,'đây là mô tả'),(6,'Đùi gà góc tư C.P khay 500g (1-3 miếng)','1','3','2','product-3.jpg',4000,NULL,NULL,34,NULL,'đây là mô tả'),(7,'Sườn già heo C.P khay 500g (9-11 miếng)','1','3','2','product-3.jpg',5000,NULL,NULL,234,NULL,'đây là mô tả'),(8,'Đuôi heo C.P khay 500g (7-9 miếng)','3','1','2','product-5.jpg',2000,NULL,10,654,NULL,'đây là mô tả'),(9,'213','3','1','2','product-3.jpg',2000,NULL,NULL,0,NULL,'đây là mô tả'),(10,'ádasd','2','1','2','product-3.jpg',4000,NULL,NULL,234,NULL,'đây là mô tả'),(11,'123','3','1','2','product-3.jpg',3000,NULL,NULL,324,NULL,'đây là mô tả'),(12,'123','3','1','2','product-6.jpg',2000200,NULL,50,34,NULL,'đây là mô tả'),(13,'ád','3','2','2','product-3.jpg',2000,NULL,NULL,0,NULL,'đây là mô tả'),(14,'fds','3','2','2','product-3.jpg',20000,NULL,NULL,435,NULL,'đây là mô tả'),(15,'sdf','3','3','3','product-3.jpg',20000,NULL,NULL,23,NULL,'đây là mô tả'),(16,'dsf','3','4','2','product-3.jpg',10000,NULL,NULL,324,NULL,'đây là mô tả'),(17,'qưe','3','3','2','product-3.jpg',20000,NULL,NULL,45,NULL,'đây là mô tả'),(18,'sdf','3','3','2','product-3.jpg',30000,NULL,NULL,234,NULL,'đây là mô tả'),(19,'ưqe','3','2','2','product-3.jpg',40000,NULL,NULL,234,NULL,'đây là mô tả'),(20,'33','3','2','2','product-3.jpg',3000,NULL,NULL,435,NULL,'đây là mô tả'),(21,'','3','2','2','product-2.jpg',30000,NULL,NULL,634,NULL,'đây là mô tả'),(22,'Cá heo cắt khúc khay 500g','2','2','2','product-1.jpg',109999,NULL,30,3,'2022-09-09','đây là mô tả'),(23,'cá chà bá hà bá ','2','1','2',NULL,100000,NULL,10,1002,NULL,'đây là mô tả'),(24,'thịt bò mỹ tho','1','2','2',NULL,1000,NULL,10,10000,NULL,NULL),(25,'cá kakaka','1','1','1',NULL,10000,NULL,9,102,NULL,NULL),(26,'Khoai Lang','1','1','1',NULL,300000,NULL,320000,3423,NULL,NULL),(27,'thảo cứt','1','1','1',NULL,100000,NULL,NULL,100,NULL,NULL);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `size` (
  `idsize` varchar(10) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`idsize`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES ('1','Nhỏ'),('2','Vừa'),('3','Lớn'),('4','Oversize');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `firstname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `lastname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `city` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `country` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `cmnd` varchar(45) DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (8,'hungphiitfpt@gmail.com','$2a$10$lbAHDV9vafnvwZHWH5NYQemvbmDSwW925Ex126M9KODI92Jc77P/6','Hùng','Phi','admin','Việt Nam',NULL,NULL,NULL,NULL),(11,'abc@gmail.com','$2a$10$Bd3WUTC9ZW2DVyZezkc83u9kYdhRrOg79u2UPgGb2VhQliLwSzDH2','ads','ád','hungphias','Việt Nam','123123','123213','23123',NULL),(12,'ac@gmail.com','$2a$10$KENVhntFtCAtBI/eGkrSquMntvqHfLMqEIuNhDt1KU1b7MHrC4LW6','ads','ád','223','Việt Nam','123123','123213','23123',NULL),(13,'23321@gmail.com','$2a$10$u4XcUgxb6YRioD2fDzTjl.7fPD/0f6wWwMSBKOkMLuSE/kPVIWIp2','ads','ád','2asd','Việt Nam','123123','123213','jjaskd',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'project_graduate_ecommerce_website'
--

--
-- Dumping routines for database 'project_graduate_ecommerce_website'
--
/*!50003 DROP PROCEDURE IF EXISTS `findAllProductSaleOff` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findAllProductSaleOff`()
BEGIN
 SELECT * FROM products WHERE saleoff > 0 ORDER BY saleoff DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-25 14:51:38
