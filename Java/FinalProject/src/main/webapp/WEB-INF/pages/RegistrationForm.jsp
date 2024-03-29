<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/BasicFormat.css" />
<title>User Registration</title>
</head>
<body>
	<div class="nav">
		<table>
			<tr>
				<td><a href="index">Home</a></td>
			</tr>
		</table>
	</div>
	<div>
		<table>
			<tr>
				<td><a>Home</a></td>
			</tr>
		</table>
	</div>
	<div class="body" align="center">
		<h2>Registration</h2>
		<div>
			<form:form action="saveUser" method="POST" modelAttribute="user"
				name="user">
				<table>
					<form:hidden path="id" />
					<tr>
						<c:set var="now" value="<%=new java.util.Date()%>" />
						<fmt:formatDate pattern="dd/MM/yyyy" value="${now}" var="today" />
						<td>Created:</td>
						<td><form:input path="createdAt" value="${today}"
								readonly="true" /></td>
					</tr>
					<tr>
						<td>Username:</td>
						<td><form:errors path="login" /> <form:input path="login" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><form:errors path="password" /> <form:input
								path="password" type="password" /></td>
					</tr>
					<tr>
						<td>Role:</td>
						<td><form:errors path="role" /> <form:input path="role" /></td>
					</tr>
					<tr>
						<td>Name:</td>
						<td><form:errors path="name" /> <form:input path="name" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><form:errors path="email" /> <form:input path="email" /></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><form:errors path="location" /> <form:input
								path="location" /></td>
					</tr>
					<tr>
						<td>Phone Number:</td>
						<td><form:errors path="phone" /> <form:input path="phone" /></td>
					</tr>
					<tr>
						<td>Description:</td>
					</tr>
					<tr>
						<td colspan="2"><form:errors path="description" /> <form:textarea
								path="description" /></td>
					</tr>
					<tr>
						<td>Type:</td>
						<td><form:errors path="type" /> <form:select path="type">
								<form:option value="--" label="--Choose" />
								<form:option value="COMP" label="Company" />
								<form:option value="CAND" label="Candidate" />
							</form:select></td>
					</tr>
				</table>
				<input type="Submit" value="Submit" />
			</form:form>
		</div>
	</div>
</body>
</html>