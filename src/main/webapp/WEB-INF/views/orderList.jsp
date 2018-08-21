<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order List</title>
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
<%@ include file="adminHeader.jsp" %>

<h1
		style="text-align: center; font-size: 30px; font-weight: bold; font-family: 'segoe ui';">Order
		List</h1>
	<div class="table-responsive">

		<table class="table table-hover table-bordered">

			<thead>
				<tr>
					<td style="text-align: center;"><b>Order Id</b></td>
					<td style="text-align: center;"><b>User Id</b></td>
					<td style="text-align: center;"><b>Product Id</b></td>
					<td style="text-align: center;"><b>Order Cancel</b></td>
					<td style="text-align: center;"><b>Order Amount</b></td>
					
				</tr>
			</thead>
			   
			<tbody>
				<c:forEach items="${list}" var="order">

					<tr>
                        <td style="text-align: center;"><c:out value="${order.oId}" /></td>
						<td style="text-align: center;"><c:out value="${order.uId}" /></td>
						<td style="text-align: center;"><c:out value="${order.pId}" /></td>
						<td style="text-align: center;"><c:out value="${order.orderCancel}" /></td>
                        <td style="text-align: center;"><c:out value="${order.totalAmt}" /></td>
						
					 		
								
					</tr>

				</c:forEach>
				
			</tbody>
		</table>

	</div>

<%@ include file="footer.jsp" %>
</body>
</html>