<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Registration</title>
</head>
<body>
	<div align="center">
		<h2>Job</h2>
		<form:form action="saveJob" method="POST" modelAttribute="job" name="job">
			<table>
				<form:hidden path="id"/>
				<tr>
					<c:set var="now" value="<%=new java.util.Date()%>" />
					<fmt:formatDate pattern="dd/MM/yyyy" value="${now}" var="today" />
					<td>Created:</td>
					<td><form:input path="createdAt" value="${today}"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>Title: </td>
					<td><form:errors path="title" />
						<form:input path="title" /></td>
				</tr>
				<tr>
					<td>Description: </td>
					<td><form:errors path="description" />
						<form:input path="description" /></td>
				</tr>
				<tr>
					<td>Salary: </td>
					<td><form:errors path="salary" />
						<form:input path="salary" /></td>
				</tr>
				<tr>
					<td>Type: </td>
					<td><form:errors path="type" />
						<form:select path="type">
							<form:option value="--" label="--Choose"/>
							<form:option value="PERM" label="Permanent"/>
							<form:option value="CONT" label="Contract"/>
							<form:option value="INTE" label="Internship"/>
							<form:option value="FREE" label="Freelance"/>
						</form:select></td>
				</tr>
				<tr>
					<td>Required Skills: </td>
					<td><form:errors path="reqSkills" />
						<form:textarea path="reqSkills" /></td>
				</tr>
				<tr>
					<td>City: </td>
					<td><form:errors path="city" />
						<form:input path="city" /></td>
				</tr>
				<tr>
					<td>End Date: </td>
					<td><form:errors path="endDate" />
						<form:input path="endDate" /></td>
				</tr>
			</table>
			<input type="Submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>