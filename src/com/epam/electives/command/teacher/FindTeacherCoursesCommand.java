package com.epam.electives.command.teacher;

import com.epam.electives.command.ICommand;
import com.epam.electives.command.teacher.util.FindTeacherCoursesUtil;
import com.epam.electives.util.PageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Find teacher courses
 */
public class FindTeacherCoursesCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(FindTeacherCoursesCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String page = PageManager.getPage("path.page.teachercourses");
        return FindTeacherCoursesUtil.getTeacherCourses(page, request);
    }
}
