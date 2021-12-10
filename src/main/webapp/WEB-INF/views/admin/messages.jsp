<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<c:url var="firstUrl" value="/admin/messages/1"/>
<c:url var="lastUrl" value="/admin/messages/${totalPages}"/>
<c:url var="prevUrl" value="/admin/messages/${currentPageNumber - 1}"/>
<c:url var="nextUrl" value="/admin/messages/${currentPageNumber + 1}"/>
<div class="container-wrapper">
    <div class="container">
        <div>
            <div class="fs-2 text-dark">
                View your customer messages
            </div>
        </div>
        <div class="container">
            <c:if test="${not empty message}">
                <div class="text-success">
                        ${message}
                </div>
            </c:if>
            <c:if test="${not empty error}">
                <div class="text-danger">
                        ${error}
                </div>
            </c:if>
            <c:forEach var="m" items="${messages}">
                <div class="alert alert-primary d-flex flex-row justify-content-between">
                    <div class="d-flex flex-row">
                        <div class="d-flex flex-row">
                            <div class="d-flex flex-column">
                                <div class="text-primary">Name: ${m.name}</div>
                                <div class="text-primary">Email: ${m.email}</div>
                                <div class="text-primary">
                                    <fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${m.sentTime}"/>
                                </div>
                            </div>
                            <div>${m.message}</div>
                        </div>
                    </div>
                    <div>
                        <button type="button" class="btn btn-primary fs-5" data-bs-toggle="modal" data-bs-target="#modal${m.messageId}">
                            Reply
                        </button>
                        <div class="modal fade" id="modal${m.messageId}" tabindex="-1" aria-labelledby="exampleModalLabel${m.messageId}" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel${m.messageId}">Reply Message</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <form:form action="admin/messages/mail.htm" method="post">
                                            <form:input class="form-control" name="to" value="${m.email}" readonly="readonly" path="to"/>
                                            <form:textarea class="form-control" name="body" placeholder="Body" rows="3" cols="30" path="body"/>
                                            <div class="d-flex">
                                                <button type="submit" class="btn btn-primary mt-2">Send</button>
                                                <h2 class="text-info">${msg}</h2>
                                            </div>
                                        </form:form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a href="<spring:url value="/admin/messages/delete/${m.messageId}.htm"/>" class="btn btn-danger fs-5">Delete</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
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
            <c:url var="pageUrl" value="/admin/messages/${i}.htm"/>
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
<%--</c:if>--%>
<%@include file="/WEB-INF/views/template/footer.jsp" %>