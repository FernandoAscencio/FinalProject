<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Applicants</title>
</head>
<body>
	<a href="index">Logo</a>
	<div align="center">
		<h1>Applicants</h1>
		<table>
			<c:forEach var="app" items="${applicants}">
				<tr>
					<th colspan="2" align="left"><a href="viewCV?id=${app.id}">${app.name}</a></th>
				</tr>
				<tr>
					<td>Title: ${app.role}</td>
					<td>E-mail: ${app.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>