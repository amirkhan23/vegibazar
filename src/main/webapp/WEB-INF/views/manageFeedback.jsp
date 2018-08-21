<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Feedback</title>
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

<h2 style="color: red;">${delete}${edit}</h2>
	<h1
		style="text-align: center; font-size: 30px; font-weight: bold; font-family: 'segoe ui';">Feedback
		List</h1>
	<div class="table-responsive">

		<table class="table table-hover table-bordered">

			<thead>
				<tr>
					<td style="text-align: center;"><b>Feedback Id</b></td>
					<td style="text-align: center;"><b>Feedback Name</b></td>
					<td style="text-align: center;"><b>Feedback Price</b></td>
					<td style="text-align: center;"><b>Edit Feedback</b></td>
					<td style="text-align: center;"><b>Delete Feedback</b></td>
				</tr>
			</thead>
			   
			<tbody>
				<c:forEach items="${list}" var="feedback">
					<tr>
					<form action="updateFeedback" method="post">
                        <td style="text-align: center;"><input type="text" value="${feedback.fId }" name="fId" readonly="readonly" /> </td>
						<td style="text-align: center;"><input type="text" value="${feedback.email }" name="email" readonly="readonly"/> </td>
						<td style="text-align: center;"><input type="text" value="${feedback.feedback_query }" name="feedback_query" /></td>
                        <td style="text-align: center;"><button type="submit" class="btn"
									style="margin: 0px; width: 100px; background-color: #c0392b; color: white; text-align: center; font-size: 015x; border-radius: 0px;">

									Edit &nbsp;&nbsp;&nbsp;<span
										class="glyphicon glyphicon-edit"></span>

								</button></td>
						</form>
					    <td style="text-align: center;">
							<form action="deleteFeedback" method="post">
								<input type="hidden" value="${feedback.fId }" name="fId" /> 
								<input type="hidden" value="${feedback.email }" name="email" /> 
								<input type="hidden" value="${feedback.feedback_query }" name="feedback_query" />
								
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