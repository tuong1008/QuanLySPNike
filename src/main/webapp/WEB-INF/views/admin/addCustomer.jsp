<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="Create new account"/>
</jsp:include>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header title">
            <h1>Register new customer</h1>
            <p class="lead">Fill the below information to create account</p>
        </div>
        <div class="form-layout">
            <form:form action="${pageContext.request.contextPath}/register" method="post" commandName="customer"
                       class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <c:if test="${not empty emailMsg}">
                            <label class="label-danger">${emailMsg}</label>
                        </c:if>
                        <c:if test="${not empty usernameMsg}">
                            <label class="label-danger">${usernameMsg}</label>
                        </c:if>
                        <c:if test="${not empty update}">
                            <input name="update" hidden="true" value="update">
                            <input name="oldUserId" hidden="true" value="${customer.customerId}">
                        </c:if>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <h1 class="fs-4">Basic Info</h1>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="customerName" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="customerName" class="form-control" placeholder="Full Name"
                                    id="customerName"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="customerEmailAddress" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="customerEmailAddress" class="form-control" placeholder="Email Address"
                                    id="customerEmailAddress"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="custometPhoneNumber" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="custometPhoneNumber" class="form-control" placeholder="Phone Number"
                                    id="custometPhoneNumber"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="username" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="username" class="form-control" placeholder="username" id="username"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="password" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:password path="password" class="form-control" placeholder="password" id="password"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <h1>Billing Address</h1>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="billingAddress.streetName" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="billingAddress.strretName" class="form-control"
                                    placeholder="Street Name" id="billingAddress.strretName"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="billingAddress.apartmentNumber" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="billingAddress.apartmentNumber" class="form-control"
                                    placeholder="Apartment Number" id="billingAddress.apartmentNumber"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="billingAddress.city" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="billingAddress.city" class="form-control" placeholder="City"
                                    id="billingAddress.city"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="billingAddress.state" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="billingAddress.state" class="form-control" placeholder="State"
                                    id="billingAddress.state"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="billingAddress.country" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="billingAddress.country" class="form-control" placeholder="Country"
                                    id="billingAddress.country"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="billingAddress.zipCode" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="billingAddress.zipCode" class="form-control" placeholder="Zip Code"
                                    id="billingAddress.zipCode"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <h1>Shipping Address</h1>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="shippingAddress.strretName" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="shippingAddress.strretName" class="form-control"
                                    placeholder="Street Name" id="shippingAddress.strretName"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="shippingAddress.apartmentNumber" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="shippingAddress.apartmentNumber" class="form-control"
                                    placeholder="Apartment Number" id="shippingAddress.apartmentNumber"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="shippingAddress.city" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="shippingAddress.city" class="form-control" placeholder="City"
                                    id="shippingAddress.city"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="shippingAddress.state" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="shippingAddress.state" class="form-control" placeholder="State"
                                    id="shippingAddress.state"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="shippingAddress.country" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="shippingAddress.country">Country:</label>
                    <div class="col-xs-9">
                        <form:input path="shippingAddress.country" class="form-control" placeholder="Country"
                                    id="shippingAddress.country"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="shippingAddress.zipCode" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <div class="col-xs-9">
                        <form:input path="shippingAddress.zipCode" class="form-control" placeholder="Zip Code"
                                    id="shippingAddress.zipCode"/>
                    </div>
                </div>
                <div class="col-xs-9">
                    <div class="d-flex justify-content-center">
                        <input type="submit" value="Submit" class="btn btn-dark btn-primary">
                    </div>
                    <p class="text-center text-muted mt-5 mb-0">Already have an account?
                        <a href="login.htm" class="fw-bold text-body"><u>Login</u></a></p>
                </div>
            </form:form>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>