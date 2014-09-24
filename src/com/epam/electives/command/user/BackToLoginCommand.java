package com.epam.electives.command.user;

import com.epam.electives.command.ICommand;
import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Back to login
 */
public class BackToLoginCommand implements ICommand{

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        String page = PageManager.getPage("path.page.login");
        return page;
    }
}
