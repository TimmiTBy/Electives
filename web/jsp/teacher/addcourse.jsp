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
            <div><fmt:message key="label.teacher.addcourse"></fmt:message></div>
                <form name="addNewCourse" action="Controller" method="POST">
                    <input type="hidden" name="command" value="add_course"/>
                    <div>
                        <input class="basictext" type="text" name="name"  required placeholder="<fmt:message key="label.teacher.coursename"/>*"/>
                    </div>
                    <div id="regexcoursename"><fmt:message key="label.teacher.regexcoursehours"></fmt:message></div>
                    <div>
                        <input class="basictext" type="text" name="hours" required placeholder="<fmt:message key="label.teacher.coursehours"/>*"/>
                    </div>
                    <div id="regexcoursedescription"><fmt:message key="label.teacher.regexcoursedescription"></fmt:message></div>
                    <div>
                        <input type="text" class="basictext" name="description" required placeholder="<fmt:message key="label.teacher.coursedescription"/>*"/>
                    </div>
                    <input class="submitbutton" type="submit" value="<fmt:message key="label.teacher.addcourse"/>">
                </form>
                <div id="successmessage">
                    <c:if test="${successadd == true}"><fmt:message key="message.info.successaddcourse"/></c:if>
                </div>
                <div id="errormessage">
                    <c:if test="${courseExist == true}"><fmt:message key="message.info.courseexist"/></c:if>
                    <c:if test="${courseDataRegex == true}"><fmt:message key="message.error.regexmatch"/></c:if>
                    <c:if test="${errorAddCourse == true}"><fmt:message key="message.error.erroraddcourse"/></c:if>
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
