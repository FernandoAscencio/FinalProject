<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/BasicFormat.css" />
<title>Job Finder 1000</title>
</head>
<body>
	<div class="nav">
		<table>
			<tr>
				<td><a href="index">Home</a></td>
				<c:if test="${!session.logedIn}">
					<td><a id="nav" href="login">Log In</a></td>
					<td><a href="register">Register</a></td>
				</c:if>
				<c:if test="${session.logedIn}">
					<td><a href="logout">Log Out</a></td>
					<c:if test="${type == 'COMP'}">
						<td><a href="jobs">Jobs</a></td>
					</c:if>
					<c:if test="${type == 'CAND'}">
						<td><a href="curriculumVitae">CV</a></td>
						<td><a href="applied">Jobs Applied</a></td>
					</c:if>
					<td><a href="profile">Profile</a></td>
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
		<!-- List Job postings -->
		<h1>Jobs</h1>
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
			</c:forEach>
		</table>
	</div>
</body>
</html>
