<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">VegiBazar.com</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="/vegibazar/index/home">Home</a></li>
      <li><a href="/vegibazar/index/cart"><span class="glyphicon glyphicon-shopping-cart">Cart</span></a></li>
      <li><a href="/vegibazar/index/profile">Profile</a></li>
      <li><a href="/vegibazar/index/myOrder">My Order</a></li>
      <li><a href="/vegibazar/index/feedback">Give Feedback</a></li>
      <li><a href="/vegibazar/index/logout">Logout</a></li>
    </ul>
    <form class="navbar-form navbar-left" action="searchProduct" method="get">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="pName">
         <div class="input-group-btn">
        <button class="btn btn-info" type="submit">
            <span class="glyphicon glyphicon-search"></span>Search
          </button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>