package com.epam.electives.command.student.util;

import com.epam.electives.command.student.FindPossibleCoursesCommand;
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
 * Find possible courses util
 */

public class FindPossibleCoursesUtil {

    private static final Logger LOG = Logger.getLogger(FindPossibleCoursesCommand.class);

    public static String getPossibleCourses(HttpServletRequest request) {

        String page = PageManager.getPage("path.page.possiblecourses");
        HttpSession session = request.getSession();
        String login = String.valueOf(session.getAttribute(Constants.ATTRIB_USER_LOGIN));
        ArrayList<Entity> possibleCourses = null;
        try {
            possibleCourses = new CourseDao().findAllPossibleCourses(login);
        } catch (DaoException e) {
            LOG.error("Error while finding all possible courses");
            page = PageManager.getPage("path.page.error");
            return page;
        }
        if (possibleCourses.isEmpty() || possibleCourses == null) {
            request.setAttribute("noCourses", true);
            return page;
        }
        request.setAttribute("possibleCourses", possibleCourses);
        return page;
    }
}
