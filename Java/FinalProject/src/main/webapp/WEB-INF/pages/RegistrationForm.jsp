<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<div align="center">
		<h2>Registration</h2>
		<form:form action="saveUser" method="POST" modelAttribute="user" name="user">
			<table>
				<form:hidden path="id" />
				<tr>
					<c:set var="now" value="<%=new java.util.Date()%>" />
					<fmt:formatDate pattern="dd/MM/yyyy" value="${now}" var="today" />
					<td>Created:</td>
					<td><form:input path="createdP" value="${today}"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>Username:</td>
					<td><form:errors path="login" />
						<form:input path="login" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:errors path="password" />
						<form:input path="password" /></td>
				</tr>
				<tr>
					<td>Role: </td>
					<td><form:errors path="role" />
						<form:input path="role" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:errors path="name" />
						<form:input path="name" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:errors path="email" />
						<form:input path="email" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:errors path="location" />
						<form:input path="location" /></td>
				</tr>
				<tr>
					<td>Phone Number:</td>
					<td><form:errors path="phone" />
						<form:input path="phone" /></td>
				</tr>
				<tr>
					<td>Description: </td>
					<td><form:errors path="description" />
						<form:textarea path="description" /></td>
				</tr>
				<tr>
					<td>Type: </td>
					<td><form:errors path="type" />
						<form:input path="" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>