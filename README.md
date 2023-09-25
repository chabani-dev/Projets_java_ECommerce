# Projets_java_ECommerce


créer le projet ecommerce avec le file dynamic web projet 
on modifier le fichier index.js : 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de redirection</title>
</head>
<body>

<!-- Tag de redirection vers les pages xhtml de l'application  -->
<jsp:forward page="/faces/accueil.xhtml"></jsp:forward>

</body>
</html>

on install com.mysql » mysql-connector-j
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
pour se connecter à MySQL Connector Java

on istall maven org.glassfish » javax.faces » 2.2.20

<!-- https://mvnrepository.com/artifact/javax.faces/javax.faces-api -->
<dependency>
    <groupId>javax.faces</groupId>
    <artifactId>javax.faces-api</artifactId>
    <version>2.2</version>
    <scope>provided</scope>
</dependency>

aprés on créer la packages ecommerce 
et dans le webContent on ceéer le fichier pom.xml qui regroupe tout le code connecter et mvnrepository.com


https://www.slideshare.net/mohamedyoussfi9/site-jee-de-ecommerce-bas-sur-spring-jpa-hibernate#9
