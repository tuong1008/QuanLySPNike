<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<c:url var="firstUrl" value="/admin/customerManagement/1.htm"/>
<c:url var="lastUrl" value="/admin/customerManagement/${totalPages}.htm"/>
<c:url var="prevUrl" value="/admin/customerManagement/${currentPageNumber - 1}.htm"/>
<c:url var="nextUrl" value="/admin/customerManagement/${currentPageNumber + 1}.htm"/>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Management</h1>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>
                <th>Enabled</th>
                <th>Shipping Address & Billing Address</th>
            </tr>
            </thead>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerEmailAddress}</td>
                    <td>${customer.customerPhoneNumber}</td>
                    <td>${customer.username}</td>
                    <td>${customer.enabled}</td>
                    <td>
                        <a href=" <spring:url value="/admin/customerManagement/address/${customer.customerId}.htm"/>">
                            <span class="glyphicon glyphicon-info-sign"></span>
                        </a>
                    </td>
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
                    <c:url var="pageUrl" value="/admin/customerManagement/${i}.htm"/>
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