<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>Add Category Page</title>
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
	
	<h1>Add a Category</h1>
	<form:form action="storecategory" >
	 	<c:forEach var="e" items="${errors}">
			<li>${e.getDefaultMessage()}" </li>
		</c:forEach>
		<table>
			<tr>
				<form:input path="cname" hidden="true" />
				<td><form:label path="cname">
						<spring:message text="Name" />
					</form:label>
				</td>
				<td><form:input path="cname" required="true" /></td>
			</tr>
			
			<tr>
				<td><form:label path="cdesc">
						<spring:message text="Desc" />
					</form:label>
				</td>
				<td><form:input path="cdesc" required="true" /></td>
			</tr>
			
			<tr>
				<td colspan="2">
						<input type="submit" value="<spring:message text="${stat}"/>" />
				</td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Category List</h3>
	
	<c:if test="${not empty category}">
		<table class="tg">
			<tr>
				<th width="80">Category ID</th>
				<th width="120">Category Name</th>
				<th width="200">Category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			
			<c:forEach items="${category}" var="Category">
				<tr>
					<td>${Category.cid}</td>
					<td>${Category.cname}</td>
					<td>${Category.cdesc}</td>
					<td><a href="<c:url value='Category/edit?c=${Category.cid}' />">Edit</a></td>
					<td><a href="<c:url value='Category/delete?c=${Category.cid}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		
</body>
</html>