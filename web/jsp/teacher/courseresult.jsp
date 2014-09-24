<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
    <fmt:setLocale value="${locale}" scope="session"/>
    <fmt:setBundle basename="resourses.pagecontent"/>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="container">
        <section id="courseresults">
            <div>
                <table class="tbl">
                    <caption><fmt:message key="label.course.result"></fmt:message></caption>
                    <tr>
                        <th class="colth"><fmt:message key="label.registration.first_name"></fmt:message></th>
                        <th class="colth"><fmt:message key="label.registration.last_name"></fmt:message></th>
                        <th class="colth"><fmt:message key="label.course.mark"></fmt:message></th>
                        <th class="colth"><fmt:message key="label.course.feedback"></fmt:message></th>
                    </tr>
                    <c:forEach var="result" items="${results}">
                        <tr>
                            <td class="coltd"><c:out value="${ result.firstName }"/></td>
                            <td class="coltd"><c:out value="${ result.lastName }"/></td>
                            <td class="coltd"><c:out value="${ result.mark }"/></td>
                            <td class="coltdfeedback"><c:out value="${ result.feedback }"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div>
                <c:if test="${noGraduatedStudents == true}"><fmt:message key="message.info.nograduatedstudents"/></c:if>
            </div>
            <div>
                <form name="teacherCourses" action="/Controller" method="post">
                    <input type="hidden" name="command" value="find_teacher_courses"/>
                    <input class="submitbutton" type="submit" value="<fmt:message key="label.teacher.backtocheachercourses"/>">
                </form>
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
