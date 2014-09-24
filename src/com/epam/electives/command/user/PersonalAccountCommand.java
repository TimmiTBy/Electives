package com.epam.electives.command.user;

import com.epam.electives.command.ICommand;
import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Personal account
 */
public class PersonalAccountCommand implements ICommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        page = PageManager.getPage("path.page.personalaccount");
        return page;
    }
}
