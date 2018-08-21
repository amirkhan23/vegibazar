<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/images/logovegi.png" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	<%@ include file="adminHeader.jsp" %>
	<br />
	<br />
	<h1
		style="text-align: center; font-size: 30px; font-weight: bold; font-family: 'segoe ui';">Users
		List</h1>
	<div class="table-responsive">
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<td><b>Name</b></td>
					<td><b>Email</b></td>
					<td><b>Gender</b></td>
					<td><b>Date Of Birth</b></td>
					<td><b>Contact No.</b></td>
					<td><b>Address</b></td>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="user">
					<tr>

						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.gender}" /></td>
						<td><c:out value="${user.dob}" /></td>
						<td><c:out value="${user.contact}" /></td>
						<td><c:out value="${user.address}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

<%@ include file="footer.jsp" %>
</body>
</html>