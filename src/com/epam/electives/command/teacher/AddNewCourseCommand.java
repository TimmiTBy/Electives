package com.epam.electives.command.teacher;

import com.epam.electives.command.ICommand;
import com.epam.electives.db.dao.CourseDao;
import com.epam.electives.entity.Course;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.logic.IsCourseExist;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;
import com.epam.electives.util.Validator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Add New Course
 */
public class AddNewCourseCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(AddNewCourseCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String page = PageManager.getPage("path.page.addcourse");
        String courseName = String.valueOf(request.getParameter(Constants.PARAM_COURSE_NAME));
        int hours = Integer.valueOf(request.getParameter(Constants.PARAM_COURSE_HOURS));
        String description = String.valueOf(request.getParameter(Constants.PARAM_COURSE_DESCRIPTION));
        HttpSession session = request.getSession();
        int idTeacher = (Integer) session.getAttribute(Constants.ATTRIB_USER_ID);
        //Validation course data
        if (Validator.validateNewCourseData(hours, description.length())) {
            request.setAttribute("courseDataRegex", true);
            return page;
        }
        //Check if course exist
        try {
            if (IsCourseExist.checkCourseExist(courseName)) {
                request.setAttribute("courseExist", true);
                return page;
            }
        } catch (DaoException e) {
            LOG.error("Error while checking new course exist", e);
            request.setAttribute("errorAddCourse", true);
            return page;
        }
        //Add new course
        try {
            if (new CourseDao().addCourse(new Course(courseName, hours, description), idTeacher)) {
                request.setAttribute("successadd", true);
            } else {
                request.setAttribute("errorAddCourse", true);
            }
        } catch (DaoException e) {
            LOG.error("Error while adding new course", e);
            request.setAttribute("errorAddCourse", true);
            return page;
        }
        return page;
    }
}
