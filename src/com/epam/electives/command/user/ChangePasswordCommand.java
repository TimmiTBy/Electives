package com.epam.electives.command.user;

import com.epam.electives.command.ICommand;
import com.epam.electives.db.dao.UserDao;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;
import org.mindrot.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * change user password
 */
public class ChangePasswordCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = PageManager.getPage("path.page.personalaccount");
        HttpSession session = request.getSession();
        String password1 = request.getParameter(Constants.PARAM_USER_PASSWORD);
        String password2 = request.getParameter(Constants.PARAM_USER_RE_PASSWORD);
        String login = String.valueOf(session.getAttribute(Constants.ATTRIB_USER_LOGIN));
        if (!password1.equals(password2) || password1 == null) {
            request.setAttribute("passwordError", true);
            return page;
        }
        String hashedPassword = BCrypt.hashpw(password1, BCrypt.gensalt());
        try {
            if (new UserDao().resetPassword(hashedPassword, login)) {
                request.setAttribute("successChange", true);
                return page;
            } else {
                request.setAttribute("error", "");
                return page;
            }
        } catch (DaoException e) {
            request.setAttribute("error", "");
            return page;
        }
    }
}
