package com.epam.electives.controller;

import com.epam.electives.command.ICommand;
import com.epam.electives.command.factory.ActionFactory;
import com.epam.electives.util.PageManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(Controller.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionFactory actionFactory = new ActionFactory();
        ICommand command = actionFactory.defineCommand(request);
        String page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = PageManager.getPage("path.page.index");
            response.sendRedirect(request.getContextPath() + page);
        }

    }

}
