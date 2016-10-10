<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<title>Shopping</title>
</head>

<body>
	<nav class="navbar navbar-inverse">
  	<div class="container-fluid">
    	<div class="navbar-header">
      		<a class="navbar-brand" href="#" style="font-size:30px;">Shoes Club</a>
    	</div>
    	
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      <li><a href="about">About Us</a></li>
      <li><a href="contact">Contact</a></li>
      <li><a href="cart"><span class="glyphicon glyphicon-shopping-cart"></span>View Your Cart</a><br></li>
    </ul>
	</div>
	</nav>
	
	<div style="float: right; position: fixed; top: 0px; right: 20px;color:white;">
		<a href="logout"><span class="glyphicon glyphicon-user"></span>logout</a>
	</div>
				
</body>
</html>