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
        <section id="graduatestudentscontent">
            <b>${courseName}</b>
            <div>
                <c:if test="${noStudentsToGraduate == true}"><fmt:message key="message.info.nostudentstograduate"/></c:if>
            </div>
            <div>
                <table class="tbl">
                    <tr>
                        <th class="colth"><fmt:message key="label.course.resultid"></fmt:message></th>
                        <th class="colth"><fmt:message key="label.registration.first_name"></fmt:message></th>
                        <th class="colth"><fmt:message key="label.registration.last_name"></fmt:message></th>
                        <th class="colth"><fmt:message key="label.course.mark"></fmt:message></th>
                        <th class="colth"><fmt:message key="label.course.feedback"></fmt:message></th>
                        <th class="colth"></th>
                    </tr>
                    <c:forEach var="forResult" items="${studentsCourseResults}">
                        <tr>
                           <td class="coltd"><c:out value="${ forResult.getId() }"/></td>
                           <td class="coltd"><c:out value="${ forResult.firstName }"/></td>
                           <td class="coltd"><c:out value="${ forResult.lastName }"/></td>
                           <td class="coltd">
                                <c:if test="${forResult.getMark() != 0}">
                                    <c:out value="${ forResult.getMark() }"/>
                                </c:if>
                                <c:if test="${ forResult.getMark() == 0 }">
                                    <fmt:message key="message.info.noresult"/>
                                </c:if>
                            </td>
                            <td class="coltdfeedback">
                                <c:if test="${forResult.getFeedback() != null}">
                                    <c:out value="${ forResult.getFeedback() }"/>
                                </c:if>
                                <c:if test="${ forResult.getFeedback() == null }">
                                    <fmt:message key="message.info.noresult"/>
                                </c:if>
                            </td>
                           <td class="coltd">
                               <form name="ShowResults" method="POST" action="Controller">
                                <input type="hidden" name="command" value="assign_mark"/>
                                <input type="hidden" name="idResult" value="${forResult.getId()}"/>
                                <input type="hidden" name="firstName" value="${forResult.firstName}"/>
                                <input type="hidden" name="lastName" value="${forResult.lastName}"/>
                                <input type="hidden" name="courseName" value=" ${courseName}"/>
                                <input class="assignmarkbutton" type="submit" value="<fmt:message key="label.teacher.markandfeedback"/>"/>
                               </form>
                           </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="successmessage">
                <c:if test="${successConfirmMark == true}"><fmt:message key="message.info.successconfirmmark"/></c:if>
            </div>
            <div>
                <form name="findGraduationCourseList" action="/Controller" method="post">
                    <input type="hidden" name="command" value="find_graduation_course_list"/>
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
