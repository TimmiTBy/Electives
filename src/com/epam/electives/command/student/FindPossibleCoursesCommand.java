package com.epam.electives.command.student;

import com.epam.electives.command.ICommand;
import com.epam.electives.command.student.util.FindPossibleCoursesUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Find all possible courses
 */
public class FindPossibleCoursesCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(FindPossibleCoursesCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        return FindPossibleCoursesUtil.getPossibleCourses(request);
    }
}
