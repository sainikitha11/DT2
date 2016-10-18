<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form:form action="comment" method="POST">
	
	<div class="container">
    	<div class="row">
        	<div class="col-md-offset-5 col-md-6">
            	<div class="form-login">
            		<h4>Register here</h4>
            		
            	<div class="input-group margin-bottom-20">
                   <span class="input-group-addon"><i class="glyphicon glyphicon-lock mycolor"></i></span>
                    <form:input path='cdesc' type="text" id="status" class="form-control input-sm chat-input" placeholder="status"></form:input>
                </div>
          		</br>
          		<div class="wrapper">
					<button class="btn btn-info btn-md">comment sign up</button>
				</div>
			</center>
		</div>
	</form:form>
</body>
</html>