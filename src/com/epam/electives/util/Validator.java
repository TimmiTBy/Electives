package com.epam.electives.util;

import java.util.regex.Pattern;

/**
 * Server validation information
 */
public class Validator {

    public static final String LOGIN_REGEX = "^[a-z0-9]{3,15}$";
    public static final String PASSWORD_REGEX = "^[a-z0-9]{6,16}$";
    public static final int MIN_COURSE_HOURS = 20;
    public static final int MIN_LENGHT_DESCRIPTION = 10;
    public static final int MIN_FEEDBACK_LENGHT = 3;
    public static final int MIN_MARK = 1;
    public static final int MAX_MARK = 10;

    /**
     *
     * @param login
     * @param password
     * @return true problems with entered data
     */
    public static boolean validateRegestrationData(String login, String password) {
        return loginValidation(login) || passwordValidation(password);
    }

    /**
     *
     * @param courseHours
     * @param descriptionLenght
     * @return true if problems with course data
     */
    public static boolean validateNewCourseData(int courseHours, int descriptionLenght) {
        return courseHoursValidator(courseHours) || courseDescriptionValidator(descriptionLenght);
    }

    /**
     *
     * @param mark
     * @param feedback
     * @return true if problems with mark or feedback
     */
    public static boolean validateMarkAndFeedback(int mark, int feedback) {
        return (markValidator(mark)|| feedbackLenghtValidator(feedback));
    }

    /**
     *
     * @param login
     * @return true if login doesnt match pattern
     */
    private static boolean loginValidation(String login) {
        return !Pattern.matches(LOGIN_REGEX, login);
    }

    /**
     *
     * @param password
     * @return true if password doesnt match pattern
     */
    public static boolean passwordValidation(String password) {
        return !Pattern.matches(PASSWORD_REGEX, password);
    }

    /**
     *
     * @param courseHours
     * @return true if hourse < MIN_COURSE_HOURS
     */
    private static boolean courseHoursValidator(int courseHours) {
        return (courseHours < MIN_COURSE_HOURS);
    }

    /**
     *
     * @param courseDescriptionLenght
     * @return thue if courseDescriptionLenght < MIN_LENGHT_DESCRIPTION
     */
    private static boolean courseDescriptionValidator(int courseDescriptionLenght) {
        return (courseDescriptionLenght < MIN_LENGHT_DESCRIPTION);
    }

    /**
     *
     * @param mark
     * @return true if mark < MIN_MARK || mark > MAX_MARK
     */
    private static boolean markValidator(int mark) {
        return (mark < MIN_MARK || mark  > MAX_MARK);
    }

    /**
     *
     * @param feedbackLenght
     * @return thue if feedbackLenght < MIN_FEEDBACK_LENGHT
     */
    private static boolean feedbackLenghtValidator(int feedbackLenght ) {
        return (feedbackLenght < MIN_FEEDBACK_LENGHT);
    }
}
