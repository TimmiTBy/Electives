package com.epam.electives.command;

import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Empty command
 */
public class EmptyCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = PageManager.getPage("path.page.index");
        return page;

    }
}
