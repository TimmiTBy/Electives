package com.epam.electives.command.user;

import com.epam.electives.command.ICommand;
import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * If forgot  password
 */
public class ForgotPasswordCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = PageManager.getPage("path.page.forgotpassword");
        return page;
    }
}
