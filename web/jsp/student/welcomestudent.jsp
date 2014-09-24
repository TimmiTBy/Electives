<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<html>
<head>
    <title>Welcome</title>
        <fmt:setLocale value="${locale}" scope="session"/>
        <fmt:setBundle basename="resourses.pagecontent"/>
        <link rel="stylesheet" href="/css/style.css">
</head>
    <body>
        <div class="container">
            <section id="content">
                <div>
                    <form name="personalAccount" action="/Controller" method="post">
                        <input type="hidden" name="command" value="personal_account" />
                        <input class="submitbutton" class="submitbutton" type="submit" value="<fmt:message key="label.user.personalaccount"/>">
                    </form>
                </div>
                <div>
                    <form name="studentCourses" action="/Controller" method="post">
                        <input type="hidden" name="command" value="find_student_courses" />
                        <input class="submitbutton" class="submitbutton" type="submit" value="<fmt:message key="label.student.studentcourses"/>">
                    </form>
                </div>
                <div>
                    <form name="possibleCourses" action="/Controller" method="post">
                        <input type="hidden" name="command" value="find_possible_courses" />
                        <input class="submitbutton" class="submitbutton" type="submit" value="<fmt:message key="label.student.possiblecourses"/>">
                    </form>
                </div>
                <ctg:info-tag firstName="${userFirstName}" lastName="${userLastName}" role="${userRole}"/>
                <div>
                    <form name="LogOut" action="Controller" method="post">
                        <input type="hidden" name="command" value="logout"/>
                        <input class="submitbutton" class="submitbutton" type="submit" value="<fmt:message key="label.logout.logout"/> ">
                    </form>
                </div>
                <div id="footer">
                    <c:import url="/jsp/common/footer.jsp" charEncoding="utf-8"/>
                </div>
             </section>
        </div>
    </body>
</html>
