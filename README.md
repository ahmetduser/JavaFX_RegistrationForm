Tools and Technologies used

JDK 1.8
JavaFX
MySQL Connector java 8.0.19.jar (To be able to use SQL connecter import "com.mysql.jdbc.Driver;") To Download: https://dev.mysql.com/downloads/connector/j/
Apache NetBeans 11
JavaMail(TM) API 1.6.2  --javax.mail.jar  --Email Validation To Download: https://javaee.github.io/javamail/
SceneBuilder --FXML layout

Development Steps

1- Create a simple Java with Ant -> JavaFX FXML Application
2- Creat the MainRegistrationForm class
3- DataBase setup
4- Create the layout for the application by using SceneBuilder
5- Configure the FXMLDocumentController
6- Creat the Countries class
7- Create the if-else block for user's input
8- Create the DataBaseConnection class
9- Create the Record class


DataBase tables:

CREATE TABLE LoginForm.users_table(
	User_ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	User_Name VARCHAR(25),
	Date DATE
);

CREATE TABLE LoginForm.login_info(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	User_Name VARCHAR(25) NOT NULL,
	Mail VARCHAR(40),
	Password VARCHAR(30),
	Country VARCHAR(30),
	City VARCHAR(30),
	Date DATE
);

