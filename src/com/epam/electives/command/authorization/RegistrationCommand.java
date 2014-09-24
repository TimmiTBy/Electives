package com.epam.electives.command.authorization;

import com.epam.electives.command.ICommand;
import com.epam.electives.db.dao.UserDao;
import com.epam.electives.entity.User;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.logic.IsLoginExist;
import com.epam.electives.util.Constants;

import com.epam.electives.util.PageManager;
import com.epam.electives.util.Validator;
import org.apache.log4j.Logger;
import org.mindrot.BCrypt;

import javax.servlet.http.HttpServletRequest;

/**
 * Registration user(student or teacher)
 */
public class RegistrationCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(RegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;
        String login = request.getParameter(Constants.PARAM_USER_LOGIN);
        String password1 = request.getParameter(Constants.PARAM_USER_PASSWORD);
        String password2 = request.getParameter(Constants.PARAM_USER_RE_PASSWORD);
        String firstName = request.getParameter(Constants.PARAM_USER_FIRST_NAME);
        String lastName = request.getParameter(Constants.PARAM_USER_LAST_NAME);
        String role = String.valueOf(request.getSession().getAttribute(Constants.REGESTRATION_ROLE));

        /*check role of register user
          if register a student or admin is register new teacher*/
        if(role.equals(Constants.STUDENT_ROLE)) {
            page = PageManager.getPage("path.page.studentregistration");
        }
        if (role.equals(Constants.TEACHER_ROLE)) {
            page = PageManager.getPage("path.page.teacherregistration");
        }
        if(!role.equals(Constants.STUDENT_ROLE) && !role.equals(Constants.TEACHER_ROLE)){
            return PageManager.getPage("path.page.error");
        }

        //server check, if on JSP check is fail
        if (login == null || firstName == null || lastName == null) {
            request.setAttribute("emptyFields", true);
            return page;
        }
        if (!password1.equals(password2)|| password1 == null) {
            request.setAttribute("passwordError", true);
            return page;
        }
        if (Validator.validateRegestrationData(login, password1)) {
            request.setAttribute("regexError", true);
            return page;
        }

        //login exist check
        try {
            if (IsLoginExist.checkLoginExist(login)) {
                request.setAttribute("loginExist", true);
                return page;
            }
        } catch (DaoException e) {
            LOG.error("Error while checking login exist", e);
            request.setAttribute("errorRegistration", true);
            return page;
        }

        String hashedPassword = BCrypt.hashpw(password1, BCrypt.gensalt());
        User user = new User(login, hashedPassword, firstName, lastName, role);
        try {
            if(new UserDao().saveUser(user)) {
                if(role.equals(Constants.STUDENT_ROLE)) {
                    request.setAttribute("successRegestration", true);
                    page = PageManager.getPage("path.page.login");
                    return page;
                } else {
                    request.setAttribute("successRegestration", true);
                    page = PageManager.getPage("path.page.welcomeadmin");
                    return page;
                }
            } else {
                request.setAttribute("errorRegistration", true);
                return page;
            }
        } catch (DaoException e) {
            LOG.error("Error while saving user to database", e);
            request.setAttribute("errorRegistration", true);
            return page;
        }

    }
}
