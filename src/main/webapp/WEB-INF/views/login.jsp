<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>login</title>
<style>
h1
{
color:#00008B;
}
 </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title" >Login Here..!!!</h1>
            <div class="account-wall">
                <center><img class="img-circle" 
                src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRUmGQMaoWEdRhna6GsKT6jz6ZOmXqMMRbOMF6oofD8NwEKTwXYag"
                 alt="" width="100px" height="100px"></center>
                <br>
                <form:form class="form-signin" action="loginUser">
                <form:input path="mail" type="text" class="form-control" placeholder="Email" required="true"></form:input><br>
                <form:input path="pwd" type="password" class="form-control" placeholder="Password" required="true"></form:input>
                <br>
                <label class="checkbox pull-left">
                    <input type="checkbox" value="remember-me">Remember me</label>
                <br><br>
                <center><button class="btn btn-md btn-info" type="submit">Sign in</button></center>
                <br>
				<center> 
					<p class="message">Not Registered? <a href="signUp" class="">Create a new account..</a></p>
 				</center>
 				</form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>