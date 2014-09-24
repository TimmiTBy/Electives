package com.epam.electives.command.admin.deleteuser;

import com.epam.electives.command.ICommand;
import com.epam.electives.db.dao.UserDao;
import com.epam.electives.entity.User;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Find user for delete
 */
public class FindUserForDeleteCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(DeleteUserCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String foundLogin = request.getParameter(Constants.PARAM_USER_LOGIN);
        User user = null;
        try {
            user = new UserDao().findUserByLogin(foundLogin);
        } catch (DaoException e) {
            LOG.error("DaoException while find user for delete", e);
            request.setAttribute("error", true);
            page = PageManager.getPage("path.page.finduserfordelete");
            return page;
        }
        if (user == null) {
            request.setAttribute("noUser", true);
            page = PageManager.getPage("path.page.finduserfordelete");
            return page;
        }
        if (user.getUserRole().getIntRole() == Constants.ADMIN_ROLE_INT ||
                user.getUserRole().getIntRole() == Constants.TEACHER_ROLE_INT) {
            request.setAttribute("notDeleteRole", true);
            page = PageManager.getPage("path.page.finduserfordelete");
            return page;
        }
        String foundFirstName = user.getFirstName();
        String foundLastName = user.getLastName();
        int foundIduser = user.getId();
        request.getSession().setAttribute(Constants.ATTRIB_FOUND_USER_ID, foundIduser);
        request.setAttribute(Constants.ATTRIB_FOUND_USER_FIRST_NAME, foundFirstName);
        request.setAttribute(Constants.ATTRIB_FOUND_USER_LAST_NAME, foundLastName);
        page = PageManager.getPage("path.page.deleteuser");
        return page;
    }
}
