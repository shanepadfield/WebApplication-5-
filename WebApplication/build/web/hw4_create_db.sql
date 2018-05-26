/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Shane
 * Created: Apr 10, 2018
 */
-- ----------------------------
--  Table structure for `User`
-- ----------------------------
DROP DATABASE IF EXISTS `webDB`;

CREATE DATABASE webDB;
USE webDB;

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `userID` varchar(50) NOT NULL DEFAULT '',
  `lName` varchar(50) DEFAULT NULL,
  `fName` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address1` varchar(50) DEFAULT NULL,
  `address2` varchar(50) NOT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `zip` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userID`)
);
INSERT INTO `User` (
    userID,
    lName,
    fName,
    email,
    address1,
    address2,
    city,
    `state`,
    zip,
    country,
    password
)
VALUES ('0', 'Georgeson', 'Georgio', 'gg@gmail.com', '123 House Ave.', '', 'Charlotte', 'NC', '28262', 'USA', '123abc');

-- ----------------------------
--  Table structure for `Product`
-- ----------------------------
DROP TABLE IF EXISTS `Item`;

Create TABLE `Item` (
  `itemCode` varchar(50) NOT NULL DEFAULT '',
  `itemName` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `score` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`itemCode`)
);
INSERT INTO `Item`(itemCode, itemName, category, description, score)
VALUES ('0', 'Dokken, Tooth and Nail', 'Metal', 'Classic Dokken, Classic Songs, Classic Album.', '5'),
('1', 'Of Mice and Men, Defy', 'Metal', 'New singer, same sound, banger.', '5'),
('2', 'Protest the Hero, Pacific Myth', 'Metal', 'Flew in under the radar, good one but not as good as Volition.', '4'),
('3', 'Black Flag, Damaged', 'Rock/Pop', 'One of the all time greatest punk albums.', '5'),
('4', 'Carly Rae Jepsen, Emotion', 'Rock/Pop', 'How can you not love this.', '5'),
('5', 'Stone Temple Pilots, Stone Temple Pilots (2018)', 'Rock/Pop', 'New singer here too, Jeff Gut, he good, album good.', '4');


        



