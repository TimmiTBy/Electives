package com.epam.electives.command;

import javax.servlet.http.HttpServletRequest;

public interface ICommand {

    String execute(HttpServletRequest request);
}
