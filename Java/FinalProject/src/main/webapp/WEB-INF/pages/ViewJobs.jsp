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
<title>Your Jobs</title>
</head>
<body>
	<div class="nav">
		<table>
			<tr>
				<td><a href="index">Home</a></td>
				<c:if test="${company}">
					<td><a href="newJob">New Job</a></td>
				</c:if>
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
	<div class="body">
		<h1 align="center">Job List</h1>
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
	</div>
</body>
</html>