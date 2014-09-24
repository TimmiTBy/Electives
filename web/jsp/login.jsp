<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Login</title>
    <fmt:setLocale value="${locale}" scope="session"/>
    <fmt:setBundle basename="resourses.pagecontent"/>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="container">
        <section id="content">
            <div id="lngform">
                <form name="LanguageForm" method="POST" action="Controller">
                    <input type="hidden" name="command" value="change_language"/>
                    <input class="loginpagebutton" name="language" type="submit" value="EN"/>
                    <input class="loginpagebutton" name="language" type="submit" value="RU"/>
                </form>
            </div>
            <form name="LoginForm" action="Controller" method="POST">
                <input type="hidden" name="command" value="login">
                <div>
                    <input class="userdata" id="username" class="username" type="text" placeholder="<fmt:message key="labels.login.login"/>" required=""
                           name="login"/>
                </div>
                <div>
                    <input id="password" type="password" class="password" placeholder="<fmt:message key="labels.login.password"/>"
                           required="" name="password"/>
                </div>
                <div id="vhod">
                    <input class="loginpagebutton" type="submit" name="login" value="<fmt:message key="labes.login.enter"/> "/>
                </div>
                <div id="error">
                    <c:if test="${errorLoginPassMessage == true}"><fmt:message key="message.error.pass"/></c:if>
                    <c:if test="${errorUnknownUserType == true}"><fmt:message key="message.error.unknownusertype"/></c:if>
                </div>
                <div id ="successreg">
                    <c:if test="${successRegestration == true}"><fmt:message key="message.success.registration"/></c:if>
                </div>
            </form>
            <div class="regform">
                <form name="RegistrationForm" action="Controller" method="POST">
                    <input type="hidden" name="command" value="start_student_registration">
                    <input class="loginpagebutton" type="submit" name="Registration" value="<fmt:message key="labes.login.registration"/>">
                </form>
                <p id="forgotpass">
                    <a href="Controller?command=forgot_password"><fmt:message key="label.login.forgotpassword"></fmt:message></a>
                </p>
            </div>
            <a href="Controller?command=about">About</a>
            <div>
                <c:import url="/jsp/common/footer.jsp" charEncoding="utf-8"/>
            </div>
        </section>
    </div>
</body>
</html>

