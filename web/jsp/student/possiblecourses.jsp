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
        <section id="possiblecoursescontent">
            <div>
                <form name="subscribe" action="Controller" method="post">
                    <div>
                        <input type="hidden" name="command" value="subscribe"/>
                        <table class="tbl">
                            <caption><fmt:message key="label.student.possiblecourses"></fmt:message></caption>
                            <tr>
                                <th class="colth"></th>
                                <th class="colth"><fmt:message key="label.course.name"></fmt:message></th>
                                <th class="colth"><fmt:message key="label.course.hours"></fmt:message></th>
                                <th class="colth"><fmt:message key="label.course.description"></fmt:message></th>
                            </tr>
                            <c:forEach var="course" items="${possibleCourses}">
                                <tr>
                                    <td class="coltdchbox"><input  type="checkbox" name="id" value="${course.id}"/>
                                    <td class="coltd"><c:out value="${ course.name }" /></td>
                                    <td class="coltd"><c:out value="${ course.hours }" /></td>
                                    <td class="coltddescription"><c:out value="${ course.description}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <div>
                            <c:if test="${noCourses == true}"><fmt:message key="message.info.nopossiblecourses"/></c:if>
                            <c:if test="${error == true}"><fmt:message key="message.info.nopossiblecourses"/></c:if>
                        </div>
                        <input class="submitbutton" type="submit" value="<fmt:message key="label.student.subscribetocourse"/>"/>
                    </div>
                </form>
            </div>
            <div id="successmessage">
                <c:if test="${successSubscibe == true}"><fmt:message key="message.info.successsubscibe"/></c:if>
            </div>
            <div id="errormessage">
                <c:if test="${noSelectedcourses == true}"><fmt:message key="message.info.noselectedcourses"/></c:if>
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
