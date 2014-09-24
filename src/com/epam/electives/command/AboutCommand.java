package com.epam.electives.command;

import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * About project
 */
public class AboutCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = PageManager.getPage("path.page.about");
        return page;
    }
}
