<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/images/logovegi.png" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="adminHeader.jsp" %>

	<br />
	<br /> ${edit}
	<h1
		style="text-align: center; font-size: 30px; font-weight: bold; font-family: 'segoe ui';">Product
		List</h1>
	<div class="table-responsive">

		<table class="table table-hover table-bordered">

			<thead>
				<tr>
					<td style="text-align: center;"><b>Product Id</b></td>
					<td style="text-align: center;"><b>Product Name</b></td>
					<td style="text-align: center;"><b>Product Price</b></td>
					<td style="text-align: center;"><b>Product Stock</b></td>
					<td style="text-align: center;"><b>Product Image</b></td>
					<td style="text-align: center;"><b>Edit Product</b></td>


				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="product">
					<tr>

						<form action="updateProduct" method="post">
							<td><input name="pId" Class="form-control"
								value="${product.pId}"  readonly="readonly" /></td>
							<td><input name="pName" Class="form-control"
								value="${product.pName }" readonly="readonly"/></td>

							<td><input name="pPrice" Class="form-control"
								value="${product.pPrice }" /></td>

							<td><input name="stock" Class="form-control"
								value="${product.stock }" /></td>

							<td><img
								src="${pageContext.request.contextPath}/resources/images/${product.getpName()}.jpg" /></td>

							<td>
								<button type="submit" class="btn"
									style="margin: 0px; width: 100px; background-color: #00A2E8; color: white; text-align: center; font-size: 015x; border-radius: 0px;">
									Edit &nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-edit"></span>
								</button>
							</td>

         					</form>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
<%@ include file="footer.jsp" %>
</body>
</html>