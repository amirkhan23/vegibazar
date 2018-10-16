<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make Order</title>
<link rel="shortcut icon" type="image/x-icon"
	href="<%=request.getContextPath()%>/resources/images/logovegi.png" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function getAmount() {
		var a = document.getElementById("qty").value;
		var b = document.getElementById("price").value;
		document.getElementById("amt").value = parseInt(a) * parseInt(b);

	}
</script>

</head>
<body>
	<%@ include file="header.jsp"%>


	<div class="container" style="width: 800px; margin: 0 auto;">

		<div  style="background-color: white;">

			<div style="float:left;" class="jumbotron">
				<b>Product Image:</b> 
				<img src="${pageContext.request.contextPath}/resources/images/${product.getpName()}.jpg" width="350px;">
				
			</div><br>
			<div class="jumbotron">
				<form method="post" action="addOrder">

					<input type="hidden" name="orderDate" value=${order.orderDate } />

					<b>Product ID:</b><input type="text" name="pId" value=${order.pId }
						readonly="readonly" class="form-control" /><br> 
						<b>Product Name:</b><input type="hidden" name="status" value=${order.status } /><br>

					<input type="text" value=${product.pName } class="form-control" readonly="readonly"><br> 
					<b>Delivery Address:</b> 
					<textarea name="deliveryAddress" placeholder=${order.deliveryAddress } class="form-control" /></textarea>
					<input type="hidden" name="orderCancel" value=${order.orderCancel } />
					<b>Product Price:</b> per kg <input type="text"
						value=${product.pPrice } class="form-control" readonly="readonly"
						id="price"><br> 
						<b>Product Quantity:</b> you can increase Quantity 
						<input type="text" id="qty" name="qty" value=${order.qty } class="form-control" onchange="getAmount()" /><br>
					<input type="hidden" name="uId" value=${order.uId } /> 
					<b>Order Amount:</b> 
					<input type="text" id="amt" name="totalAmt" value=${order.totalAmt } readonly="readonly" class="form-control" /><br>
					<button type="submit" class="btn"
						style="margin: 0px; width: 350px; background-color: #00A2E8; color: white; text-align: center; font-size: 015x; border-radius: 0px;">
						<b>Make Order</b>
					</button>


				</form>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>


</body>
</html>