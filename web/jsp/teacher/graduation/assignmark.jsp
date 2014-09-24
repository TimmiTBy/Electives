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
            ${courseName}
            <form name="confirmMark" method="post" action="/Controller">
                <input type="hidden" name="command" value="confirm_mark"/>
                <input type="hidden" name="idResult" value="${idResult}">
                <p>
                    <select id="markmenu" name="mark" required="">
                    <option disabled><fmt:message key="label.teacher.choosemark"></fmt:message></option>
                    <option name="mark" value="1">1</option>
                    <option name="mark" value="2">2</option>
                    <option name="mark" value="3">3</option>
                    <option name="mark" value="4">4</option>
                    <option name="mark" value="5">5</option>
                    <option name="mark" value="6">6</option>
                    <option name="mark" value="7">7</option>
                    <option name="mark" value="8">8</option>
                    <option name="mark" value="9">9</option>
                    <option name="mark" value="10">10</option>
                    </select>
                </p>
                <div id="regexfeedback"><fmt:message key="label.teacher.feedbackregex"></fmt:message></div>
                <input class="basictext" type="text" placeholder="<fmt:message key="label.course.feedback"/>" name="feedback" required=""/>
                <input class="submitbutton" type="submit" value="<fmt:message key="label.teacher.confirmmark"/>"/>
            </form>
            <div id="errormessage">
                <c:if test="${errorvalidationdata == true}"><fmt:message key="message.error.regexmatch"/></c:if>
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
