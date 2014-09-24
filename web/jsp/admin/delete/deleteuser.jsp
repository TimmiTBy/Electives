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
            <div id="accfirstname" >
                <fmt:message key="label.registration.first_name"/>: ${foundFirstName}
            </div>
            <div id="acclastname">
                <fmt:message key="label.registration.last_name"/>: ${foundLastName}
            </div>
            <div>
                <c:if test="${nouserid == true}"><fmt:message key="message.error.deleteUser"/></c:if>
            </div>
            <form name="deleteUser" action="/Controller" method="post">
                <input type="hidden" name="command" value="delete_user"/>
                <input class="submitbutton" type="submit" value="<fmt:message key="label.admin.deleteuser"/> ">
            </form>
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
