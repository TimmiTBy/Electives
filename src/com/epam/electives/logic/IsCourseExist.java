package com.epam.electives.logic;

import com.epam.electives.db.dao.CourseDao;
import com.epam.electives.entity.Course;
import com.epam.electives.exceptions.DaoException;

/**
 * Check if course exist
 */
public class IsCourseExist {

   public static boolean checkCourseExist(String courseName) throws DaoException {
       Course course = new CourseDao().findCourseByName(courseName);
       return course != null;
    }

}
