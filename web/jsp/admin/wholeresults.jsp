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
        <section id="universityresults">
            <div>
                <div>
                    <table  class="tbl">
                        <b><caption><fmt:message key="label.admin.universityresults"></fmt:message></caption></b>
                        <tr>
                            <th class="colth"><fmt:message key="label.course.name"></fmt:message></th>
                            <th class="colth"><fmt:message key="label.registration.first_name"></fmt:message></th>
                            <th class="colth"><fmt:message key="label.registration.last_name"></fmt:message></th>
                            <th class="colth"><fmt:message key="label.course.mark"></fmt:message></th>
                            <th class="colth"><fmt:message key="label.course.feedback"></fmt:message></th>
                        </tr>
                        <c:forEach var="result" items="${universityResults}">
                            <tr>
                                <td class="coltd"><b><c:out value="${ result.getCourseName() }" /></b></td>
                                <td class="coltd"><c:out value="${ result.getFirstName() }" /></td>
                                <td class="coltd"><c:out value="${ result.getLastName() }" /></td>
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
                </div>
            </div>
            <div>
                <c:if test="${noResults == true}"><fmt:message key="message.info.nouniversityresults"/></c:if>
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
