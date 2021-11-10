<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="404 ERROR"/>
</jsp:include>

<h1>Page not found</h1>
<img src="resources/images/error.gif" alt="404 not found">

<%@include file="/WEB-INF/views/template/footer.jsp" %>
