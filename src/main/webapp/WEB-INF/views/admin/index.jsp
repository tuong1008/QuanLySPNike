<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">

    <div class="container">

        <div class="page-header">
            <h1>Administrator Page</h1>

            <p class="lead">This is a administrator page!</p>
        </div>

        <c:if test="${sessionScope.username!=null}">
            Welcome :${sessionScope.username} | <a href="<c:url value="/logout"/>">Logout</a>
        </c:if>


        <h3>
            <a href="<c:url value="/admin/productManagement/1.htm"/>">Product Management</a>
        </h3>
        <p>Here you can view ,check and modify the product inventory</p>


        <br/><br/>

        <h3>
            <a href="<c:url value="/admin/customerManagement.htm"/>">Customer Management</a>
        </h3>
        <p>Here you can view the customer information</p>


        <br/><br/>

        <h3>
            <a href="<c:url value="/admin/customerOrder.htm"/>">Customer Order</a>
        </h3>
        <p>Here you can view the all customer order</p>


        <br/><br/>

        <h3>
            <a href="<c:url value="/admin/customerMessages/1.htm"/>">Customer Messages</a>
        </h3>
        <p>Here you can view the all customer message</p>


    </div>


<%@include file="/WEB-INF/views/template/footer.jsp" %>