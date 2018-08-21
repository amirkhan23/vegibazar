<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home | VegiBazar.com</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/images/logovegi.png" />
<script
	src="<%=request.getContextPath()%>/resources/jquery/jquery-3.3.1.min.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" >

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">

<script
	src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


</head>
<body>

	<%@ include file="header.jsp"%>

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img
					src="${pageContext.request.contextPath}/resources/images/veg33.jpg"
					alt="Los Angeles" style="width: 100%; height: 600px;">
				<div class="carousel-caption">
					<h3>Bring!</h3>
				</div>
			</div>

			<div class="item">
				<img
					src="${pageContext.request.contextPath}/resources/images/veg56.jpg"
					alt="Chicago" style="width: 100%; height: 600px;">
				<div class="carousel-caption">
					<h3>Bring!</h3>
				</div>
			</div>

			<div class="item">
				<img
					src="${pageContext.request.contextPath}/resources/images/veg22.jpg"
					alt="New York" style="width: 100%; height: 600px;">
				<div class="carousel-caption">
					<h3>Bring!</h3>
				</div>
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<br />
	
<h1> ${msg }</h1>

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
										href="/vegibazar/index/addCart?pId=${product.getpId()}">
										<button type="submit" class="btn"
											style="margin: 0px; width: 100px; background-color: #c0392b; color: white; text-align: center; font-size: 015x; border-radius: 0px;">
											Add To Cart</button>
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