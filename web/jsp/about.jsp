<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>About</title>
    <fmt:setLocale value="${locale}" scope="session"/>
    <fmt:setBundle basename="resourses.pagecontent"/>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="container">
        <section id="content">
            <div id="abouttext"><b><fmt:message key="message.info.about"></fmt:message></b></div><br/>
            <div id="email">
                <a href="mailto:ales.klikun@gmail.com">ales.klikun@gmail.com</a>
            </div>
            <form name="backToLogin" action="Controller" method="post">
                <div>
                    <input type="hidden" name="command" value="back_to_login"/>
                    <input class="submitbutton" type="submit" value="<fmt:message key="label.registration.backtologin"/>">
                </div>
            </form>
            <div id="footer">
                <c:import url="/jsp/common/footer.jsp" charEncoding="utf-8"/>
            </div>
        </section>
    </div>
</body>
</html>
