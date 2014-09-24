package com.epam.electives.command.admin;

import com.epam.electives.command.ICommand;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * getting admin to teacher register page
 */
public class StartTeacherRegistrationCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = PageManager.getPage("path.page.teacherregistration");
        HttpSession session = request.getSession();
        session.setAttribute(Constants.REGESTRATION_ROLE, Constants.TEACHER_ROLE);
        return page;
    }
}
