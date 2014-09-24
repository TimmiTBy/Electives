package com.epam.electives.command.admin.resetuserpass;

import com.epam.electives.command.ICommand;
import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Start reset password
 */
public class StartResetPassCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        page = PageManager.getPage("path.page.finduserforresetpass");
        return page;
    }
}
