<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<div class="container">
		<div class="jumbotron" style="background-color: #333;">
			<h2 style="color: red;">${msg}${duplicate}</h2>


			<form:form action="saveProduct" commandName="product"
				modelAttribute="product" method="post" role="form"
				enctype="multipart/form-data">

				<table class="table table-bordered "
					style="background-color: white;">
					<tr>
						<td>Product Name:</td>
						<td><form:input path="pName" cssClass="form-control" /> <form:errors
								path="pName" cssClass="form-control" /></td>
					</tr>
					<tr>
						<td>Product Price:</td>
						<td><form:input path="pPrice" cssClass="form-control" /> <form:errors
								path="pPrice" cssClass="form-control" /></td>
					</tr>
					<tr>
						<td>Product Stock:</td>
						<td><form:input path="stock" value="Aviable"
								cssClass="form-control" /> <form:errors path="stock"
								cssClass="form-control" /></td>
					</tr>
					<tr>
						<td>Product Image:</td>
						<td><form:input type="file" path="img"
								cssClass="form-control" /> <form:errors path="img"
								cssClass="form-control" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn"
								style="margin: 0px; width: 100px; background-color: #00A2E8; color: white; text-align: center; font-size: 015x; border-radius: 0px;">
								Add Product</button>
						</td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form:form>
		</div>
	</div>
	<br>
	<br>
	<br>


	<h2 style="color: red;">${delete}${edit}</h2>
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
					<td style="text-align: center;"><b>Delete Product</b></td>
				</tr>
			</thead>
			   
			<tbody>
				<c:forEach items="${list}" var="product">

					<tr>
                        <td style="text-align: center;"><c:out value="${product.pId}" /></td>
						<td style="text-align: center;"><c:out value="${product.pName}" /></td>
						<td style="text-align: center;"><c:out value="${product.pPrice}" /></td>
                        <td style="text-align: center;"><c:out value="${product.stock}" /></td>
						<td style="text-align: center;"><img src="${pageContext.request.contextPath}/resources/images/${product.getpName()}.jpg"  width="60px"/>
						</td>
					    <td style="text-align: center;">
							<form action="deleteProduct" method="post">
								<input type="hidden" value=${product.pId } name="pId" /> 
								<input type="hidden" value=${product.pName } name="pName" /> 
								<input type="hidden" value=${product.pPrice } name="pPrice" />
								<input type="hidden" value=${product.stock } name="stock" />
								<button type="submit" class="btn"
									style="margin: 0px; width: 100px; background-color: #c0392b; color: white; text-align: center; font-size: 015x; border-radius: 0px;">

									Delete &nbsp;&nbsp;&nbsp;<span
										class="glyphicon glyphicon-remove"></span>

								</button>
							</form>

						</td>		
								
					</tr>

				</c:forEach>
			</tbody>
		</table>

	</div>

<%@ include file="footer.jsp" %>

</body>
</html>