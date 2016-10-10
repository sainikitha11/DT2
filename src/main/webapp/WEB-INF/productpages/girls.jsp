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
			src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\girls\2.jpg"
			class="img-responsive">
		<div class="producttitle">shoe</div>
		<div class="productprice">
			<div class="pricetext">£8.45</div>
		</div>
		<div class="pull-left">
			<a href="proddetails" <img src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\?pname=${Product.Pname}"/> class="btn btn-danger btn-sm" role="button">More
				Details</a>
		</div>
		<div class="pull-right">
			<a href="buy" class="btn btn-danger btn-sm" role="button">BUY</a>
		</div>
	</div>
	<div class="col-md-2 column productbox">
		<img
			src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\girls\6.jpg"
			class="img-responsive">
							<img src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\?pname=${Product.Pname}"/>
		<div class="producttitle">Infant shoe</div>
		<div class="productprice">
			<div class="pricetext">£14.7</div>
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
			src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\girls\10.jpg"
			class="img-responsive">
		<div class="producttitle">Sandals</div>
		<div class="productprice">
			<div class="pricetext">£118.5</div>
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
			src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\girls\9.jpg"
			class="img-responsive">
		<div class="producttitle">Toddler Shoes</div>
		<div class="productprice">
			<div class="pricetext">£1008.95</div>
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
			src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\girls\11.jpg"
			class="img-responsive">
		<div class="producttitle">Sandals</div>
		<div class="productprice">
			<div class="pricetext">£823.95</div>
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
			src="C:\Users\Nikitha\workspace\cart\src\main\webapp\resources\images\girls\12.jpg"
			class="img-responsive">
		<div class="producttitle">Sandals</div>
		<div class="productprice">
			<div class="pricetext">£7887.95</div>
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