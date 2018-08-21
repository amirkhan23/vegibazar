<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart | VegiBazar.com</title>
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
	<%@ include file="header.jsp"%>
	<div class="table-responsive">

		<table class="table table-hover table-bordered">
			<tbody>
				<c:forEach items="${list}" var="product">

					<tr>
						<div class="col-md-4">
							<div style="text-align: center" class="panel panel-primary">

								<div class="panel-body">
									<p>
										<img style="margin: 0 auto;" class="img-responsive"
											src="${pageContext.request.contextPath}/resources/images/${product.getpName()}.jpg"
											alt="Web y Metrícas" /><br>
									<h3>
										<c:out value="${product.pName}" />
									</h3>
									<h3>
										Rs/-
										<c:out value="${product.pPrice}" />
										per kg
									</h3>
									<br> <a
										href="/vegibazar/index/removeCart?pId=${product.getpId()}">
										<button type="submit" class="btn"
											style="margin: 0px; width: 100px; background-color: #c0392b; color: white; text-align: center; font-size: 015x; border-radius: 0px;">
											Remove cart</button>
									</a> <a href="/vegibazar/index/order?pId=${product.getpId()}">
										<button type="submit" class="btn"
											style="margin: 0px; width: 100px; background-color: #c0392b; color: white; text-align: center; font-size: 015x; border-radius: 0px;">
											Buy NOW!</button>
									</a>

								</div>
								<!-- end panel-body -->
							</div>
							<!-- end panel-primary -->
						</div>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>