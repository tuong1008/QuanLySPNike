<%@include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator Page</h1>
            <p class="lead">This is a administrator page!</p>
        </div>
        <%--        <c:if test="${sessionScope.username!=null}">--%>
        <%--            Welcome :${sessionScope.username} | <a href="<c:url value="/logout.htm"/>">Logout</a>--%>
        <%--        </c:if>--%>
        <div class="card w-25">
            <div class="card-body">
                <a class="link-primary h3" href="<c:url value="/admin/productManagement/1.htm"/>">Product Management</a>
                <p class="">View, check and modify the product inventory</p>
            </div>
        </div>
        <br/><br/>
        <div class="card w-25">
            <div class="card-body">
                <a class="link-primary h3" href="<c:url value="/admin/customerManagement/1.htm"/>">Customer Management</a>
                <p>View customers information</p>
            </div>
        </div>
        <br/><br/>
        <div class="card w-25">
            <div class="card-body">
                <a class="link-primary h3" href="<c:url value="/admin/customerOrder/1.htm"/>">Customer Order</a>
                <p>View all customers' orders</p>
            </div>
        </div>
        <br/><br/>
        <div class="card w-25">
            <div class="card-body">
                <a class="link-primary h3" href="<c:url value="/admin/customerMessages/1.htm"/>">Customer Messages</a>
                <p>View all customer message</p>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>