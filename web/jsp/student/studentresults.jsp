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
        <section id="courseresults">
                <div>
                    <c:if test="${error == true}"><fmt:message key="message.error.findstudenyresults"/></c:if>
                </div>
                <div>
                    <form name="results" action="Controller" method="post">
                        <div>
                            <input type="hidden" name="command" value="unsubscribe"/>
                            <table class="tbl">
                                <caption><fmt:message key="label.course.result"></fmt:message></caption>
                                <tr>
                                    <th class="colth"></th>
                                    <th class="colth"><fmt:message key="label.course.name"></fmt:message></th>
                                    <th class="colth"><fmt:message key="label.course.hours"></fmt:message></th>
                                    <th class="colth"><fmt:message key="label.course.mark"></fmt:message></th>
                                    <th class="colth"><fmt:message key="label.course.feedback"></fmt:message></th>
                                </tr>
                                <c:forEach var="result" items="${studentResult}">
                                    <tr>
                                        <td class="coltdchbox">
                                            <c:if test="${ result.getMark() == 0 }">
                                                <input id="ckbox" type="checkbox" name="idResult" value="${result.id}"/>
                                            </c:if>
                                        </td>
                                        <td class="coltd"><c:out value="${ result.courseName }" /></td>
                                        <td class="coltd"><c:out value="${ result.courseHours }" /></td>
                                        <td class="coltd">
                                            <c:if test="${result.getMark() != 0}">
                                                <c:out value="${ result.getMark() }" />
                                            </c:if>
                                            <c:if test="${ result.getMark() == 0 }">
                                                <fmt:message key="message.info.noresult"/>
                                            </c:if>
                                        </td>
                                        <td class="coltdfeedback">
                                            <c:if test="${result.getFeedback() != null}">
                                                <c:out value="${ result.getFeedback() }"/>
                                            </c:if>
                                            <c:if test="${ result.getFeedback() == null }">
                                                <fmt:message key="message.info.noresult"/>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <input class="submitbutton" type="submit" value="<fmt:message key="label.student.unsubscribe"/>"/>
                        </div>
                    </form>
                </div>
                <div id="errormessage">
                    <c:if test="${noSelectedcourses == true}"><fmt:message key="message.info.noselectedcourses"/></c:if>
                </div>
                <div id="successmessage">
                    <c:if test="${successUnsubscibe == true}"><fmt:message key="message.info.successunsubscibe"/></c:if>
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
