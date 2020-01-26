# UserPostWithCacheMech
User Post and Article Creation And Cache Mechanism


#INSTALL:
TOMCAT 8.0
MAVEN
REDIS CACHE with port: 6379 


CREATE DB: TestDB

Create Tables: 

For Storing User Data:
Create table UserDataSet(userId int(11) AUTO_INCREMENT PRIMARY KEY,user_name varchar(55),email VARCHAR(60),password VARCHAR(30),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP);
INSERT DATA:
INSERT INTO UserDataSet(user_name,email,userPassword) VALUES ("Abhimanu Rana","abhirjpt.631@gmail.com","098f6bcd4621d373cade4e832627b4f6");

For Storing User POST Data:
Create table Posts(postId int(11) AUTO_INCREMENT PRIMARY KEY,userId int(11),userText VARCHAR(300),imageLink VARCHAR(300),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP);
INSERT DATA:
INSERT INTO Posts(userId,userText,imageLink) VALUES (1,"USER_POST_TEXT","imgURL");

For Storing User Article Data:
Create table Article(articleId int(11) AUTO_INCREMENT PRIMARY KEY,userId int(11),article_title VARCHAR(100),article_text VARCHAR(500),article_image VARCHAR(300),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP);
INSERT DATA:
INSERT INTO Article(userId,article_title,article_text,article_image) VALUES (1,"USER_ARTICLE_TITLE","USER_ARTICLE_TEXT","imgURL");
