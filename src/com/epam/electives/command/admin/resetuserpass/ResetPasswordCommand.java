package com.epam.electives.command.admin.resetuserpass;

import com.epam.electives.command.ICommand;
import com.epam.electives.db.dao.UserDao;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;
import com.epam.electives.util.Validator;
import org.apache.log4j.Logger;
import org.mindrot.BCrypt;

import javax.servlet.http.HttpServletRequest;

/**
 * Reset password command
 */
public class ResetPasswordCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(ResetPasswordCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;
        String password1 = request.getParameter(Constants.PARAM_USER_PASSWORD);
        String password2 = request.getParameter(Constants.PARAM_USER_RE_PASSWORD);
        //Server side check
        if (password1 == null || password2 == null) {
            request.setAttribute("emptyFields", true);
            page = PageManager.getPage("path.page.userdata");
            return page;
        }
        if (Validator.passwordValidation(password1)) {
            request.setAttribute("regexError", true);
            page = PageManager.getPage("path.page.userdata");
            return page;
        }
        if (!password1.equals(password2)|| password1 == null) {
            request.setAttribute("passwordError", true);
            page = PageManager.getPage("path.page.userdata");
            return page;
        }
        String foundLogin = String.valueOf(request.getSession().getAttribute("foundLogin"));
        String hashedPassword = BCrypt.hashpw(password1, BCrypt.gensalt());
        try {
            if (new UserDao().resetPassword(hashedPassword, foundLogin)) {
                request.setAttribute("successChange", true);
                page = PageManager.getPage("path.page.finduserforresetpass");
                return page;
            } else {
                request.setAttribute("error", true);
                page = PageManager.getPage("path.page.userdata");
                return page;
            }
        } catch (DaoException e) {
            LOG.error("Error while reseting password", e);
            request.setAttribute("error", true);
            page = PageManager.getPage("path.page.userdata");
            return page;
        }
    }
}
