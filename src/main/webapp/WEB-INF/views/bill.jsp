<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Bill</title>
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
	<center>
		<h1 style="color: red;">${msg}</h1>
		<div
			style="border: 1px solid black; width: 500px; height: auto; padding: 5px;">
			<h1 style="color: red;">VegiBazar.com</h1>
<h2>Bill Receipt</h2>
			<table width="500px;" height="400px;">

				<tr>
					<th>Your Payment Id:</th>
					<td>${list.id }</td>
				</tr>
				<tr>
					<th>Customer Id:</th>
					<td>${list.uId }</td>
				</tr>
				<tr>
					<th>Product Id:</th>
					<td>${list.pId }</td>
				</tr>
				<tr>
					<th>Order Id:</th>
					<td>${list.oId }</td>
				</tr>
				<tr>
					<th>Total Amount:</th>
					<td>${list.billAmt }</td>
				</tr>
				<tr>
					<th>payment Timing:</th>
					<td>${list.paydate }</td>
				</tr>
			</table>
		
		</div><br>
				<button style=" width: 140px; height:40px; background-color: gray;"
		onclick="window.print()">
		<h4>Print</h4>
	</button>
	</center>


	<br>
	<br>
	<br>
	<br>
	<%@ include file="footer.jsp"%>
</body>
</html>