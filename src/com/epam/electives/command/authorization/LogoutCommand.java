package com.epam.electives.command.authorization;

import com.epam.electives.command.ICommand;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *  Logout user
 */
public class LogoutCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = PageManager.getPage("path.page.login");
        HttpSession session = request.getSession();
        session.invalidate();
        return page;
    }
}
