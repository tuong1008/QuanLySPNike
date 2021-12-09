<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="Customer Messages"/>
</jsp:include>
<c:url var="firstUrl" value="/admin/message/1"/>
<c:url var="lastUrl" value="/admin/message/${totalPages}"/>
<c:url var="prevUrl" value="/admin/message/${currentPageNumber - 1}"/>
<c:url var="nextUrl" value="/admin/message/${currentPageNumber + 1}"/>
<div class="container-wrapper">
    <div class="container">
        <div class=row>
            <div class="jumbotron col-md-12">
                <p>View your customer messages</p>
            </div>
        </div>
        <section class="productsection">
            <div class="container">
                <c:if test="${not empty msg}">
                    <div class="no-product">
                            ${msg}
                    </div>
                </c:if>
                <c:forEach var="contact" items="${messages}">
                    <div class="row message">
                        <p class="info"> ${contact.contactInfo}</p>
                        <br/>
                        <div class="row" style=" margin-bottom: 20px; margin-left: -3px;color: crimson;">
                            <div class="col-md-6">
                                UserName: ${contact.customer.customerName}
                            </div>
                            <div class="col-md-6">
                                Date: ${contact.date}
                            </div>
                        </div>
                        <form action="<c:url value="/admin/customerMessages/deleteMessage" />" method="post" class="form-horizontal">
                            <input type="hidden" name="customerMessageId" value="${contact.contactId}">
                            <input type="hidden" name="currentPageNumber" value="${currentPageNumber}">
                            <input type="submit" value="Delete Message" class="btn btn-danger operation">
                        </form>
                    </div>
                </c:forEach>
            </div>
        </section>
    </div>
</div>
<c:if test="${empty msg}">
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
                <c:url var="pageUrl" value="/admin/customerMessages/${i}"/>
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
                    <li class="disabled"><a href="#"></a></li>
                    <li class="disabled"><a href="#"></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${nextUrl}"></a></li>
                    <li><a href="${lastUrl}"></a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</c:if>
<%@include file="/WEB-INF/views/template/footer.jsp" %>