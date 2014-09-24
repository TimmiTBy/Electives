<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="/js/passwordvalidation.js"></script>
<html>
<head>
    <title></title>
    <fmt:setLocale value="${locale}" scope="session"/>
    <fmt:setBundle basename="resourses.pagecontent"/>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <section id="content">
        <form name="Registration" action="Controller" method="POST">
            <input type="hidden" name="command" value="registration"/>
            <div id="regexlogin"><fmt:message key="label.registration.loginpattern"/></div>
            <div>
                <input class="userdata" id="username" type="text" name="login" pattern="^[a-z0-9_-]{3,15}$"
                       placeholder="<fmt:message key="label.registration.login"/>" autofocus required/>
            </div>
            <div>
                <input class="userdata" id="fname" type="text" name="firstname"
                       placeholder="<fmt:message key="label.registration.first_name"/>" required/>
            </div>
            <div>
                <input class="userdata" id="lname" type="text" name="lastname" required=""
                       placeholder="<fmt:message key="label.registration.last_name"/>"/>
            </div>
            <div id="regexpass"><fmt:message key="label.registration.passwordpattern"/></div>
            <div>
                <input id="pass1" type="password" name="password" pattern="^[a-zA-Z0-9_-]{6,16}$" autofocus required
                       placeholder="<fmt:message key="label.registration.password"/>" onkeyup="checkForm(this)"/>
            </div>
            <div>
                <input id="pass2" type="password" name="re-password" required
                       placeholder="<fmt:message key="label.registration.re-password"/>" onkeyup="checkForm(this)"/>
            </div>
            <div id="errormessage">
                <c:if test="${passwordError == true}"><fmt:message key="message.error.matchpass"/></c:if>
                <c:if test="${loginExist == true}"><fmt:message key="message.error.existlogin"/></c:if>
                <c:if test="${emptyFields == true}"><fmt:message key="message.info.emptyFields"/></c:if>
                <c:if test="${errorRegistration == true}"><fmt:message key="message.error.errorRegistration"/></c:if>
                <c:if test="${regexError == true}"><fmt:message key="message.error.regexmatch"/></c:if>
            </div>
            <div id="successreg">
                <c:if test="${successRegestration == true}"><fmt:message
                        key="message.success.teacherregistration"/></c:if>
            </div>
            <div id="msg">
                <fmt:message key="message.error.matchpass"/>
            </div>
            <input class="submitbutton" type="submit" value="<fmt:message key="label.registration.register"/>">
        </form>
        <form name="backToLogin" action="Controller" method="post">
            <div>
                <input type="hidden" name="command" value="back_to_welcome"/>
                <input class="submitbutton" type="submit" value="<fmt:message key="label.user.backtowelcome"/>">
            </div>
        </form>
        <div id="footer">
            <c:import url="/jsp/common/footer.jsp" charEncoding="utf-8"/>
        </div>
    </section>
</div>
</body>
</html>
