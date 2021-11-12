<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header title">
            <h1>Register Customer</h1>
            <p class="lead">Fill the below information to create account</p>
        </div>
        <div class="form-layout">
            <form:form action="${pageContext.request.contextPath}/register.htm" method="post" modelAttribute="customer"
                       class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">

                        <c:if test="${not empty error }">
                            <label class="label-danger">${error}</label>
                        </c:if>
					   
                        <c:if test="${not empty update }">
                            <input name="update" type="hidden" value="update">
                            <input name="oldUserId" type="hidden" value="${customer.customerId}">
                        </c:if>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <h1>Basic Info :</h1>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="customerName" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="customerName">Name :</label>
                    <div class="col-xs-9">
                        <form:input path="customerName" class="form-control" placeholder="Enter Full Name"
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
                    <label class="col-xs-3 control-label" for="customerEmailAddress">Email Address :</label>
                    <div class="col-xs-9">
                        <form:input path="customerEmailAddress" class="form-control" placeholder="Enter Email Address"
                                    id="customerEmailAddress"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="customerPhoneNumber" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="customerPhoneNumber">Phone Number:</label>
                    <div class="col-xs-9">
                        <form:input path="customerPhoneNumber" class="form-control" placeholder="Enter Phone Number"
                                    id="customerPhoneNumber"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="username" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="username">Username:</label>
                    <div class="col-xs-9">
                        <form:input path="username" class="form-control" placeholder="Enter username" id="username"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="password" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="password">Password:</label>
                    <div class="col-xs-9">
                        <form:password showPassword="true" path="password" class="form-control"
                                       placeholder="Enter password" id="password"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <h1>Billing Address :</h1>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="billingAddress.city" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="billingAddress.city">Street Name:</label>
                    <div class="col-xs-9">
                        <form:input path="billingAddress.city" class="form-control"
                                    placeholder="Enter Street Name" id="billingAddress.city"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="billingAddress.country" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="billingAddress.country">Apartment Number:</label>
                    <div class="col-xs-9">
                        <form:input path="billingAddress.country" class="form-control"
                                    placeholder="Enter Apartment Number" id="billingAddress.country"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="billingAddress.zipCode" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="billingAddress.zipCode">City:</label>
                    <div class="col-xs-9">
                        <form:input path="billingAddress.zipCode" class="form-control" placeholder="Enter City"
                                    id="billingAddress.zipCode"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <h1>Shipping Address :</h1>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="shippingAddress.address" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="shippingAddress.address">Street Name:</label>
                    <div class="col-xs-9">
                        <form:input path="shippingAddress.address" class="form-control"
                                    placeholder="Enter Street Name" id="shippingAddress.address"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label" for="customerName"></label>
                    <div class="col-xs-9">
                        <form:errors path="shippingAddress.city" cssStyle="color: #ff0000"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="shippingAddress.city">City:</label>
                    <div class="col-xs-9">
                        <form:input path="shippingAddress.city" class="form-control" placeholder="Enter City"
                                    id="shippingAddress.city"/>
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
                        <form:input path="shippingAddress.country" class="form-control" placeholder="Enter Country"
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
                    <label class="col-xs-3 control-label" for="shippingAddress.zipCode">Zip Code:</label>
                    <div class="col-xs-9">
                        <form:input path="shippingAddress.zipCode" class="form-control" placeholder="Enter Zip Code"
                                    id="shippingAddress.zipCode"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <input type="submit" value="Submit" class="btn btn-default">
                        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>