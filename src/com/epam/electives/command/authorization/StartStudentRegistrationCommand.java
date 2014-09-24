package com.epam.electives.command.authorization;

import com.epam.electives.command.ICommand;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * getting student for register page
 */
public class StartStudentRegistrationCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = PageManager.getPage("path.page.studentregistration");
        HttpSession session = request.getSession();
        session.setAttribute(Constants.REGESTRATION_ROLE, Constants.STUDENT_ROLE);
        return page;

    }
}
