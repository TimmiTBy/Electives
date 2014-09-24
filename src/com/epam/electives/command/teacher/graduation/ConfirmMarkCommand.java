package com.epam.electives.command.teacher.graduation;

import com.epam.electives.command.ICommand;
import com.epam.electives.command.teacher.util.FindStudentsCourseResultsUtil;
import com.epam.electives.db.dao.CourseDao;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;
import com.epam.electives.util.Validator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Confirm Mark
 */
public class ConfirmMarkCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(ConfirmMarkCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;
        HttpSession session = request.getSession();
        int idResult = (Integer)session.getAttribute(Constants.PARAM_RESULT_ID);
        String feedback = request.getParameter(Constants.PARAM_RESULT_FEEDBACK);
        int mark = Integer.parseInt(request.getParameter(Constants.PARAM_RESULT_MARK));
        if (Validator.validateMarkAndFeedback(mark, feedback.length())) {
            request.setAttribute("errorvalidationdata", true);
            page = PageManager.getPage("path.page.assignmark");
            return page;
        }
        try {
            if (new CourseDao().assignMark(idResult, mark, feedback)) {
                request.setAttribute("successConfirmMark", true);
            };
        } catch (DaoException e) {
            LOG.error("Error while confirming mark", e);
            page = PageManager.getPage("path.page.error");
            return page;
        }
        int idCourse = (Integer)session.getAttribute(Constants.ATTRIB_COURSE_ID);
        return FindStudentsCourseResultsUtil.getStudentsCourseResults(request, idCourse);
    }
}
