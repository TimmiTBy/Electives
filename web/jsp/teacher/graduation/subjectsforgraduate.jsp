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
            <table class="courselist">
                <c:forEach var="course" items="${teacherCourses}" varStatus="status">
                    <tr>
                        <td>
                            <b><fmt:message key="label.course.id"/>:</b> ${course.getId()}<br/>
                            <b><fmt:message key="label.course.name"/>:</b> ${course.name}<br/>
                            <b><fmt:message key="label.course.hours"/>:</b> ${course.hours}<br/>
                            <b><fmt:message key="label.course.description"/>:</b> ${course.description}<br/>
                            <form name="raduateStudents" method="POST" action="Controller">
                                <input type="hidden" name="command" value="graduate_students"/>
                                <input type="hidden" name="name" value="${course.name}"/>
                                <input type="hidden" name="id" value="${course.getId()}"/>
                                <input class="submitbutton" type="submit" value="<fmt:message key="label.teacher.graduatestudents"/>"/>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td><br/></td>
                    </tr>
                </c:forEach>
            </table>
            <div>
                <c:if test="${noCourses == true}"><fmt:message key="message.info.nocourses"/></c:if>
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
