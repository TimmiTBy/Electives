package com.epam.electives.command.student;

import com.epam.electives.command.ICommand;
import com.epam.electives.command.student.util.FindStudentResultsUtil;
import com.epam.electives.db.dao.CourseDao;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 *  UnSubscribe from courses
 */
public class UnSubscribeCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(UnSubscribeCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;
        String[] idResult = request.getParameterValues(Constants.PARAM_RESULT_ID);
        if (idResult == null) {
            request.setAttribute("noSelectedcourses", true);
            page = FindStudentResultsUtil.getStudentResult(request);
            return page;
        }
        for (String id : idResult) {
            try {
                new CourseDao().unSubscibeCourse(Integer.parseInt(id));
            } catch (DaoException e) {
                LOG.error("Error while unsubscibe courses", e);
                page = PageManager.getPage("path.page.error");
                return page;
            }
        }
        request.setAttribute("successUnsubscibe", true);
        page = FindStudentResultsUtil.getStudentResult(request);
        return page;
    }
}
