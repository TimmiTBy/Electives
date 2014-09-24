package com.epam.electives.command.factory;

import com.epam.electives.command.CommandType;
import com.epam.electives.command.EmptyCommand;
import com.epam.electives.command.ICommand;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    private static final Logger LOG = Logger.getLogger(ActionFactory.class);

    public ICommand defineCommand(HttpServletRequest request) {

        String action = request.getParameter("command");
        ICommand command = new EmptyCommand();
        if (action == null || action.isEmpty()) {
            return command;
        }
        CommandType commandType = CommandType.valueOf(action.toUpperCase());
        command =  commandType.getCommand();
        return command;
    }
}
