package com.epam.electives.command.student.util;

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
 * Find student result util
 */
public class FindStudentResultsUtil {

    private static final Logger LOG = Logger.getLogger(FindStudentResultsUtil.class);

    public static String getStudentResult(HttpServletRequest request) {

        String page = PageManager.getPage("path.page.studentresults");
        HttpSession session = request.getSession();
        int idStudent = (Integer) session.getAttribute(Constants.ATTRIB_USER_ID);
        ArrayList<Entity> studentResults = null;
        try {
            studentResults = new CourseDao().findStudentResults(idStudent);
        } catch (DaoException e) {
            LOG.error("Error while finding student results", e);
            page = PageManager.getPage("path.page.error");
            return page;
        }
        request.setAttribute("studentResult", studentResults);
        return page;
    }

}
