package com.epam.electives.command.teacher.graduation;

import com.epam.electives.command.ICommand;
import com.epam.electives.command.teacher.util.FindTeacherCoursesUtil;
import com.epam.electives.util.PageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Start graduation
 */
public class FindGraduationCourseList implements ICommand {

    private static final Logger LOG = Logger.getLogger(FindGraduationCourseList.class);

    @Override
    public String execute(HttpServletRequest request) {

        String page = PageManager.getPage("path.page.graduatecourses");
        return FindTeacherCoursesUtil.getTeacherCourses(page, request);
    }
}
