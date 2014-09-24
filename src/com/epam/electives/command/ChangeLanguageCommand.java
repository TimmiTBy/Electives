package com.epam.electives.command;

import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Change language
 */
public class ChangeLanguageCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String language = request.getParameter(Constants.PARAM_LANGUAGE);
        Locale locale = new Locale(language);
        session.setAttribute("locale", locale);
        String page = PageManager.getPage("path.page.login");
        return page;
    }
}
