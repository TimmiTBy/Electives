package com.epam.electives.listener;

import com.epam.electives.util.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Initialisation Log4J
 */
public class Log4jInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String log4jConfigLocation = servletContext.getInitParameter(Constants.PARAM_NAME_LOG_CONFIG_PATH);
        String log4jFilename = servletContext.getRealPath(log4jConfigLocation);
        new DOMConfigurator().doConfigure(log4jFilename, LogManager.getLoggerRepository());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
