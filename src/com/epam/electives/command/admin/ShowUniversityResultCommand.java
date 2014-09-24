package com.epam.electives.command.admin;

import com.epam.electives.command.ICommand;
import com.epam.electives.db.dao.CourseDao;
import com.epam.electives.exceptions.DaoException;
import com.epam.electives.util.PageManager;
import com.epam.electives.util.sort.SortByCourseName;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Show total university results
 */
public class ShowUniversityResultCommand implements ICommand {

    private static final Logger LOG = Logger.getLogger(ShowUniversityResultCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = PageManager.getPage("path.page.universityresults");
        ArrayList universityResults = null;
        try {
            universityResults = new CourseDao().findWholeResults();
        } catch (DaoException e) {
            LOG.error("Error while finding all university results", e);
            page = PageManager.getPage("path.page.error");
            return page;
        }
        if (universityResults.isEmpty() || universityResults == null) {
            request.setAttribute("noResults", true);
            return page;
        }
        Collections.sort(universityResults, new SortByCourseName());
        request.setAttribute("universityResults", universityResults);
        return page;
    }
}
