<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/BasicFormat.css" />
<title>CV Form</title>
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
	<div class="body">
		<h1>Curriculum Vitae</h1>

		<c:set var="now" value="<%=new java.util.Date()%>" />
		<fmt:formatDate pattern="dd/MM/yyyy" value="${now}" var="today" />
		<c:if test="${session.userId == cv.userId}">
			<div class="add">
				<details>
					<summary>Add Education</summary>
					<form:form action="addEducation" method="Post" modelAttribute="edu">
						<table>
							<form:hidden path="id" />
							<tr>
								<th colspan="4">Program:</th>
							</tr>
							<tr>
								<td colspan="4"><form:input path="program" /></td>
							</tr>
							<tr>
								<th colspan="4">Institute:</th>
							</tr>
							<tr>
								<td colspan="4"><form:input path="institute" /></td>
							</tr>
							<tr>
								<td>Start:</td>
								<td><form:input path="startDate" /></td>
								<td>Finish:</td>
								<td><form:input path="endDate" /></td>
							</tr>
							<tr>
								<th colspan="4">Description:</th>
							</tr>
							<tr>
								<td colspan="4"><form:textarea path="description" /></td>
							</tr>
						</table>
						<input type="Submit" value="Add" />
					</form:form>
				</details>
			</div>
		</c:if>
		<c:if test="${session.userId == cv.userId}">
			<div class="add">
				<details>
					<summary>Add Work Experience</summary>
					<form:form action="addWorkExp" method="post" modelAttribute="we">
						<table>
							<form:hidden path="id" />
							<tr>
								<th colspan="4">Title:</th>
							</tr>
							<tr>
								<td colspan="4"><form:input path="title" /></td>
							</tr>
							<tr>
								<td>Start:</td>
								<td><form:input path="startDate" /></td>
								<td>Finish:</td>
								<td><form:input path="endDate" /></td>
							</tr>
							<tr>
								<th colspan="4">Description:</th>
							</tr>
							<tr>
								<td colspan="4"><form:textarea path="description" /></td>
							</tr>
						</table>
						<input type="Submit" value="Add" />
					</form:form>
				</details>
			</div>
		</c:if>
		<div class="display">
			<form:form action="saveCV" method="post" modelAttribute="cv">
				<form:hidden path="userId" />
				<table>
					<tr>
						<th colspan="4"><h2>Skills</h2></th>
					</tr>
					<tr>
						<form:hidden path="skills.id" />
						<td colspan="4"><form:textarea path="skills.skills"
								value="${cv.skills.skills}" readonly="${readonly}" /></td>
					</tr>
					<tr>
						<th colspan="4"><h2>Education</h2></th>
					</tr>
					<c:forEach items="${cv.schooling}" var="edu" varStatus="loop">

						<td><form:hidden path="schooling[${loop.index}].id" /></td>
						<tr>
							<th colspan="4">Program:</th>
						</tr>
						<tr>
							<td colspan="4"><form:input
									path="schooling[${loop.index}].program" value="${edu.program}"
									readonly="true" /></td>
						</tr>
						<tr>
							<th colspan="4">Institute:</th>
						</tr>
						<tr>
							<td colspan="4"><form:input
									path="schooling[${loop.index}].institute"
									value="${edu.institute}" readonly="true" /></td>
						</tr>
						<tr>
							<td>Start:</td>
							<td><form:input path="schooling[${loop.index}].startDate"
									value="${edu.startDate}" readonly="true" /></td>
							<td>Finish:</td>
							<td><form:input path="schooling[${loop.index}].endDate"
									value="${edu.endDate}" readonly="true" /></td>
						</tr>
						<tr>
							<th colspan="4">Description:</th>
						</tr>
						<tr>
							<td colspan="4"><form:textarea
									path="schooling[${loop.index}].description"
									value="${edu.description}" readonly="true" /></td>
						</tr>
						<c:if test="${session.userId == cv.userId}">
							<tr>
								<td><a href="deleteEdu?id=${edu.id}">Delete</a></td>
							</tr>
						</c:if>
					</c:forEach>
					<tr>
						<th colspan="4"><h2>Work Experience</h2></th>
					</tr>
					<c:forEach items="${cv.employment}" var="we" varStatus="loop">
						<form:hidden path="employment[${loop.index}].id" />
						<tr>
							<th colspan="4">Title:</th>
						</tr>
						<tr>
							<td colspan="4"><form:input
									path="employment[${loop.index}].title" value="${we.title}"
									readonly="true" /></td>
						</tr>
						<tr>
							<td>Start:</td>
							<td><form:input path="employment[${loop.index}].startDate"
									value="${we.startDate}" readonly="true" /></td>
							<td>Finish:</td>
							<td><form:input path="employment[${loop.index}].endDate"
									value="${we.endDate}" readonly="true" /></td>
						</tr>
						<tr>
							<th colspan="4">Description:</th>
						</tr>
						<tr>
							<td colspan="4"><form:textarea
									path="employment[${loop.index}].description"
									value="${we.description}" readonly="true" /></td>
						</tr>
						<c:if test="${session.userId == cv.userId}">
							<tr>
								<td><a href="deleteWorkExp?id=${we.id}">Delete</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
				<c:if test="${session.userId == cv.userId}">
					<input type="Submit" value="Save" />
				</c:if>
			</form:form>
		</div>
	</div>
</body>
</html>