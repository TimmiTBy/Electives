package com.epam.electives.command.teacher.graduation;

import com.epam.electives.command.ICommand;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Assign mark
 */
public class AssignMarkCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = PageManager.getPage("path.page.assignmark");
        int idResult = Integer.parseInt(request.getParameter(Constants.PARAM_RESULT_ID));
        request.getSession().setAttribute(Constants.ATTRIB_RESULT_ID, idResult);
        return page;
    }
}
