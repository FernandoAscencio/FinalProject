<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job</title>
</head>
<body>
	<a href="index">Logo</a>
	<div>
		<table>
			<tr>
				<th colspan="4"><h2>${job.title}</h2></th>
			</tr>
			<tr>
				<td>Company:</td>
				<td colspan="3">${company.name}</td>
			</tr>
			<tr>
				<td>Created:</td>
				<td>${job.createdAt}</td>
				<td>Deadline:</td>
				<td>${job.endDate}</td>
			</tr>
			<tr>
				<td>Address:</td>
				<td colspan="3">${job.city}</td>
			</tr>
			<tr>
				<td colspan="2">Salary:</td>
				<td colspan="2">${job.salary}</td>
			</tr>
			<tr>
				<td colspan="4">Required Skills</td>
			</tr>
			<tr>
				<td colspan="4">${job.reqSkills}</td>
			</tr>
			<tr>
				<td colspan="4">Description</td>
			</tr>
			<tr>
				<td colspan="4">${job.description}</td>
			</tr>
			<tr>
			<td colspan="4">Company Description</td>
			</tr>
			<tr>
			<td>${company.description}</td>
			</tr>
		</table>
		<c:if test="${session.logedIn}">
			<c:if test="${session.userId == company.id}">
				<a href="applicants?id=${job.id}">View Applicants</a>
			</c:if>
				<a href="apply?id=${job.id}">Apply</a>
		</c:if>
	</div>
</body>
</html>