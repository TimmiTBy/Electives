package com.epam.electives.command;

import com.epam.electives.command.admin.resetuserpass.FindUserForResetPassCommand;
import com.epam.electives.command.admin.resetuserpass.ResetPasswordCommand;
import com.epam.electives.command.admin.resetuserpass.StartResetPassCommand;
import com.epam.electives.command.admin.ShowUniversityResultCommand;
import com.epam.electives.command.admin.deleteuser.DeleteUserCommand;
import com.epam.electives.command.admin.deleteuser.FindUserForDeleteCommand;
import com.epam.electives.command.admin.deleteuser.StartDeleteCommand;
import com.epam.electives.command.authorization.*;
import com.epam.electives.command.authorization.RegistrationCommand;
import com.epam.electives.command.authorization.StartStudentRegistrationCommand;
import com.epam.electives.command.admin.StartTeacherRegistrationCommand;
import com.epam.electives.command.student.FindPossibleCoursesCommand;
import com.epam.electives.command.student.FindStudentResultsCommand;
import com.epam.electives.command.student.SubscribeCommand;
import com.epam.electives.command.student.UnSubscribeCommand;
import com.epam.electives.command.teacher.*;
import com.epam.electives.command.teacher.graduation.AssignMarkCommand;
import com.epam.electives.command.teacher.graduation.ConfirmMarkCommand;
import com.epam.electives.command.teacher.graduation.FindGraduationCourseList;
import com.epam.electives.command.teacher.graduation.GraduateStudentsCommand;
import com.epam.electives.command.user.*;

/**
 *  All command types
 */
public enum CommandType {

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },

    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },

    FORGOT_PASSWORD {
        {
            this.command = new ForgotPasswordCommand();
        }
    },

    ABOUT {
        {
            this.command = new AboutCommand();
        }
    },

    START_STUDENT_REGISTRATION {
        {
            this.command = new StartStudentRegistrationCommand();
        }
    },

    START_TEACHER_REGISTRATION {
        {
            this.command = new StartTeacherRegistrationCommand();
        }
    },

    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    },

    CHANGE_LANGUAGE {
        {
            this.command = new ChangeLanguageCommand();
        }
    },


    PERSONAL_ACCOUNT {
        {
            this.command = new PersonalAccountCommand();
        }
    },

    BACK_TO_LOGIN {
        {
            this.command = new BackToLoginCommand();
        }
    },

    BACK_TO_WELCOME {
        {
            this.command = new BackToWelcomeCommand();

        }
    },

    CHANGE_PASSWORD {
        {
            this.command = new ChangePasswordCommand();
        }
    },

    FIND_STUDENT_COURSES {
        {
            this.command = new FindStudentResultsCommand();
        }
    },

    FIND_POSSIBLE_COURSES {
        {
            this.command = new FindPossibleCoursesCommand();
        }
    },

    SUBSCRIBE {
        {
            this.command = new SubscribeCommand();
        }
    },


    UNSUBSCRIBE {
        {
            this.command = new UnSubscribeCommand();
        }
    },

    START_ADD {
        {
            this.command = new StartAddingNewCourseCommand();
        }
    },


    ADD_COURSE {
        {
            this.command = new AddNewCourseCommand();
        }
    },

    FIND_TEACHER_COURSES {
        {
            this.command = new FindTeacherCoursesCommand();
        }
    },
    FIND_GRADUATION_COURSE_LIST {
        {
            this.command = new FindGraduationCourseList();
        }
    },


    GRADUATE_STUDENTS {
        {
            this.command = new GraduateStudentsCommand();
        }
    },

    SHOW_RESULT {
        {
            this.command = new ShowCourseResultCommand();
        }
    },

    ASSIGN_MARK {
        {
            this.command = new AssignMarkCommand();
        }
    },

    CONFIRM_MARK {
        {
            this.command = new ConfirmMarkCommand();
        }
    },

    WHOLE_UNIVERSITY_RESULTS {
        {
            this.command = new ShowUniversityResultCommand();
        }
    },

    START_RESET_PASS {
        {
            this.command = new StartResetPassCommand();
        }
    },

    START_DELETE_USER {
        {
            this.command = new StartDeleteCommand();
        }
    },

    FIND_USER_FOR_CHANGE_PASS {
        {
            this.command = new FindUserForResetPassCommand();
        }
    },

    FIND_USER_FOR_DELETE{
        {
            this.command = new FindUserForDeleteCommand();
        }
    },

    RESET_PASSWORD {
        {
            this.command = new ResetPasswordCommand();
        }
    },

    DELETE_USER {
        {
            this.command = new DeleteUserCommand();
        }
    }








    ;
    ICommand command;

    public ICommand getCommand() {
        return command;
    }
}
