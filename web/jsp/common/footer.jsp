<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="resourses.pagecontent"/>
<html>
<head>
    <title>Footer</title>
</head>
<body>
    <p><fmt:message key="footer.copyright"></fmt:message></p>
</body>
</html>
