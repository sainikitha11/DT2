<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<title>Shopping</title>
<head>
<style>
.productbox {
	background-color: #ffffff;
	padding: 60px;
	margin-bottom: 10px;
	-webkit-box-shadow: 0 8px 6px -6px #999;
	-moz-box-shadow: 0 8px 6px -6px #999;
	box-shadow: 0 8px 6px -6px #999;
}

.producttitle {
	font-weight: bold;
	padding: 5px 0 5px 0;
}

.productprice {
	border-top: 1px solid #dadada;
	padding-top: 5px;
}

.pricetext {
	font-weight: bold;
	font-size: 1.4em;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="col-md-2 column productbox">
		<img
			src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\men\19.jpg"
			class="img-responsive">
		<div class="producttitle">Bata</div>
		<div class="productprice">
			<div class="pricetext">£6.95</div>
		</div>
		<div class="pull-left">
			<a href="proddetails" class="btn btn-danger btn-sm" role="button">More
				Details</a>
		</div>
		<div class="pull-right">
			<a href="buy" class="btn btn-danger btn-sm" role="button">BUY</a>
		</div>
	</div>
	<div class="col-md-2 column productbox">
		<img
			src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\men\13.jpg"
			class="img-responsive">
		<div class="producttitle">Paragon</div>
		<div class="productprice">
			<div class="pricetext">£5.95</div>
		</div>
		<div class="pull-left">
			<a href="proddetails" class="btn btn-danger btn-sm" role="button">More
				Details</a>
		</div>
		<div class="pull-right">
			<a href="buy" class="btn btn-danger btn-sm" role="button">BUY</a>
		</div>
	</div>
	<div class="col-md-2 column productbox">
		<img
			src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\men\17.jpg"
			class="img-responsive">
		<div class="producttitle">Chappal</div>
		<div class="productprice">
			<div class="pricetext">£8.95</div>
		</div>
		<div class="pull-left">
			<a href="proddetails" class="btn btn-danger btn-sm" role="button">More
				Details</a>
		</div>
		<div class="pull-right">
			<a href="buy" class="btn btn-danger btn-sm" role="button">BUY</a>
		</div>
	</div>
	<div class="col-md-2 column productbox">
		<img
			src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\men\15.jpg"
			class="img-responsive">
		<div class="producttitle">Woodland</div>
		<div class="productprice">
			<div class="pricetext">£9.95</div>
		</div>
		<div class="pull-left">
			<a href="proddetails" class="btn btn-danger btn-sm" role="button">More
				Details</a>
		</div>
		<div class="pull-right">
			<a href="buy" class="btn btn-danger btn-sm" role="button">BUY</a>
		</div>
	</div>
	<div class="col-md-2 column productbox">
		<img
			src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\men\11.jpg"
			class="img-responsive">
		<div class="producttitle">Sparx</div>
		<div class="productprice">
			<div class="pricetext">£6.75</div>
		</div>
		<div class="pull-left">
			<a href="proddetails" class="btn btn-danger btn-sm" role="button">More
				Details</a>
		</div>
		<div class="pull-right">
			<a href="buy" class="btn btn-danger btn-sm" role="button">BUY</a>
		</div>
	</div>

	<div class="col-md-2 column productbox">
		<img
			src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\men\14.jpg"
			class="img-responsive">
		<div class="producttitle">Action</div>
		<div class="productprice">
			<div class="pricetext">£5.15</div>
		</div>
		<div class="pull-left">
			<a href="proddetails" class="btn btn-danger btn-sm" role="button">More
				Details</a>
		</div>
		<div class="pull-right">
			<a href="buy" class="btn btn-danger btn-sm" role="button">BUY</a>
		</div>
	</div>
</body>


</html>