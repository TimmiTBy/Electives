package com.epam.electives.command.admin.resetuserpass;

import com.epam.electives.command.ICommand;
import com.epam.electives.db.dao.UserDao;
import com.epam.electives.entity.User;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 *  Find user for reset pass
 */
public class FindUserForResetPassCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(FindUserForResetPassCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;
        String foundLogin = request.getParameter(Constants.PARAM_USER_LOGIN);
        request.getSession().setAttribute(Constants.ATTRIB_FOUND_USER_LOGIN, foundLogin);
        User user = null;
        try {
            user = new UserDao().findUserByLogin(foundLogin);
        } catch (DaoException e) {
            LOG.error("Error while finding user for reset pass", e);
            request.setAttribute("error", true);
            page = PageManager.getPage("path.page.finduserforresetpass");
            return page;
        }
        if (user == null) {
            request.setAttribute("noUser", true);
            page = PageManager.getPage("path.page.finduserforresetpass");
            return page;
        }
        String foundFirstName = user.getFirstName();
        String foundLastName = user.getLastName();
        request.getSession().setAttribute(Constants.ATTRIB_FOUND_USER_FIRST_NAME, foundFirstName);
        request.getSession().setAttribute(Constants.ATTRIB_FOUND_USER_LAST_NAME, foundLastName);
        page = PageManager.getPage("path.page.userdata");
        return page;
    }
}
