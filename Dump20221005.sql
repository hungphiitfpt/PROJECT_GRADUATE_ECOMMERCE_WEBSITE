-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: ecommer_db
-- ------------------------------------------------------
-- Server version	8.0.30


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREshop_categoriesIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `role_user`
--

DROP TABLE IF EXISTS `role_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `is_deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_user`
--

LOCK TABLES `role_user` WRITE;
/*!40000 ALTER TABLE `role_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_categories`
--

DROP TABLE IF EXISTS `shop_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_categories` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_code` varchar(50) DEFAULT NULL,
  `category_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `image` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `is_deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_categories`
--

LOCK TABLES `shop_categories` WRITE;
/*!40000 ALTER TABLE `shop_categories` DISABLE KEYS */;
INSERT INTO `shop_categories` VALUES 
(1,'TP01','Thực phẩm',NULL,NULL,'2022-10-02 10:17:47','2022-10-02 10:17:47',_binary '\0'),
(2,'HS02','Hải sản',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(3,'DL','đông lạnh',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(4,'DK','đồ khô',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(5,'DH','đóng hộp',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(6,'RAUCUQUA','Rau Củ',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(7,'GV','gia vị',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(8,'GD','gia dụng',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(9,'CS','Chăm sóc',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(10,'GK','giải khát',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(11,'BK','bánh kẹo',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(12,'VS','vệ sinh',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(13,'TS','sản phẩm từ sữa',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(14,'CB','chế biến sắn',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0'),
(15,'PK','phụ kiện',NULL,NULL,'2022-10-05 20:30:30','2022-10-05 20:30:30',_binary '\0');
/*!40000 ALTER TABLE `shop_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_customer`
--

DROP TABLE IF EXISTS `shop_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `last_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `first_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gender` bit(1) DEFAULT b'0',
  `email` varchar(100) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `avatar` varchar(500) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `shipping_address` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `city` varchar(205) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `country` varchar(205) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_customer`
--

