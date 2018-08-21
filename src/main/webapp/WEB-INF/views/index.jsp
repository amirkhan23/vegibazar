<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Welcome | VegiBazar.com</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/images/logovegi.png" />
<script
	src="<%=request.getContextPath()%>/resources/jquery/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">

<script
	src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
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
	<div style="width: 100%; height: 670px;">
		<div
			style="width: 70%; height: 670px; background-repeat: no-repeat; float: left; 
		background-image: url('${pageContext.request.contextPath}/resources/images/veg33.jpg')">
		</div>
		<div style="float: right; width: 30%; height: 670px;">
			<br> <br> <br> <br> <br> <br> <br>
			<br>
			<h1
				style="text-align: center; font-size: 60px; font-weight: bold; font-family: 'segoe ui';">
				Welcome<br> VegiBazar.com
			</h1>
		</div>

	</div>
	<br>

	<%@ include file="footer.jsp"%>



</body>
</html>
