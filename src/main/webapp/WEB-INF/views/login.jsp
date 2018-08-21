<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<title>Login Page</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/images/logovegi.png" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body onload='document.loginForm.userEmail.focus();'>
	<div class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
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
	<div class="jumbotron" style="background-color: #333;">
			<form name='loginForm' action="perform_login" method='POST'>
			<table class="table" style="background-color: white;">
			<tr>
					<th colspan="2" style="text-align: center;">Login with Email and Password</th>
			</tr>
				<tr><td colspan="2">
				<center>
				<img src="<%=request.getContextPath()%>/resources/images/l.jpg" alt="LoginLogo"   class="profile-image" />
				</center>
				</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type='text' name='userEmail' class="form-control" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='userPassword' class="form-control"/></td>
				</tr>
				<tr>
					<td colspan='2'><button type="submit" class="btn"
								style="margin: 0px; width: 350px; background-color: #00A2E8; color: white; text-align: center; font-size: 015x; border-radius: 0px;">
								Login</button>
								<h4 style="color: red; text-align: center;"> ${msg }
								</h4></td>
								
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>