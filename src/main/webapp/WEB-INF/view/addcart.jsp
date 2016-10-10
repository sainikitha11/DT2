<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE head PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<style>
		body 
		{
			margin-top: 20px;
		}
	</style>
</head>

<body>
	<form:form action="storecart" method="POST"> 
	<div class="container" ng-app="">
	<div class="row"> 
	<div class="col-xs-8">
	<div class="panel panel-info">
	<div class="panel-heading">
		<div class="panel-title">
			<div class="row">
				<div class="col-xs-6">
					<h5><span class="glyphicon glyphicon-shopping-cart"></span>Shopping Cart</h5>
				</div>
			</div>
		</div>
	</div>
	<c:forEach var="c" items="${cart}">
	<div class="panel-body"> 
	<div class="row">
		<div class="col-xs-2">
			<img src="<c:url value="/resources/images/${c.product.pname}.jpg"/>" style="width:100px;height:100px;"/>
		</div>
		<div class="col-xs-4">
			<h4 class="product-name"><strong>${product.pname}</strong></h4>
			<h4 class="product-description"><small>${product.desc}</small></h4>
		</div>
	<div class="col-xs-6">
		<div class="col-xs-6 text-right">
			<h6 class="product-price"><strong>${product.price}</strong></h6>
		</div>
		<div class="col-xs-4">
			<input type="number" class="form-control input-sm" value="1" min='1' max='5'>
		</div>
		<div class="col-xs-2">
			<a href="updateCart?c=${c.cartid}" class="btn btn-link btn-xs"><span class="glyphicon glyphicon-refresh"></span></a>&nbsp;
			<a href="cart/delete?c=${c.cartid}" class="btn btn-link btn-xs"><span class="glyphicon glyphicon-trash"></span></a>
		</div>
	</div>
	</div>
	</div>
	</c:forEach>
	<hr>
	<div class="panel-footer">
	<div class="row text-center">
		<div class="col-xs-4">
			<a href="/cart" class="btn btn-info btn-sm btn-block"><span class="glyphicon glyphicon-share-alt"></span> Continue shopping</a>
		</div>
		<div class="col-xs-9">
			<h4 class="text-right">Total <strong>${cartItem.totalPrice}</strong></h4>
		</div>
		<br><br><br>
			<div class="col-xs-3">
				<a href="cart/order?c=${cartItem.user.uid}" class="btn btn-success btn-sm btn-block">Checkout</a>
			</div>
	</div>
	</div>
	
	</div>
	</div>
	</div>
	</div>
	</form:form>
	</body>
</html>