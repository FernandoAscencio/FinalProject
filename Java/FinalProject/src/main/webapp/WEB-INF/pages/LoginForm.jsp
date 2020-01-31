<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/BasicFormat.css" />
<title>Login</title>
</head>
<body>
	<a href="index">Logo</a>
	<div align="center">
		<h2>Login</h2>
		<form:form action="processing" method="Post" modelAttribute="login">
			${msr}
			<form:label path="username">Username</form:label>
			<br>
			<form:input path="username" />
			<br>
			<form:label path="password">Password</form:label>
			<br>
			<form:input path="password" />
			<br>
			<input type="Submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>