package com.epam.electives.db.dao;

import com.epam.electives.db.util.ConnectionPool;
import com.epam.electives.entity.Course;
import com.epam.electives.entity.result.CourseResult;
import com.epam.electives.entity.result.StudentResult;
import com.epam.electives.entity.Entity;
import com.epam.electives.entity.result.UniversityResult;
import com.epam.electives.exceptions.DaoException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementation of CourseDao
 */
public class CourseDao implements ICourseDao {

    private static final Logger LOG = Logger.getLogger(CourseDao.class);

    public static final String FIND_ALL_PASSIBLE_COURSES = "select * from courses where courses.name not in (select courses.name from courses " +
            "join course_result on courses.idCourse = course_result.idCourse join users on users.idUser = course_result.idUser where users.login = ?)";
    public static final String FIND_STUDENT_RESULTS = "select course_result.idResult, courses.name, courses.hours, course_result.mark, course_result.feedback from course_result " +
            "join courses on course_result.idCourse = courses.idCourse join users on users.idUser = course_result.idUser where users.idUser = ?;";
    public static final String SUBSCRIBE_COURSE = "insert into course_result (idCourse, idUser) values (?, ?)";
    public static final String UNSUBSCRIBE_COURSE = "delete from course_result where idResult = ?";
    public static final String ADD_COURSE = "insert into courses (name, hours, description) values (?, ?, ?)";
    public static final String ADD_TO_TEACHER_COURSE_TABLE = "insert into teacher_course values (LAST_INSERT_ID(),?)";
    public static final String FIND_TEACHER_COURSES = "select courses.idCourse, courses.name, courses.hours, courses.description  from teacher_course " +
            "join courses on teacher_course.idCourse = courses.idCourse " +
            "join users on teacher_course.idUser = users.idUser where teacher_course.idUser = ?";
    public static final String FIND_COURSE_RESULT = "select users.first_name, users.last_name, course_result.mark, course_result.feedback from course_result " +
            "join users on course_result.idUser = users.idUser " +
            "join courses on course_result.idCourse = courses.idCOurse where course_result.mark <> 0 and courses.idCourse = ?";
    public static final String FIND_FOR_ASSIGN = "select course_result.idResult, users.first_name, users.last_name, course_result.mark, course_result.feedback from course_result " +
            "join users on course_result.idUser = users.idUser " +
            "join courses on course_result.idCourse = courses.idCourse where courses.idCourse = ?";
    public static final String ASSIGN_MARK = "UPDATE course_result SET mark = ?, feedback = ? WHERE idResult = ?";
    public static final String WHOLE_UNIVERSITY_RESULT = "select courses.name, users.first_name, users.last_name, course_result.mark, course_result.feedback from course_result " +
            "join courses on course_result.idCourse = courses.idCourse " +
            "join users on course_result.idUser = users.idUser";
    public static final String FIND_COURSE_BY_NAME = "select * from courses where name = ?";