LOCK TABLES `shop_customer` WRITE;
/*!40000 ALTER TABLE `shop_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_order_detail`
--

DROP TABLE IF EXISTS `shop_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_order_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `quantity` decimal(19,4) DEFAULT NULL,
  `unit_price` decimal(19,4) DEFAULT NULL,
  `discount_percentage` float DEFAULT '0',
  `discount_amount` double DEFAULT NULL,
  `order_detail_status` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `date_allocated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkorderdetai_order_idx` (`order_id`),
  KEY `fkorderdetail_product_idx` (`product_id`),
  CONSTRAINT `fkorderdetai_order` FOREIGN KEY (`order_id`) REFERENCES `shop_orders` (`id`),
  CONSTRAINT `fkorderdetail_product` FOREIGN KEY (`product_id`) REFERENCES `shop_products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_order_detail`
--

LOCK TABLES `shop_order_detail` WRITE;
/*!40000 ALTER TABLE `shop_order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_orders`
--

DROP TABLE IF EXISTS `shop_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `employee_id` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `order_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `shipped_date` datetime DEFAULT NULL,
  `ship_name` varchar(50) DEFAULT NULL,
  `ship_address` varchar(500) DEFAULT NULL,
  `ship_city` varchar(255) DEFAULT NULL,
  `ship_state` varchar(255) DEFAULT NULL,
  `ship_country` varchar(255) DEFAULT NULL,
  `shipping_fee` decimal(19,4) DEFAULT NULL,
  `payment_type_id` bigint DEFAULT '1',
  `paid_date` datetime DEFAULT NULL,
  `order_status` varchar(50) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_order_customer_idx` (`customer_id`),
  KEY `fk_order_payment_idx` (`payment_type_id`),
  KEY `fk_order_user_idx` (`employee_id`),
  CONSTRAINT `fk_order_customer` FOREIGN KEY (`customer_id`) REFERENCES `shop_customer` (`id`),
  CONSTRAINT `fk_order_payment` FOREIGN KEY (`payment_type_id`) REFERENCES `shop_payment_types` (`id`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`employee_id`) REFERENCES `role_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_orders`
--

LOCK TABLES `shop_orders` WRITE;
/*!40000 ALTER TABLE `shop_orders` DISABLE KEYS */;
INSERT INTO `shop_orders` VALUES (2,NULL,NULL,'2009-08-02 00:00:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,'2022-10-05 01:09:04','2022-10-05 01:09:04');
/*!40000 ALTER TABLE `shop_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_payment_types`
--

DROP TABLE IF EXISTS `shop_payment_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_payment_types` (
  `id` bigint NOT NULL,
  `payment_code` varchar(50) DEFAULT NULL,
  `payment_name` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `image` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `is_deleted` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_payment_types`
--

LOCK TABLES `shop_payment_types` WRITE;
/*!40000 ALTER TABLE `shop_payment_types` DISABLE KEYS */;
INSERT INTO `shop_payment_types` VALUES (1,'MOMO','Thanh Toán Momo','Thanh toán bằng phương thức momo',NULL,'2022-10-05 01:08:57','2022-10-05 01:08:57',NULL);
/*!40000 ALTER TABLE `shop_payment_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_product_discount`
--

DROP TABLE IF EXISTS `shop_product_discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_product_discount` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint DEFAULT NULL,
  `discount_name` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `is_fixed` bit(1) DEFAULT b'0',
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkdiscount_product_idx` (`product_id`),
  CONSTRAINT `fkdiscount_product` FOREIGN KEY (`product_id`) REFERENCES `shop_products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_product_discount`
--

LOCK TABLES `shop_product_discount` WRITE;
/*!40000 ALTER TABLE `shop_product_discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_product_discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_product_image`
--

DROP TABLE IF EXISTS `shop_product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_product_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint DEFAULT NULL,
  `image` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkimage_product_idx` (`product_id`),
  CONSTRAINT `fkimage_product` FOREIGN KEY (`product_id`) REFERENCES `shop_products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_product_image`
--

LOCK TABLES `shop_product_image` WRITE;
/*!40000 ALTER TABLE `shop_product_image` DISABLE KEYS */;
INSERT INTO `shop_product_image` VALUES 
('1','pd01','1.png'),
('2','pd02','2.png'),
('3','pd03','3.png'),
('4','pd04','4.png'),
('5','pd05','5.png'),
('6','pd06','6.png'),
('7','pd07','7.png'),
('8','pd08','8.png'),
('9','pd09','9.png'),
('10','pd010','10.png'),
('11','pd011','11.png'),
('12','pd012','12.png'),
('13','pd013','13.png'),
('14','pd014','14.png'),
('15','pd015','15.png'),
('16','pd016','16.png'),
('17','pd017','17.png'),
('18','pd018','18.png'),
('19','pd019','19.png'),
('20','pd020','20.png');

/*!40000 ALTER TABLE `shop_product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_product_reviews`
--

DROP TABLE IF EXISTS `shop_product_reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_product_reviews` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `comment` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `is_deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `fkreview_product_idx` (`product_id`),
  CONSTRAINT `fkreview_product` FOREIGN KEY (`product_id`) REFERENCES `shop_products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_product_reviews`
--

LOCK TABLES `shop_product_reviews` WRITE;
/*!40000 ALTER TABLE `shop_product_reviews` DISABLE KEYS */;
INSERT INTO `shop_product_reviews` VALUES 
( '1','PD01','KH01','4','GOOD',NULL,NULL,NULL),
( '2','PD02','KH02','4,3','bad',NULL,NULL,NULL),
( '3','PD03','KH03','3','bad',NULL,NULL,NULL),
( '4','PD04','KH04','5','GOOD',NULL,NULL,NULL),
( '5','PD05','KH05','3,2','bad',NULL,NULL,NULL),
( '6','PD06','KH06','4,5','GOOD',NULL,NULL,NULL),
( '7','PD07','KH07','5','GOOD',NULL,NULL,NULL),
( '8','PD08','KH08','3,2','bad',NULL,NULL,NULL),
( '9','PD09','KH09','3,0','bad',NULL,NULL,NULL),
( '10','PD010','KH010','4','GOOD',NULL,NULL,NULL);
/*!40000 ALTER TABLE `shop_product_reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_product_vouchers`
--

DROP TABLE IF EXISTS `shop_product_vouchers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_product_vouchers` (
  `id` bigint NOT NULL,
  `product_id` bigint DEFAULT NULL,
  `voucher_id` bigint DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `isdeleted_at` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `fkvoucher_product_idx` (`product_id`),
  CONSTRAINT `fkvoucher_product` FOREIGN KEY (`product_id`) REFERENCES `shop_products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_product_vouchers`
--

LOCK TABLES `shop_product_vouchers` WRITE;
/*!40000 ALTER TABLE `shop_product_vouchers` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_product_vouchers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_products`
--

DROP TABLE IF EXISTS `shop_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_code` varchar(25) DEFAULT NULL,
  `product_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `image` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `short_decription` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `decription` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `stand_cost` decimal(19,4) DEFAULT NULL,
  `list_price` decimal(19,4) DEFAULT NULL,
  `quantity_per_unit` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `discountinued` tinyint DEFAULT NULL,
  `is_featured` bit(1) NOT NULL DEFAULT b'0',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `category_id` bigint DEFAULT NULL,
  `supplier_id` bigint DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fkproduct_supplier_idx` (`supplier_id`),
  KEY `fkproduct_category_idx` (`category_id`),
  CONSTRAINT `fkproduct_category` FOREIGN KEY (`category_id`) REFERENCES `shop_categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkproduct_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `shop_suplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_products`
--

LOCK TABLES `shop_products` WRITE;
/*!40000 ALTER TABLE `shop_products` DISABLE KEYS */;
INSERT INTO `shop_products` VALUES 
(1,'TP','thịt heo','1','ds','d',10000.0000,90000,NULL,NULL,_binary '\0',_binary '\0',NULL,NULL,'2022-10-05 20:14:53','2022-10-05 20:14:53'),
(2,'TP','thịt bò','2','ds','d',10000.0000,90000,NULL,NULL,_binary '\0',_binary '\0',NULL,NULL,NULL,NULL),
(3,'HS','cá','3','thịt bò cô bé ','',12000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(4,'HS','mực','4','thịt bò cô bé ','',13000.0000,50000,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(5,'GD','bàn ủi','5','thịt bò cô bé ','',10000.0000,60000,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(6,'GD','hút bụi','6','thịt bò cô bé ','',10000.0000,75000,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(7,'GV','nước măm','7','thịt bò cô bé ','',10000.0000,80000,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(8,'GV','hạt nêm','8','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(9,'DH','PATE','9','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(10,'DH','SPAM','10','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(11,'CS','BÀN CHẢI ','11','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(12,'CS','KHĂN GIẤY','12','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(13,'RC','RAU CẦN','13','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(14,'RC','CÀ RỐT','14','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(15,'VS','nước rửa chén','15','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(16,'VS','nước giặt','16','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(17,'DK','bún khô','17','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(18,'DK','mì gói','18','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(19,'GK','bia','19','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL),
(20,'BK','socola','20','thịt bò cô bé ','',10000.0000,NULL,'',10,_binary '\0',_binary '\0',1,2,NULL,NULL);
/*!40000 ALTER TABLE `shop_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_suplier`
--

DROP TABLE IF EXISTS `shop_suplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_suplier` (
  `id` bigint NOT NULL,
  `supplier_code` varchar(50) DEFAULT NULL,
  `supplier_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `image` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_suplier`
--

LOCK TABLES `shop_suplier` WRITE;
/*!40000 ALTER TABLE `shop_suplier` DISABLE KEYS */;
INSERT INTO `shop_suplier` VALUES 
(1,'NCC001','Nhà cung cấp chị bảy','Chị bảy béo',NULL,NULL,NULL,_binary '\0'),
(2,'NCC002','Nhà cung cấp A','Chị 6 gầy',NULL,NULL,NULL,_binary '\0'),
(3,'NCC003','Nhà cung cấp B','Chị 6 gầy',NULL,NULL,NULL,_binary '\0'),
(4,'NCC004','Nhà cung cấp AEON','Chị 6 gầy',NULL,NULL,NULL,_binary '\0'),
(5,'NCC005','Nhà cung cấp BIGC','Chị 6 gầy',NULL,NULL,NULL,_binary '\0'),
(6,'NCC006','Nhà cung cấp COOPMART','Chị 6 gầy',NULL,NULL,NULL,_binary '\0'),
(7,'NCC007','Nhà cung cấp KIM BIÊN','Chị 6 gầy',NULL,NULL,NULL,_binary '\0'),
(8,'NCC008','Nhà cung cấp ĐỒNG XUÂN','Chị 6 gầy',NULL,NULL,NULL,_binary '\0'),
(9,'NCC009','Nhà cung cấp HAI BA','Chị 6 gầy',NULL,NULL,NULL,_binary '\0'),
(10,'NCC010','Nhà cung cấp BỐN NĂM','Chị 6 gầy',NULL,NULL,NULL,_binary '\0')
;
/*!40000 ALTER TABLE `shop_suplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_warehouse`
--

DROP TABLE IF EXISTS `shop_warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_warehouse` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fkwarehouse_idx` (`product_id`),
  CONSTRAINT `fkwarehouse` FOREIGN KEY (`product_id`) REFERENCES `shop_products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_warehouse`
--

LOCK TABLES `shop_warehouse` WRITE;
/*!40000 ALTER TABLE `shop_warehouse` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_warehouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(405) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `last_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `first_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gender` bit(1) DEFAULT b'0',
  `email` varchar(200) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `address` varchar(400) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `country` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `city` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `is_deleted` bit(1) DEFAULT b'0',
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role_idx` (`role_id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ecommer_db'
--

--
-- Dumping routines for database 'ecommer_db'
--
/*!50003 DROP PROCEDURE IF EXISTS `getListImageByProductId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getListImageByProductId`(IN product_id int)
BEGIN
	SELECT 	p.id, 
		p.product_name, 
        JSON_UNQUOTE(CONCAT('[',GROUP_CONCAT(
		JSON_OBJECT(
		'nameImage', i.image
		)SEPARATOR ','),']')) AS images,
        p.short_decription, 
		p.decription, 
        p.list_price, 
		p.image, 
        p.discountinued, 
        p.quantity_per_unit, 
		p.category_id, 
        p.supplier_id ,
        p.created_at,
        p.updated_at,
        p.is_deleted,
        p.is_featured,
        p.product_code,
        p.stand_cost
FROM 	shop_products as p
		LEFT JOIN shop_product_image as i ON p.id = i.product_id 
where 	is_deleted = false and p.id = product_id
GROUP BY p.id;
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

-- Dump completed on 2022-10-05 20:34:06
