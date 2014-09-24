package com.epam.electives.command.student;

import com.epam.electives.command.ICommand;
import com.epam.electives.command.student.util.FindStudentResultsUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Find student result
 */
public class FindStudentResultsCommand implements ICommand{

    private static final Logger LOG = Logger.getLogger(FindPossibleCoursesCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        return FindStudentResultsUtil.getStudentResult(request);
    }
}
