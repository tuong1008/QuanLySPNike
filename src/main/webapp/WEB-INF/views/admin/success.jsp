<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="Customer Contacts"/>
</jsp:include>

<div class="fs-3 fw-bold">
    ${message}
</div>
<a class="fs-6" href="admin/messages.htm">
    Back to message
</a>
    <%@include file="/WEB-INF/views/template/footer.jsp" %>
