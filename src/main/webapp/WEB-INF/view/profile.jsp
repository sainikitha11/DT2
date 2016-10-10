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
	<form:form action="/profile" method="post">
		<div class="container">
    	<div class="row">
        	<div class="col-md-offset-5 col-md-6">
            	<div class="form-login">
            		<h4>Register here</h4>
            		<div class="input-group margin-bottom-20">
                   <span class="input-group-addon"><i class="glyphicon glyphicon-user mycolor"></i></span>
                    <form:input path="firstname" type="text" id="firstName" class="form-control input-sm chat-input" placeholder="firstname" readonly="true"></form:input>
                </div>
            	</br>
            	<div class="input-group margin-bottom-20">
                   <span class="input-group-addon"><i class="glyphicon glyphicon-user mycolor"></i></span>
                    <form:input path="lastname" type="text" id="lastName" class="form-control input-sm chat-input" placeholder="lastname" readonly="true"></form:input>
                </div>
            	</br>
               	<div class="input-group margin-bottom-20">
                   <span class="input-group-addon"><i class="glyphicon glyphicon-user mycolor"></i></span>
                    <form:input path="mail" type="text" id="userName" class="form-control input-sm chat-input" placeholder="username" readonly="true"></form:input>
                </div>
            	</br>
                <div class="input-group margin-bottom-20">
                   <span class="input-group-addon"><i class="glyphicon glyphicon-lock mycolor"></i></span>
                    <form:input path="pwd" type="password" id="userPassword" class="form-control input-sm chat-input" placeholder="password"></form:input>
                    
                </div>
          		</br>
          		<div class="input-group margin-bottom-20">
                   <span class="input-group-addon"><i class="glyphicon glyphicon-phone mycolor"></i></span>
                    <form:input path="ph" type="text" id="contact" class="form-control input-sm chat-input" placeholder="contact" ></form:input>
                   
				 </div>
            	</br>
				<div class="wrapper" >
					<a href="updateUser?u=${command.uid}" class="btn btn-info btn-md">Update User</a>
<%-- 					<a href="deleteUser?u=${u.uid}" class="btn btn-info btn-md" >Delete User</a> --%>
				</div>
			</center>
		</div>
	</form:form>
</body>
</html>