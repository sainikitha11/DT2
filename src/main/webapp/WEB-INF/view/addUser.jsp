<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
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

.tg th {
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

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
<body>
	<h1>Add a User</h1>
	<c:url var="addAction" value="addCustomer"></c:url>
	<form:form action="${addAction}">
		<table>
			<tr>
				<td><form:label path="uid">
						<spring:message text="ID" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty User.uid}">
						<td><form:input path="uid" disabled="true" readonly="true" />
						</td>
					</c:when>
					<c:otherwise>
						<td><form:input path="uid" pattern=".{6,7}" required="true"
								title="id should contains 6 to 7 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<form:input path="uid" hidden="true" />
				<td><form:label path="firstname">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="firstname" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="address">
						<spring:message text="address" />
					</form:label></td>
				<td><form:input path="address" required="true" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty User.firstname}">
						<input type="submit" value="<spring:message text="Edit User"/>" />
					</c:if> <c:if test="${empty User.firstname}">
						<input type="submit" value="<spring:message text="Add User"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>User List</h3>
	<c:if test="${empty UserList}">
		 <table class="tg">
			<tr>
				<th width="80">User ID</th>
				<th width="120">User Name</th>
				<th width="200">User Address</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${UserList}" var="User">
				<tr>
					<td>${User.uid}</td>
					<td>${User.firstname}</td>
					<td>${User.address}</td>
					<td><a href="<c:url value='edit/${User.uid}' />">Edit</a></td>
					<td><a href="<c:url value='remove/${User.uid}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>

</html>