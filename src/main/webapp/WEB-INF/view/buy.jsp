<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<style>
		body
		{
			padding:50px;
		}
	</style>
</head>

<body>
	<table align="center" >
		<th><center><h2>Shipping Address</h2></center></th>
		<tr>
			<td>Name:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address"><br></td>
		</tr>
		<tr>
			<td>Mobile:&nbsp;&nbsp;&nbsp;<input type="text" name="address"><br></td>
		</tr>
		<tr>
			<td>Address:<textarea cols="40" rows="2"></textarea></td>
		</tr>
		<tr>
			<td>
				<center>
					<form action="confirm" method="post">
						<h4><a href="confirm" class="btn btn-info btn-sm"> confirm</a></h4>
					</form>
				</center>
			</td>
		</tr>
	</table>
</body>
</html>