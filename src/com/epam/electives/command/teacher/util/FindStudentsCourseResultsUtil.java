package com.epam.electives.command.teacher.util;

import com.epam.electives.db.dao.CourseDao;
import com.epam.electives.entity.Entity;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.PageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class FindStudentsCourseResultsUtil {

    private static final Logger LOG = Logger.getLogger(FindTeacherCoursesUtil.class);

    public static String getStudentsCourseResults(HttpServletRequest request, int idCourse) {

        String page = PageManager.getPage("path.page.graduatestudents");

        ArrayList<Entity> studentsCourseResults = null;
        try {
            studentsCourseResults = new CourseDao().findStudentsResultsOnCourse(idCourse);
        } catch (DaoException e) {
            LOG.error("Error while finding students results on course", e);
            page = PageManager.getPage("path.page.error");
            return page;
        }
        if (studentsCourseResults.isEmpty() || studentsCourseResults == null) {
            request.setAttribute("noStudentsToGraduate", true);
            return page;
        }
        request.setAttribute("studentsCourseResults", studentsCourseResults);
        return page;
    }
}
