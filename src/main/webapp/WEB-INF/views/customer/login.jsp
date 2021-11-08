<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header title">
            <h1>Login with Username and Password</h1>
            <p class="lead">Fill the below information to login</p>
        </div>
        <div class="form-layout">
            <form:form action="${pageContext.servletContext.contextPath}/login.htm" method="post"
                       class="form-horizontal" modelAttribute="customer">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <c:if test="${not empty error}">
                            <div class="error" style="color:#ff0000">
                                    ${error}
                            </div>
                        </c:if>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <c:if test="${not empty msg}">
                            <div class="msg">${msg}</div>
                        </c:if>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="username">Username :</label>
                    <div class="col-xs-9">
                        <form:input type="text" class="form-control" placeholder="Enter Username" path="username"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="password">Password :</label>
                    <div class="col-xs-9">
                        <form:input type="password" class="form-control" path="password" placeholder="Enter Password"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        Remember Me: <input type="checkbox" name="remember-me"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <input type="submit" value="Submit" class="btn btn-default">
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>