    /**
     *
     * @param login of user
     * @return ArrayList of possible courses
     * @throws DaoException
     */
    @Override
    public ArrayList findAllPossibleCourses(String login) throws DaoException {

        LOG.info("CourseDao.findAllPossibleCourses()");
        ArrayList<Entity> courses = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = ConnectionPool.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement(FIND_ALL_PASSIBLE_COURSES);
            preparedStatement.setString(1, login);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                courses.add(new Course(result.getInt("idCourse"),result.getString("name"), result.getInt("hours"), result.getString("description")));
            }
        } catch (SQLException e) {
            throw new DaoException("DaoException while CourseDao.findAllPossibleCourses()", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
        return courses;
    }

    /**
     *
     * @param idStudent - id of student
     * @return ArrayList of student results
     * @throws DaoException
     */
    @Override
    public ArrayList findStudentResults(int idStudent) throws DaoException {

        LOG.info("CourseDao.findStudentResults()");
        ArrayList<Entity> studentResults = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = ConnectionPool.getInstance().getConnection();

        try {
            preparedStatement = connection.prepareStatement(FIND_STUDENT_RESULTS);
            preparedStatement.setInt(1, idStudent);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                studentResults.add(new StudentResult(result.getInt("idResult"), result.getString("name"), result.getInt("hours"), result.getInt("mark"), result.getString("feedback")));
            }
        } catch (SQLException e) {
            LOG.error("DaoException while finding student results", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
        return studentResults;
    }

    /**
     *
     * @param idCourse
     * @param idUser
     * @return boolean true/false
     * @throws DaoException
     */
    @Override
    public void subscibeCourse(int idCourse, int idUser) throws DaoException {

        LOG.info("CourseDao.subscibeCourse()");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = ConnectionPool.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement(SUBSCRIBE_COURSE);
            preparedStatement.setInt(1, idCourse);
            preparedStatement.setInt(2, idUser);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("DaoException while subscibing courses", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
    }

    /**
     *
     * @param idResult
     * @throws DaoException
     */
    @Override
    public void unSubscibeCourse(int idResult) throws DaoException {

        LOG.info("CourseDao.unSubscibeCourse()");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = ConnectionPool.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement(UNSUBSCRIBE_COURSE);
            preparedStatement.setInt(1, idResult);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("DaoException while CourseDao.unSubscibeCourse()", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
    }

    /**
     *
     * @param course
     * @param idTeacher
     * @return boolean true/false
     * @throws DaoException
     */
    @Override
    public boolean addCourse(Course course, int idTeacher) throws DaoException {

        LOG.info("CourseDao.addCourse()");
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = ConnectionPool.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement(ADD_COURSE);
            preparedStatement.setString(1, course.getName());
            preparedStatement.setInt(2, course.getHours());
            preparedStatement.setString(3, course.getDescription());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(ADD_TO_TEACHER_COURSE_TABLE);
            preparedStatement.setInt(1,idTeacher);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DaoException("DaoException while CourseDao.addCourse()", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
        return flag;
    }

    /**
     *
     * @param idTeacher
     * @return ArrayList of teacher courses
     */
    @Override
    public ArrayList findAllTeacherCourses(int idTeacher) throws DaoException {

        LOG.info("CourseDao.findAllTeacherCourses()");
        ArrayList<Entity> teacherCourses = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = ConnectionPool.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement(FIND_TEACHER_COURSES);
            preparedStatement.setInt(1, idTeacher);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                teacherCourses.add(new Course(result.getInt("idCourse"),result.getString("name"), result.getInt("hours"),result.getString("description")));
            }
        } catch (SQLException e) {
            throw new DaoException("DaoException while finding teacher courses", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
        return teacherCourses;
    }

    /**
     *
     * @param idCourse
     * @return Array list of course results
     */
    @Override
    public ArrayList findCourseResult(int idCourse) throws DaoException {

        LOG.info("CourseDao.findCourseResult()");
        ArrayList<Entity> studentsResults = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = ConnectionPool.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement(FIND_COURSE_RESULT);
            preparedStatement.setInt(1, idCourse);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                studentsResults.add(new CourseResult(result.getString("first_name"), result.getString("last_name"), result.getInt("mark"), result.getString("feedback")));
            }
        } catch (SQLException e) {
            throw new DaoException("DaoException while CourseDao.findCourseResult()", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
        return  studentsResults;
    }

    /**
     *
     * @param idCourse
     * @return ArrayList of students results
     */
    @Override
    public ArrayList findStudentsResultsOnCourse(int idCourse) throws DaoException {

        LOG.info("CourseDao.findStudentsResultsOnCourse()");
        ArrayList<Entity> forResulted = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = ConnectionPool.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement(FIND_FOR_ASSIGN);
            preparedStatement.setInt(1, idCourse);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                forResulted.add(new CourseResult(result.getInt("idResult"), result.getString("first_name"), result.getString("last_name"),result.getInt("mark"), result.getString("feedback")));
            }
        } catch (SQLException e) {
            throw new DaoException("DaoException while CourseDao.findStudentsResultsOnCourse()", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
        return  forResulted;
    }

    /**
     *
     * @param idResult
     * @param mark
     * @param feedback
     * @return boolean true/false
     * @throws DaoException
     */
    @Override
    public boolean assignMark(int idResult, int mark, String feedback) throws DaoException {

        LOG.info("CourseDao.findStudentsResultsOnCourse()");
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = ConnectionPool.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement(ASSIGN_MARK);
            preparedStatement.setInt(1,mark);
            preparedStatement.setString(2, feedback);
            preparedStatement.setInt(3, idResult);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DaoException("Error while CourseDao.findStudentsResultsOnCourse()", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
        return flag;
    }

    /**
     *
     * @return ArrayList of whole university result
     * @throws DaoException
     */
    @Override
    public ArrayList findWholeResults() throws DaoException {

        LOG.info("CourseDao.findWholeResults()");
        ArrayList<Entity> univesityResults = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = ConnectionPool.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement(WHOLE_UNIVERSITY_RESULT);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                univesityResults.add(new UniversityResult(result.getString("name"), result.getString("first_name"), result.getString("last_name"),result.getInt("mark"), result.getString("feedback")));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while CourseDao.findWholeResults()", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
        return  univesityResults;
    }

    /**
     *
     * @param courseName
     * @return course
     * @throws DaoException
     */
    @Override
    public Course findCourseByName(String courseName) throws DaoException {

        LOG.info("CourseDao.findCourseByName()");
        Course course = null;
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement(FIND_COURSE_BY_NAME);
            preparedStatement.setString(1, courseName);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                course = new Course(result.getString("name"), result.getInt("hours"), result.getString("description"));
            }
        } catch (SQLException e) {
            throw new DaoException("DaoException while finding course in database", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
        return course;
    }
}

