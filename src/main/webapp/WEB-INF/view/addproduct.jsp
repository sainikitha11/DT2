<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>Product Page</title>
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

	<h1>Add a Product</h1>
		<form:form action="storeproduct" enctype="multipart/form-data">
			 <c:forEach var="es" items="${errors}">
				<li>${errors}</li>
			</c:forEach>
			
		<table>
			<tr>
				<form:input path="pname" hidden="true" />
				<td><form:label path="pname">
						<spring:message text="Name" />
					</form:label>
				</td>
				<td><form:input path="pname" required="true" /></td>
			</tr>
			
			<tr>
				<td><form:label path="price">
						<spring:message text="Price" />
					</form:label>
				</td>
				<td><form:input path="price" required="true" /></td>
			</tr>
			
			<tr>
				<td><form:label path="desc">
						<spring:message text="Desc" />
					</form:label>
				</td>
				<td><form:input path="desc" required="true" /></td>
			</tr>
			
			<tr>
				<td><form:label path="category">
						<spring:message text="category" />
					</form:label>
				</td>
				<td>
					<select name="category">
						<c:forEach var="c" items="${Category}">
							<option value="${c.cid}">${c.cname}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td><form:label path="supplier">
						<spring:message text="supplier" />
					</form:label>
				</td>
				<td>
					<select name="supplier">
						<c:forEach var="s" items="${Supplier}">
							<option value="${s.sid}">${s.sname}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td><form:label path="image">Image</form:label></td>
				<td><input type="file" name="image" /></td>
			</tr>
		
			<tr>
				<td colspan="2">
						<input type="submit" value="<spring:message text="${stat}"/>" />
				</td>
			</tr>
		</table>
	</form:form>
	
	<br>
	<h3>Product List</h3>
	
	<c:if test="${not empty products}">
		<table class="tg">
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="200">Product Description</th>
				<th width="80">Price</th>
				<th width="80">category</th>
				<th width="80">Supplier</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			
			<c:forEach items="${products}" var="Product">
				<tr>
					<td>${Product.pid}</td>
					<td>${Product.pname}</td>
					<td>${Product.desc}</td>
					<td>${Product.price}</td>
					<td>${Product.category}</td>
					<td>${Product.supplier}</td>		
					<td><a href="<c:url value='Product/edit?p=${Product.pid}' />">Edit</a></td>
					<td><a href="<c:url value='Product/delete?p=${Product.pid}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</body>
</html>