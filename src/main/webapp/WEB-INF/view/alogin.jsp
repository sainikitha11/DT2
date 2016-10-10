<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<title>Login</title>
	<style>
		body
		{
			padding:30px;
		}
	</style>
</head>

<body>
<div class="container">
<h2 class="form-signin-heading">Sign In</h2>
<form name='f' action='/cart/login' method='POST' class="form-signin">
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type='text' name='username' id="inputEmail" class="form-control" placeholder="Email address" required autofocus><br/>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type='password' name='password' id="inputPassword" class="form-control" placeholder="Password" required/>
    <div class="checkbox">
      <label>
         <input type="checkbox" value="remember-me"> Remember me
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>New User? click <a href="UserRegister" >here</a>
</form>
</div>
</body>
</html>