package com.epam.electives.command.student;

import com.epam.electives.command.ICommand;
import com.epam.electives.command.student.util.FindPossibleCoursesUtil;
import com.epam.electives.db.dao.CourseDao;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Subscribe for new courses
 */
public class SubscribeCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(SubscribeCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;
        String[] idCourse = request.getParameterValues(Constants.PARAM_COURSE_ID);
        if(idCourse == null) {
            request.setAttribute("noSelectedcourses", true);
            page = FindPossibleCoursesUtil.getPossibleCourses(request);
            return page;
        }
        for (String id : idCourse) {
            try {
                HttpSession session = request.getSession();
                String idUser = String.valueOf(session.getAttribute("userId"));
                new CourseDao().subscibeCourse(Integer.valueOf(id), Integer.valueOf(idUser));
            } catch (DaoException e) {
                LOG.error("Error while subscibing to courses", e);
                page = PageManager.getPage("path.page.error");
                return page;
            }
        }
        request.setAttribute("successSubscibe", true);
        page = FindPossibleCoursesUtil.getPossibleCourses(request);
        return page;
    }
}
