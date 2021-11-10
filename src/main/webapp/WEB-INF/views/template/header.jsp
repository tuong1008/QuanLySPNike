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
    <link rel="icon" href="resource/images/favicon.ico">
    <c:choose>
        <c:when test="${!empty param.title}">
            <title>${param.title}</title>
        </c:when>
        <c:otherwise>
            <title>Nike Online Shop</title>
        </c:otherwise>
    </c:choose>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- FONT AWESOME -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- normalize css -->
    <link href="<c:url value="/resources/css/normalize.css"/>" rel="stylesheet">
    <!-- Angular.JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <!-- main css -->
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">
    <script src="resources/js/jquery-1.12.4.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
<div style="min-height: 90vh">
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
                            <a href="">
                                <img src="<c:url value="/resources/images/nike-logo.svg"/>" alt="logo" class="logo">
                            </a>
                        </li>
                        <li class=""><a style="cursor: text;color: #fff;background-color: transparent;" href="">Nike Online Shop</a></li>
                        <c:if test="${sessionScope.username =='admin'}">
                            <li><a href="<c:url value="/admin/home.htm"/>">Home</a></li>
                        </c:if>
                        <c:if test="${sessionScope.username !='admin'}">
                            <li><a href="<c:url value="/trang-chu.htm" />">Home</a></li>
                        </c:if>
                        <li><a href="<c:url value="/product/productList.htm" />">Products</a></li>
                        <li><a href="<c:url value="/about.htm"/>">About</a></li>
                        <li><a href="<c:url value="/contact.htm"/>">Contact</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <!-- <li><a href="?lang=en">English</a></li>
                            <li><a href="?lang=bn">Bangla</a></li> -->
                        <c:if test="${sessionScope.username!=null}">
                            <li><a style="color: #fff;background-color: transparent;">Welcome:${sessionScope.username} </a></li>
                            <c:if test="${sessionScope.username!='admin'}">
                                <li role="presentation" class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                                       aria-haspopup="true" aria-expanded="false">
                                        <span class="glyphicon glyphicon-user"></span> <span class="caret">   </span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="<c:url value="/customer/update.htm"/>">Update Account</a></li>
                                    </ul>
                                </li>
                            </c:if>
                            <li><a href="<c:url value="/logout.htm" />">Logout</a></li>
                            <c:if test="${sessionScope.username!='admin'}">
                                <li><a href="<c:url value="/customer/cart.htm"/>">Cart</a></li>
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
