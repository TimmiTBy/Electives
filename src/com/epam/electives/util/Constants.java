package com.epam.electives.util;

public class Constants {

    /* param constants*/
                        /*user*/
    public static final String PARAM_USER_LOGIN = "login";
    public static final String PARAM_USER_FIRST_NAME = "firstname";
    public static final String PARAM_USER_LAST_NAME = "lastname";
    public static final String PARAM_USER_PASSWORD = "password";
    public static final String PARAM_USER_RE_PASSWORD = "re-password";
    public static final String PARAM_USER_ROLE = "userRole";

                        /*course*/
    public static final String PARAM_COURSE_NAME = "name";
    public static final String PARAM_COURSE_HOURS = "hours";
    public static final String PARAM_COURSE_DESCRIPTION = "description";
    public static final String PARAM_COURSE_ID = "id";

                        /*result*/
    public static final String PARAM_RESULT_ID = "idResult";
    public static final String PARAM_RESULT_FEEDBACK = "feedback";
    public static final String PARAM_RESULT_MARK = "mark";


    /* attrib constants*/
                     /*user*/
    public static final String ATTRIB_USER_LOGIN = "userLogin";
    public static final String ATTRIB_USER_ROLE = "userRole";
    public static final String ATTRIB_USER_ID = "userId";
    public static final String ATTRIB_USER_FIRST_NAME = "userFirstName";
    public static final String ATTRIB_USER_LAST_NAME = "userLastName";

                    /*course*/
    public static final String ATTRIB_COURSE_NAME = "courseName";
    public static final String ATTRIB_COURSE_ID = "idCourse";

                    /*result*/
    public static final String ATTRIB_RESULT_ID = "idResult";

            /*for delete user and reset password*/
    public static final String ATTRIB_FOUND_USER_ID = "foundIduser";
    public static final String ATTRIB_FOUND_USER_FIRST_NAME = "foundFirstName";
    public static final String ATTRIB_FOUND_USER_LAST_NAME = "foundLastName";
    public static final String ATTRIB_FOUND_USER_LOGIN = "foundLogin";


    /*other constatns*/
    public static final String REGESTRATION_ROLE = "regRole";
    public static final String STUDENT_ROLE = "STUDENT";
    public static final String TEACHER_ROLE = "TEACHER";
    public static final int ADMIN_ROLE_INT = 3;
    public static final int TEACHER_ROLE_INT = 2;
    public static final int STUDENT_ROLE_INT = 1;
    public static final int GUEST_ROLE_INT = 0;
    public static final String PARAM_LANGUAGE = "language";
    public static final String PARAM_NAME_LOG_CONFIG_PATH = "log4jConfigLocation";

}
