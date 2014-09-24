package com.epam.electives.db.dao;

import com.epam.electives.entity.Course;
import com.epam.electives.exceptions.DaoException;

import java.util.ArrayList;

public interface ICourseDao extends IDao {
    /**
     *
     * @param login
     * @return
     */
    ArrayList findAllPossibleCourses(String login) throws DaoException;

    /**
     *
     * @param idStudent
     * @return
     */
    ArrayList findStudentResults(int idStudent) throws DaoException;

    /**
     *
     * @param idUser
     * @param idCourse
     * @return
     */
    void subscibeCourse(int idUser, int idCourse) throws DaoException;

    /**
     *
     * @param idResult
     * @return
     */
    void unSubscibeCourse(int idResult) throws DaoException;

    /**
     *
     * @param course
     * @param idTeacher
     * @return
     */
    boolean addCourse(Course course, int idTeacher) throws DaoException;

    /**
     *
     * @param idTeacher
     * @return
     */
    ArrayList findAllTeacherCourses(int idTeacher) throws DaoException;

    /**
     *
     * @param idCourse
     * @return
     */
    ArrayList findCourseResult(int idCourse) throws DaoException;

    /**
     *
     * @param idCourse
     * @return
     */
    ArrayList findStudentsResultsOnCourse(int idCourse) throws DaoException;

    /**
     *
     * @param idResult
     * @param mark
     * @param feedback
     * @return
     */
    boolean assignMark(int idResult, int mark, String feedback) throws DaoException;

    /**
     *
     * @return
     */
    ArrayList findWholeResults() throws DaoException;

    /**
     *
     * @param courseName
     * @return
     */
    Course findCourseByName(String courseName) throws DaoException;

}
