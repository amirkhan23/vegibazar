<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Order</title>
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
<%@ include file="header.jsp" %>
<h1 style="color: red;"> ${msg}</h1>
<table width="500px;" height="400px;" class="table">
<tr><th>Your Order Id:</th>
<th>Customer Id:</th>
<th>Product Id:</th>
<th>Product Quantity:</th>
<th>Total Amount:</th>
<th>Order Date:</th>
<th>Delivery Address:</th>
<th>Cancel Order:</th>
 <c:forEach items="${list}" var="list">
<tr>
<td style="text-align: center;">${list.oId }</td>
<td style="text-align: center;">${list.uId }</td>
<td style="text-align: center;">${list.pId }</td>
<td style="text-align: center;">${list.qty }</td>
<td style="text-align: center;">${list.totalAmt }</td>
<td style="text-align: center;">${list.orderDate }&nbsp;</td>
<td style="text-align: center;">${list.deliveryAddress }</td>
<td style="text-align: center;">
<a href="/vegibazar/index/cancelOrder?oId=${list.oId }"><button  class="btn" style="margin: 0px; width: 100px; background-color: #c0392b; color: white; text-align: center; font-size: 015x; border-radius: 0px;">
Cancel Order &nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-remove"></span></button></a></td>

</tr>
</c:forEach>
</table>


<%@ include file="footer.jsp" %>
</body>
</html>