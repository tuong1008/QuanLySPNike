<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="Customer Management"/>
</jsp:include>
<c:url var="firstUrl" value="/admin/customerManagement/1.htm"/>
<c:url var="lastUrl" value="/admin/customerManagement/${totalPages}.htm"/>
<c:url var="prevUrl" value="/admin/customerManagement/${currentPageNumber - 1}.htm"/>
<c:url var="nextUrl" value="/admin/customerManagement/${currentPageNumber + 1}.htm"/>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <c:if test="${not empty search}">
                <a class="btn btn-primary" href="<c:url value="/admin/customerManagement/1.htm"/>">See All Customers</a>
            </c:if>
        </div>
        <div class="container">
            <div class=row>

                <form class="form-inline" action="<c:url value="/admin/customerManagement/search/1.htm"/>"
                      method="post">
                    <!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                    <div class="d-flex justify-content-center align-items-center">
                        <input type="text" name="searchTerm" class="form-control" style="width:300px"
                               id="inputEmail" placeholder="Search Username or Email">
                        <input type="hidden" value="category" name="search">
                        <button type="submit" class="btn btn-primary btn-dark">Search Product</button>
                    </div>
                </form>

            </div>
        </div>
        <br>
        <table class="table table-striped table-hover table-borderless" data-sortable>
            <thead class="table-dark">
            <tr class="bg-success">
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>
                <th data-sortable="false">Enabled</th>
                <th class="text-center" data-sortable="false">Shipping Address & Billing Address</th>
            </tr>
            </thead>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerEmailAddress}</td>
                    <td>${customer.customerPhoneNumber}</td>
                    <td>${customer.username}</td>
                    <td>${customer.enabled}</td>
                    <td class="text-center">
                        <a href=" <spring:url value="/admin/customerManagement/address/${customer.customerId}.htm"/>">
                            <i class="fa fa-info-circle" aria-hidden="true"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="d-flex justify-content-center">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${currentPageNumber == 1}">
                        <li class="page-item disabled">
                            <a class="page-link" href=""><i class="fa fa-fast-backward" aria-hidden="true"></i></a></li>
                        <li class="page-item disabled">
                            <a class="page-link" href=""><i class="fa fa-step-backward" aria-hidden="true"></i></a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="${firstUrl}"><i class="fa fa-fast-backward" aria-hidden="true"></i></a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="${prevUrl}"><i class="fa fa-step-backward" aria-hidden="true"></i></a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                    <c:url var="pageUrl" value="/admin/customerManagement/${i}.htm"/>
                    <c:choose>
                        <c:when test="${i == currentPageNumber}">
                            <li class="page-item active">
                                <a class="page-link" href="${pageUrl}"><c:out value="${i}"/></a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link" href="${pageUrl}"><c:out value="${i}"/></a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${currentPageNumber == totalPages}">
                        <li class="page-item disabled">
                            <a class="page-link" href=""><i class="fa fa-step-forward" aria-hidden="true"></i></a></li>
                        <li class="page-item disabled">
                            <a class="page-link" href=""><i class="fa fa-fast-forward" aria-hidden="true"></i></a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="${nextUrl}"><i class="fa fa-step-forward" aria-hidden="true"></i></a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="${lastUrl}"><i class="fa fa-fast-forward" aria-hidden="true"></i></a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>