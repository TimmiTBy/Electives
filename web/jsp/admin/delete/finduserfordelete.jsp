<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <div>
                <form name="findForm" action="Controller" method="POST">
                    <input type="hidden" name="command" value="find_user_for_delete">
                    <div>
                        <input class="userdata" id="username" type="text" name="login" placeholder="<fmt:message key="label.admin.enterlogin"/>" required=""/>
                    </div>
                    <div>
                        <input class="submitbutton" type="submit" value="<fmt:message key="label.admin.find"/> "/>
                    </div>
                </form>
            </div>
            <div id="successmessage">
                <c:if test="${successDelete == true}"><fmt:message key="message.info.successdelete"/></c:if>
            </div>
            <div id="errormessage">
                <c:if test="${notDeleteRole == true}"><fmt:message key="message.info.cantdeleteadmin"/></c:if>
                <c:if test="${error == true}"><fmt:message key="message.error.findingUser"/></c:if>
            </div>
            <div>
                <form name="backToWelcome" action="Controller" method="post">
                    <div>
                        <input type="hidden" name="command" value="back_to_welcome"/>
                        <input class="submitbutton" type="submit" value="<fmt:message key="label.user.backtowelcome"/>"/>
                    </div>
                </form>
            </div>
            <div id="footer">
                <c:import url="/jsp/common/footer.jsp" charEncoding="utf-8"/>
            </div>
        </section>
    </div>
</body>
</html>
