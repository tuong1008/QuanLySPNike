<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>Green Online Shop</title>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- normalize css -->
    <link href="<c:url value="/resources/css/normalize.css"/>" rel="stylesheet">
    <!-- Angular.JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <!-- main css -->
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">
    <base href="${pageContext.request.contextPath}/">
</head>

<body>
<div class="navbar-wrapper" style="margin-top:0;">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#"><img src="<c:url value="/resources/images/logo.png"/>" alt="logo" class="logo"></a>
                        </li>
                        <li class=""><a href="#">Nike Online Shop</a></li>
                        <li><a href="<c:url value="/trang-chu.htm"/>">Home</a></li>
                        <li><a href="<c:url value="/product/productList/Laptop/1.htm"/>">Products</a></li>
                        <li><a href="<c:url value="/about.htm"/>">About</a></li>
                        <li><a href="<c:url value="/contact.htm"/>">Contact</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <!-- <li><a href="?lang=en">English</a></li>
                            <li><a href="?lang=bn">Bangla</a></li> -->
                        <c:if test="${sessionScope.username!=null}">
                            <li><a>Welcome:${sessionScope.username} </a></li>
                            <c:if test="${sessionScope.username!='admin'}">
                                <li role="presentation" class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                                       aria-haspopup="true" aria-expanded="false">
                                        <span class="glyphicon glyphicon-user"></span> <span class="caret">   </span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="<c:url value="/customer/update"/>">Update Account</a></li>
                                    </ul>
                                </li>
                            </c:if>
                            <li><a href="<c:url value="/logout.htm"/>">Logout</a></li>
                            <c:if test="${sessionScope.username!='admin'}">
                                <li><a href="<c:url value="/customer/cart"/>">Cart</a></li>
                            </c:if>
                            <c:if test="${sessionScope.username =='admin'}">
                                <li><a href="<c:url value="/admin"/>">Admin</a></li>
                            </c:if>
                        </c:if>
                        <c:if test="${sessionScope.username == null}">
                            <li><a href="<c:url  value="/login.htm"/>">Login</a></li>
                            <li><a href="<c:url  value="/register.htm"/>">Register</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
