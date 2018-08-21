<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile | VegiBazar.com</title>
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



	<h1>${msg}</h1>
	<div class="container" style="width: 700px; margin: 0 auto;">

		<div class="jumbotron" style="background-color: #333;">


			<table class="table table-hover" style="background-color: white;">

			<tbody>
					<form action="updateUser" method="post" >

						<input type="hidden" name="userId" value=${user.userId }
							readonly="readonly" Class="form-control" />
						<tr>
							<td>Name:</td>
							<td><input name="name" value="${user.name}" Class="form-control"/></td>
						</tr>

						<tr>
							<td>Email:</td>
							<td><input name="email" value="${user.email}"
								readonly="readonly" Class="form-control" /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input name="password" value="${user.password}" Class="form-control" /></td>
						</tr>
						<tr>
							<td>Gender:</td>
							<td>
							<input type="text" name="gender" value="${user.gender}"  Class="form-control"/>
							</td>
						</tr>
						<tr>
							<td>Contact:</td>
							<td><input name="contact" value="${user.contact}" Class="form-control" /></td>
						</tr>
						<tr>
							<td>Date of Birth:</td>
							<td><input name="dob" type="date" value="${user.dob}" Class="form-control" /></td>
						</tr>
						<tr>
							<td>Address:</td>
							<td><input type="textarea" rows="3" cols="25" name="address"
								value="${user.getAddress()}" Class="form-control" /></td>
						</tr>
						<tr>
							<td colspan="2"><center>
									<button type="submit" class="btn"
										style="margin: 0px; width: 100px; background-color: #00A2E8; color: white; text-align: center; font-size: 015x; border-radius: 0px;">
										Update!</button>
								</center></td>
						</tr>
					</form>

				</tbody>
			</table>
		</div>
	</div>
	<%@ include file="footer.jsp"%>

</body>
</html>