<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/images/logovegi.png" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<%@ include file="header.jsp"%>
	<h1 style="color: red;"> ${msg}</h1>
	<h3>${feed.feedback_query}</h3>
	
	
	<div class="container" style="width: 500px; margin: 0 auto;">
		<div class="jumbotron" style="background-color: #333;">
			<h1 style="color: white;">Feedback</h1>
					<form:form action="addFeedback" method="post"
				modelAttribute="feedback">
			
			<h4 style="color: white;">Email:</h4>
				<form:input path="email" cssClass="form-control" />
				<form:errors path="email" cssClass="form-control" />
				<br />
				<br>
			<h4 style="color: white;">Query:</h4>
				<form:textarea path="feedback_query" cssClass="form-control" />
				<form:errors path="feedback_query" cssClass="form-control" />
				<br />
				<br>

				<input type="submit" value="Give feedback" Class="form-control"
					style="background-color: skyblue;">
			</form:form>
		</div>
	</div>
	<br>
	<br>
	<%@ include file="footer.jsp"%>

</body>
</html>