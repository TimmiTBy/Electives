package com.epam.electives.command.admin.deleteuser;

import com.epam.electives.command.ICommand;
import com.epam.electives.util.PageManager;

import javax.servlet.http.HttpServletRequest;

/**
 *  Start delete
 */
public class StartDeleteCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {
        return PageManager.getPage("path.page.finduserfordelete");
    }
}
