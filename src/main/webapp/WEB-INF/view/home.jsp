<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<title>Shopping</title>
	<style>	
		.carousel-inner > .item > img,
	  		.carousel-inner > .item > a > img 
	  	{
	      	width: 50%;
	      	margin: auto;
	  	}
	  	.container-fluid
	  	{
	  	}
	</style>

<body>
	<div class="header">
		<%@include file="header.jsp"%>
	</div>
	<hr color="blue"></hr>
	${welcome}

	<c:if test="${not empty Welcome}"></c:if>
	${userRole}
		<c:if test="${userRole=='isAdmin'}">
			<%@include file="adminpg.jsp" %>
		</c:if>
		
		<c:if test="${userRole=='isSupplier'}">
			<%@include file="confirm.jsp" %>
		</c:if>
		
		<c:if test="${login==true}">
			<%@include file="login.jsp" %>
		</c:if>
		
		<c:if test="${register==true}">
			<%@include file="register.jsp" %>
		</c:if>
		<br>
		<c:forEach var="c" items="${Categorys}">
			<a href="products?c=${c.cid}" class="list-group-item"> ${c.cname}</a> 
		</c:forEach>
		
	<div class="footer">
		<%@include file="footer.jsp"%>
	</div>
</body>
</head>
</html>