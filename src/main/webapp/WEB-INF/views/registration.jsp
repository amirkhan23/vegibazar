<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Registration</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/images/logovegi.png" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
	<style type="text/css">
	
	.error{
	color: red;
	}
	</style>
	
</head>
<body>

	<div class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header"
				style="text-align: center; font-size: 60px; font-weight: bold; font-family: 'segoe ui';">
				<a class="navbar-brand" href="/vegibazar/">VegiBazar.com</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/vegibazar/registration"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="/vegibazar/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</div>

	<div class="container" style="width: 500px; margin: 0 auto;">
		<div class="jumbotron" style="background-color: #333; "  >
			${msg}
			<center>
				<h1 style="color: white; ">Registration</h1>
			</center>
			<form:form action="saveUser" method="post" modelAttribute="user">
				<table class="table" style="background: white; s ">
					<tr>
						<th>Name</th>
						<td>
						<form:input path="name" cssClass="form-control" /> 
						<form:errors path="name" class="error" /></td>
					</tr>

					<tr>
						<th>Email</th>
						<td><form:input path="email" cssClass="form-control" /> 
						<form:errors path="email" class="error" /></td>
					</tr>

					<tr>
						<th>Password</th>
						<td><form:password path="password" cssClass="form-control" />
							<form:errors path="password" class="error" /></td>
					</tr>


					<tr>
						<th>Gender</th>
						<td><form:radiobutton value="male" path="gender" />Male 
						    <form:radiobutton value="female" path="gender" />Female 
								<form:errors path="gender" class="error" /></td>
					</tr>

					<tr>
						<th>Contact</th>
						<td><form:input path="contact" cssClass="form-control" /> <form:errors
								path="contact" class="error" /></td>
					</tr>

					<tr>
						<th>Date of Birth</th>
						<td><form:input path="dob" type="date"
								cssClass="form-control" /> <form:errors path="dob" class="error"
								 /></td>
					</tr>

					<tr>
						<th>Address</th>
						<td><form:textarea rows="3" cols="20" path="address" cssClass="form-control" /> 
								<form:errors path="address" class="error" /></td>
					</tr>

					<tr>
						<th colspan="2"><center>
								<button type="submit" class="btn"
									style="margin: 0px; width: 350px; background-color: #00A2E8; color: white; text-align: center; font-size: 015x; border-radius: 0px;">
									Register</button>
							</center></th>
					</tr>
				</table>
			</form:form>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>