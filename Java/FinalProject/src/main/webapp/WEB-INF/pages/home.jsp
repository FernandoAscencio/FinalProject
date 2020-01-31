<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href=""/>
<title>Job Finder 1000</title>
</head>
<body>
	<div class=nav align="center">
		<a href="index">Logo</a>
		<c:if test="${!session.logedIn}">
			<a href="login">Log In</a>
			<a href="register">Register</a>
		</c:if>
		<c:if test="${session.logedIn}">
			<a href="logout">Log Out</a>
			<c:if test="${type == 'COMP'}">
				<a href="jobs">Jobs</a>
			</c:if>
			<c:if test="${type == 'CAND'}">
				<a href="curriculumVitae">CV</a>
				<a href="applied">Jobs Applied</a>
			</c:if>
			<a href="profile">Profile</a>
		</c:if>

	</div>

	<div class=list align="left">
		<!-- List Job postings -->
		<h2 align="center">Jobs</h2>
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
