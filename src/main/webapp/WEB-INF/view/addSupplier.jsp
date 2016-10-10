<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>Supplier</title>
	<style type="text/css">
		.tg 
		{
			border-collapse: collapse;
			border-spacing: 0;
			border-color: #ccc;
		}

		.tg td
		 {
			font-family: Arial, sans-serif;
			font-size: 14px;
			padding: 10px 5px;
			border-style: solid;
			border-width: 1px;
			overflow: hidden;
			word-break: normal;
			border-color: #ccc;
			color: #333;
			background-color: #fff;
		}

		.tg th 
		{
			font-family: Arial, sans-serif;
			font-size: 14px;
			font-weight: normal;
			padding: 10px 5px;
			border-style: solid;
			border-width: 1px;
			overflow: hidden;
			word-break: normal;
			border-color: #ccc;
			color: #333;
			background-color: #f0f0f0;
		}

		.tg .tg-4eph
		{
			background-color: #f9f9f9
		}
	</style>
</head>

<body>

	<h1>Add Supplier</h1>
		<form:form action="storesupplier" enctype="multipart/form-data">
			 <c:forEach var="es" items="${errors}">
				<li>${errors}</li>
			</c:forEach>
		<table>
			<tr>
				<form:input path="sname" hidden="true" />
				<td><form:label path="sname">
						<spring:message text="Name" />
					</form:label>
				</td>
				<td><form:input path="sname" required="true" /></td>
			</tr>
				
			<tr>
				<td><form:label path="saddress">
						<spring:message text="Desc" />
					</form:label>
				</td>
				<td><form:input path="saddress" required="true" /></td>
			</tr>
			
			<tr>
				<td colspan="2">
						<input type="submit" value="<spring:message text="${stat}"/>" />
				</td>
			</tr>
		</table>
	</form:form>
	
	<br>
	<h3>Supplier List</h3>
	
	<c:if test="${not empty supplier}">
		<table class="tg">
			<tr>
				<th width="80">Supplier ID</th>
				<th width="120">Supplier Name</th>
				<th width="200">Supplier Address</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			
			<c:forEach items="${supplier}" var="Supplier">
				<tr>
					<td>${Supplier.sid}</td>
					<td>${Supplier.sname}</td>
					<td>${Supplier.saddress}</td>
					<td><a href="<c:url value='Supplier/edit?s=${Supplier.sid}' />">Edit</a></td>
					<td><a href="<c:url value='Supplier/delete?s=${Supplier.sid}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</body>
</html>