package com.epam.electives.command.admin.deleteuser;

import com.epam.electives.command.ICommand;
import com.epam.electives.db.dao.UserDao;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.PageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Delete User
 */
public class DeleteUserCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(DeleteUserCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;
        int foundIduser = (Integer)request.getSession().getAttribute("foundIduser");
        try {
            if (new UserDao().deleteUser(foundIduser)) {
                request.setAttribute("successDelete", true);
                page = PageManager.getPage("path.page.finduserfordelete");
                return page;
            } else  {
                request.setAttribute("nouserid", true);
                page = PageManager.getPage("path.page.deleteuser");
                return  page;
            }
        } catch (DaoException e) {
            LOG.error("DaoException while delete user", e);
            page = PageManager.getPage("path.page.error");
            return page;
        }
    }
}
