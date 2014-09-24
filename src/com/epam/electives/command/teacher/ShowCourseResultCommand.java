package com.epam.electives.command.teacher;

import com.epam.electives.command.ICommand;
import com.epam.electives.db.dao.CourseDao;
import com.epam.electives.entity.Entity;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Results for course
 */
public class ShowCourseResultCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(ShowCourseResultCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String page = PageManager.getPage("path.page.courseresults");
        int idCourse = Integer.parseInt(request.getParameter(Constants.PARAM_COURSE_ID));
        ArrayList<Entity> results = null;
        try {
            results = new CourseDao().findCourseResult(idCourse);
        } catch (DaoException e) {
            LOG.error("Error while finding course result", e);
            page = PageManager.getPage("path.page.error");
            return page;
        }
        if (results.isEmpty() || results == null) {
            request.setAttribute("noGraduatedStudents", true);
            return page;
        }
        request.setAttribute("results", results);
        return page;
    }
}
