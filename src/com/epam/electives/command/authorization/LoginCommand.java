package com.epam.electives.command.authorization;

import com.epam.electives.command.ICommand;
import com.epam.electives.db.dao.UserDao;
import com.epam.electives.entity.User;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;
import com.epam.electives.logic.LoginLogic;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(LoginCommand.class);

    /**
     *
     * @param request
     * @return welcome page for admin, user or teacher
     * warring message if login/password not correct
     */
    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String page = null;
        String login = request.getParameter(Constants.PARAM_USER_LOGIN);
        String password = request.getParameter(Constants.PARAM_USER_PASSWORD);
        User user = null;
        try {
            user = new UserDao().findUserByLogin(login);
        } catch (DaoException e) {
            LOG.error("Error while finding user in database "+ e);
            return PageManager.getPage("path.page.login");
        }
        if(user == null) {//if no user in DB
            request.setAttribute("errorLoginPassMessage", true);
            page = PageManager.getPage("path.page.login");
            return page;
        }
        if (user != null && LoginLogic.checkLogin(password, user.getPassword())) {
            session.setAttribute(Constants.ATTRIB_USER_ID, user.getId());
            session.setAttribute(Constants.ATTRIB_USER_LOGIN, user.getLogin());
            session.setAttribute(Constants.ATTRIB_USER_FIRST_NAME, user.getFirstName());
            session.setAttribute(Constants.ATTRIB_USER_LAST_NAME, user.getLastName());
            session.setAttribute(Constants.ATTRIB_USER_ROLE, user.getUserRole());
            page = user.getUserRole().getWelcomePage();
        } else {
            request.setAttribute("errorLoginPassMessage", true);
            page = PageManager.getPage("path.page.login");
        }
        return page;
    }
}
