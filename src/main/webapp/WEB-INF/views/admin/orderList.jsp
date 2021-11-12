<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<c:url var="firstUrl" value="/admin/customerOrder/1.htm"/>
<c:url var="lastUrl" value="/admin/customerOrder/${totalPages}.htm"/>
<c:url var="prevUrl" value="/admin/customerOrder/${currentPageNumber - 1}.htm"/>
<c:url var="nextUrl" value="/admin/customerOrder/${currentPageNumber + 1}.htm"/>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Order Page</h1>
            <p class="lead">Here is all Customer order list!</p>
        </div>
        <c:set var="sl" value="1"/>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>SL No.</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>
                <th>Enabled</th>
                <th>Orderdetails</th>
                <th>Operation</th>
            </tr>
            </thead>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${sl}</td>
                    <td>${order.customer.customerName}</td>
                    <td>${order.customer.customerEmailAddress}</td>
                    <td>${order.customer.customerPhoneNumber}</td>
                    <td>${order.customer.username}</td>
                    <td>${order.customer.enabled}</td>
                    <td><a class="btn btn-info"
                           href=" <spring:url value="/admin/customerOrder/productList/${order.customerOrderId}.htm"/>">See
                        Receipt</a></td>
                    <td><a class="btn btn-danger"
                           href=" <spring:url value="/admin/customerOrder/deleteOrder/${order.customerOrderId}.htm"/>">Clear
                        Order</a></td>
                    <c:set var="sl" value="${sl+1}"/>
                </tr>
            </c:forEach>
        </table>
        <div class="Page navigation text-center">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${currentPageNumber == 1}">
                        <li class="disabled"><a href="#">&lt;&lt;</a></li>
                        <li class="disabled"><a href="#">&lt;</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${firstUrl}">&lt;&lt;</a></li>
                        <li><a href="${prevUrl}">&lt;</a></li>
                    </c:otherwise>
                </c:choose>
                <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                    <c:url var="pageUrl" value="/admin/customerOrder/${i}.htm"/>
                    <c:choose>
                        <c:when test="${i == currentPageNumber}">
                            <li class="active"><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${currentPageNumber == totalPages}">
                        <li class="disabled"><a href="#">&gt;</a></li>
                        <li class="disabled"><a href="#">&gt;&gt;</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${nextUrl}">&gt;</a></li>
                        <li><a href="${lastUrl}">&gt;&gt;</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>