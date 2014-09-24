package com.epam.electives.command.teacher.graduation;

import com.epam.electives.command.ICommand;
import com.epam.electives.command.teacher.util.FindStudentsCourseResultsUtil;
import com.epam.electives.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Graduate students
 */
public class GraduateStudentsCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(FindGraduationCourseList.class);
    
    @Override
    public String execute(HttpServletRequest request) {

        String courseName = request.getParameter(Constants.PARAM_COURSE_NAME);
        int idCourse = Integer.parseInt(request.getParameter(Constants.PARAM_COURSE_ID));
        HttpSession session = request.getSession();
        session.setAttribute(Constants.ATTRIB_COURSE_NAME, courseName);
        session.setAttribute(Constants.ATTRIB_COURSE_ID, idCourse);
        return FindStudentsCourseResultsUtil.getStudentsCourseResults(request, idCourse);
    }
}
