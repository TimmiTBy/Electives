package com.epam.electives.command.teacher.util;

import com.epam.electives.db.dao.CourseDao;
import com.epam.electives.entity.Entity;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Find teacher courses
 */
public class FindTeacherCoursesUtil {

    private static final Logger LOG = Logger.getLogger(FindTeacherCoursesUtil.class);

    public static String getTeacherCourses(String page, HttpServletRequest request) {

        HttpSession session = request.getSession();
        int idTeacher = (Integer)session.getAttribute(Constants.ATTRIB_USER_ID);
        ArrayList<Entity> teacherCourses = null;
        try {
            teacherCourses = new CourseDao().findAllTeacherCourses(idTeacher);
        } catch (DaoException e) {
            LOG.error("Error while finding all teacher courses", e);
            page = PageManager.getPage("path.page.error");
            return page;
        }
        if(teacherCourses.isEmpty() || teacherCourses == null) {
            request.setAttribute("noCourses", true);
            return page;
        }
        request.setAttribute("teacherCourses", teacherCourses);
        return page;
    }
}
