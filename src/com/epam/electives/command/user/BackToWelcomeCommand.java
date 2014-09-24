package com.epam.electives.command.user;

import com.epam.electives.command.ICommand;
import com.epam.electives.entity.UserRole;
import com.epam.electives.util.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * Back to welcome
 */
public class BackToWelcomeCommand implements ICommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String role = String.valueOf(request.getSession().getAttribute(Constants.ATTRIB_USER_ROLE));
        page = UserRole.valueOf(role).getWelcomePage();
        return page;
    }
}
