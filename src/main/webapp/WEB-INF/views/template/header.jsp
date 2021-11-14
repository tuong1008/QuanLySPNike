<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <base href="${pageContext.servletContext.contextPath}/">
    <link rel="icon" href="resources/images/favicon.ico">
    <c:choose>
        <c:when test="${!empty param.title}">
            <title>${param.title}</title>
        </c:when>
        <c:otherwise>
            <title>Nike Online Shop</title>
        </c:otherwise>
    </c:choose>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="resources/css/main.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
    <link href="resources/css/sortable-theme-minimal.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
</head>
<body>
    <div style="min-height: 95vh">
    <nav class="px-3 navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="">
            <img src="<c:url value="/resources/images/nike-logo.svg"/>" alt="logo" class="logo">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item active">
                    <c:if test="${sessionScope.username =='admin'}">
                        <a class="nav-link" href="<c:url value="/admin/home.htm"/>">Home</a>
                    </c:if>
                    <c:if test="${sessionScope.username !='admin'}">
                        <a class="nav-link" href="<c:url value="/trang-chu.htm" />">Home</a>
                    </c:if>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/product/productList.htm" />">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto me-lg-4">
                <c:if test="${sessionScope.username!=null}">
                    <li class="nav-item">
                        <a class="nav-link" id="navbarDropdownMenuLink" href="#" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">${sessionScope.username}
                        </a>
                    <c:if test="${sessionScope.username!='admin'}">
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><a class="dropdown-item" href="<c:url value="/customer/update.htm"/>">Update Account</a></li>
                        </ul>
                    </c:if>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="<c:url value="/logout.htm" />">Logout</a></li>
                    <c:if test="${sessionScope.username!='admin'}">
                        <li class="nav-item"><a class="nav-link" href="<c:url value="/customer/cart.htm"/>">Cart</a>
                        </li>
                    </c:if>
                </c:if>
                <c:if test="${sessionScope.username == null}">
                    <li class="nav-item"><a class="nav-link" href="<c:url value="/login.htm"/>">Login</a></li>
                    <li class="nav-item"><a class="nav-link" href="<c:url value="/register.htm"/>">Register</a></li>
                </c:if>
            </ul>
        </div>
    </nav>
