package com.epam.electives.command.teacher;

import com.epam.electives.command.ICommand;
import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Start adding new course
 */
public class StartAddingNewCourseCommand implements ICommand{

    @Override
    public String execute(HttpServletRequest request) {

        String page = PageManager.getPage("path.page.addcourse");
        return page;
    }
}
