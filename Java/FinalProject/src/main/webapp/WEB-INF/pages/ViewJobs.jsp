<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your Jobs</title>
</head>
<body>
	<a href="index">Logo</a>
	<h1 align="center">Job List</h1>
	<c:if test="${company}">
		<a href="newJob">New Job</a>
	</c:if>
	<table>
		<c:forEach var="job" items="${jobs}">
			<tr>
				<th colspan="3" align="left"><a href="job?id=${job.id}">${job.title}</a></th>
			</tr>
			<tr>
				<td>Deadline: ${job.endDate}</td>
				<td>Salary: ${job.salary}</td>
				<td>Type: ${job.type}</td>
			</tr>
			<c:if test="${company}">
				<tr>
					<td><a href="deleteJob?id=${job.id}">Delete</a> <a
						href="editJob?id=${job.id}">Edit</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>