<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>
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
            <div>
                <form name="personalAccount" action="/Controller" method="post">
                    <input type="hidden" name="command" value="personal_account"/>
                    <input class="submitbutton" type="submit" value="<fmt:message key="label.user.personalaccount"/>">
                </form>
            </div>
            <div>
                <form name="createTeacher" action="/Controller" method="post">
                    <input type="hidden" name="command" value="start_teacher_registration"/>
                    <input class="submitbutton" type="submit" value="<fmt:message key="label.admin.registerteacher"/>">
                </form>
            </div>
            <div>
                <form name="wholeResults" action="Controller" method="post">
                    <input type="hidden" name="command" value="whole_university_results"/>
                    <input class="submitbutton" type="submit" value="<fmt:message key="label.admin.showuniversutyresults"/> ">
                </form>
            </div>
            <div>
                <form name="changeData" action="Controller" method="post">
                    <input type="hidden" name="command" value="start_reset_pass"/>
                    <input class="submitbutton" type="submit" value="<fmt:message key="label.admin.changeuserdata"/> ">
                </form>
            </div>
            <div>
                <form name="deleteUser" action="Controller" method="post">
                    <input type="hidden" name="command" value="start_delete_user"/>
                    <input class="submitbutton" type="submit" value="<fmt:message key="label.admin.deleteuser"/> ">
                </form>
            </div>
            <ctg:info-tag firstName="${userFirstName}" lastName="${userLastName}" role="${userRole}"/>
            <div>
                <form name="LogOut" action="Controller" method="post">
                    <input type="hidden" name="command" value="logout"/>
                    <input class="submitbutton" type="submit" value="<fmt:message key="label.logout.logout"/> ">
                </form>
            </div>
            <div id="footer">
                <c:import url="/jsp/common/footer.jsp" charEncoding="utf-8"/>
            </div>
        </section>
    </div>
</body>
</html>
