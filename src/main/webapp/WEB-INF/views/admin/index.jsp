<%@include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator Page</h1>
        </div>
        <div class="card w-25">
            <div class="card-body text-center">
                <div class="text-center">
                    <a class="link-primary h4" href="admin/productManagement/1.htm">Product Management</a>
                </div>
                <p>View, check and modify the product inventory</p>
            </div>
        </div>
        <br/><br/>
        <div class="card w-25">
            <div class="card-body text-center">
                <div class="text-center">
                    <a class="link-primary h4" href="admin/customerManagement/1.htm">Customer Management</a>
                </div>
                <p>View customers information</p>
            </div>
        </div>
        <br/><br/>
        <div class="card w-25">
            <div class="card-body text-center">
                <div class="text-center">
                    <a class="link-primary h4" href="admin/customerOrder/1.htm">Customer Order</a>
                </div>
                <p>View all orders</p>
            </div>
        </div>
        <br/><br/>
        <div class="card w-25">
            <div class="card-body text-center">
                <div class="text-center">
                    <a class="link-primary h4 text-center" href="/admin/messages/1.htm">Customer Messages</a>
                </div>
                <p>View all customer message</p>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>