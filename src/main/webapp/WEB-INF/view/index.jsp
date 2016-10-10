<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Shoes</title>
	<style>	
		.carousel-inner > .item > img,
		  .carousel-inner > .item > a > img
		   {
		      width: 100%;
		      margin: auto;
		  	}
		  .container-fluid
		  {
		  }
		  .container
		  {
			margin: 10px auto;
			text-align: justify;
			padding: 15px 15px 15px 15px;
		  }
		  
  	</style>

</head>

<body>
	
	<div>
	<%@include file="header.jsp"%>
	</div>
	
	<div class="container-fluid" >
	<div class="row">
		<div class="col-md-4">
			<div class="list-group"></div>
		</div>
		<div class="col-md-12">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
			    <ol class="carousel-indicators">
			      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			      <li data-target="#myCarousel" data-slide-to="1"></li>
			      <li data-target="#myCarousel" data-slide-to="2"></li>
			      <li data-target="#myCarousel" data-slide-to="3"></li>
			    </ol>
	 <!-- Wrapper for slides -->
			    <div class="carousel-inner" role="listbox">
			      <div class="item active">
			        <img src="<c:url value="/resources/images/slide-img1.jpg"/>" alt="boys" width="260" height="365">
			      </div>
			
			      <div class="item">
			        <img src="<c:url value="/resources/images/slide-img2.jpg"/>" alt="Girls" width="260" height="365">
			      </div>
			    
			      <div class="item">
			        <img src="<c:url value="/resources/images/slide-img3.jpg"/>" alt="Womens" width="260" height="365">
			      </div>
			
			      <div class="item">
			        <img src="<c:url value="/resources/images/slide1.jpg"/>" alt="Men" width="260" height="325">
			      </div>
			     </div>
	<!-- Left and right controls -->
			    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			      <span class="sr-only">Previous</span>
			    </a>
			    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			      <span class="sr-only">Next</span>
			    </a>
			  </div>
			</div>
		</div>
	</div>
	<div class="container">
		<%@include file="aboutUs.jsp"%>
	</div>
	<div class="container">
		<%@include file="contactUs.jsp"%>
	</div>
	<div class="footer">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>