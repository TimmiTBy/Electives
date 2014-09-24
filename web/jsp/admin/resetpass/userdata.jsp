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
            <div id="accfirstname">
                <fmt:message key="label.registration.first_name"/>: ${foundFirstName}
            </div>
            <div id="acclastname">
                <fmt:message key="label.registration.last_name"/>: ${foundLastName}
            </div>
            <form name="changePassword" action="/Controller" method="post">
                <input type="hidden" name="command" value="reset_password"/>
                <div id="regexpass"><fmt:message key="label.registration.passwordpattern"/></div>
                <div>
                    <input id="pass1" type="password" name="password" pattern="^[a-zA-Z0-9-_]{6,16}$" autofocus required
                           placeholder="<fmt:message key="label.registration.password"/>*" onkeyup="checkForm(this)"/>
                </div>
                <div>
                    <input id="pass2" type="password" name="re-password" required
                           placeholder="<fmt:message key="label.registration.re-password"/>*" onkeyup="checkForm(this)"/>
                </div>
                <div id="errormessage">
                    <c:if test="${passwordError == true}"><fmt:message key="message.error.matchpass"/></c:if>
                    <c:if test="${regexError == true}"><fmt:message key="message.error.regexmatch"/></c:if>
                    <c:if test="${emptyFields == true}"><fmt:message key="message.info.emptyFields"/></c:if>
                    <c:if test="${error == true}"><fmt:message key="message.error.passwordchange"/></c:if>
                </div>
                <div id="msg">
                    <fmt:message key="message.error.matchpass"/>
                </div>
                <div>
                    <input class="submitbutton" type="submit" value="<fmt:message key="label.user.changepass"/>">
                </div>
            </form>
            <form name="backToWelcome" action="Controller" method="post">
                <div>
                    <input type="hidden" name="command" value="back_to_welcome"/>
                    <input class="submitbutton" type="submit" value="<fmt:message key="label.user.backtowelcome"/>"/>
                </div>
            </form>
            <div id="footer">
                <c:import url="/jsp/common/footer.jsp" charEncoding="utf-8"/>
            </div>
        </section>
    </div>
</body>
</html>
