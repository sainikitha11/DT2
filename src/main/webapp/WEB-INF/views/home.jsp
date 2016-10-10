<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<title>Home page...</title>
<style type="text/css">
.navbar-default
{
background-color:#4682B4;
}
.navbar-inverse
{
background-color:#FFFFF0;
}
.navbar-header a
{
height:30px;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 200px;
    background-color: #f1f1f1;
}

li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}

li a.active {
    background-color: #4CAF50;
    color: white;
}

li a:hover:not(.active) {
    background-color: #555;
    color: white;
}
</style>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
    	<div style="float: left; position: absolute; top: 0px; left: 20px;color:#F5F5F5; "><i class="fa fa-facebook-square" aria-hidden="true"></i></div>
    	<div style="float: left; position: absolute; top: 0px; left: 50px;color:#F5F5F5;"><i class="fa fa-github" aria-hidden="true"></i></div>
    	<div style="float: left; position: absolute; top: 0px; left: 80px; color:#F5F5F5;"><i class="fa fa-linkedin-square" aria-hidden="true"></i></div>
        <div style="float: left; position: absolute; top: 0px; left: 110px; color:#F5F5F5;"><i class="fa fa-twitter-square" aria-hidden="true"></i></div>
    	<div style="float: right; position: absolute; top: 0px; right: 450px;color:#F5F5F5;"><a href="contact" style="color:#F5F5F5;"><span class="glyphicon glyphicon-earphone"></span>1800-200-1947</a><br></div>
		<div style="float: right; position: absolute; top: 0px; right: 230px; color:#00008B;"><a href="contact" style="color:#F5F5F5;"><span class="glyphicon glyphicon-map-marker"></span>201 Street no:36,USA</a></div>
		<div style="float: right; position: absolute; top: 0px; right: 20px; color:#00008B;"><a href="contact"style="color:#F5F5F5;"><span class="glyphicon glyphicon-envelope"></span> info@rediffmail.com</a></div>
    </ul>
  </div>
</nav>
<nav class="navbar-inverse">
  <div class="navbar-header">
      <div class="navbar-brand" style="height:40px; font-size:25px; color:#00008B;">Buddies <div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CHAT</span></div></div>
      <div style="float: right; position: absolute; top: 80px; right: 120px;color:#00008B;"><a href="login" style="color:#00008B;"><span class="glyphicon glyphicon-log-in"></span> Login</a><br></div>
      <div style="float: right; position: absolute; top: 80px; right: 40px;color:#00008B;"><a href="signUp" style="color:#00008B;"><span class="glyphicon glyphicon-user"></span> Register</a><br></div>
    </div>
    </nav><br><br><br><br>
    <ul>
  <li><a class="active" href="#home" style="color:#00008B;"><span class="glyphicon glyphicon-home"></span>Home</a></li>
  <li><a href="#about">About Us</a></li>
  <li><a href="#contact">Contact Us</a></li>
  <li><a href="#blog">Blog</a></li>
</ul>
</body>
</html>