<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="404 ERROR"/>
</jsp:include>
<div style="position: absolute; top:10%; left: 30px">
    <h1>${message}</h1> 
</div>
<img src="resources/images/error.gif" alt="404 not found">

<%@include file="/WEB-INF/views/template/footer.jsp" %>