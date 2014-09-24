package com.epam.electives.db.util;


import com.epam.electives.exceptions.DaoException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * Connection pool for database
 *
 */
public class ConnectionPool {

    private static final Logger LOG = Logger.getLogger(ConnectionPool.class);

    /**
     * fields for database settings and pool
     */
    private final static String URL = DBPropertyManager.getDBProperty("db.url");
    private final static String LOGIN = DBPropertyManager.getDBProperty("db.login");
    private final static String PASSWORD = DBPropertyManager.getDBProperty("db.password");
    private final static int POOL_SIZE = Integer.parseInt(DBPropertyManager.getDBProperty("db.poolsize"));
    private final static int WAIT_TIME = Integer.parseInt(DBPropertyManager.getDBProperty("db.waittime"));
    private ArrayBlockingQueue<Connection> connectionQueue;

    private ConnectionPool() {
        LOG.debug("ConnectionPool()");
        try {
            connectionQueue = new ArrayBlockingQueue<Connection>(POOL_SIZE);
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                connectionQueue.put(connection);
            }
        } catch (SQLException e) {
            LOG.fatal("Couldnt establish connection to database while creating pool" + e);
        } catch (InterruptedException e) {
            LOG.fatal("Connection pool exception" + e);
        }
    }

    /**
     *
     * @return Instanse of Connection pool
     */
    public static ConnectionPool getInstance() {
        LOG.debug("ConnectionPool.getInstance()");
        return ConnectionPool.ConnectionPoolInstanceHolder.instance;
    }

    /**
     *
     * @return connection from pool
     * @throws DaoException
     */
    public Connection getConnection() throws DaoException {
        LOG.debug("ConnectionPool.getConnection()");
        Connection connection = null;
        try {
            connection = connectionQueue.poll(WAIT_TIME, TimeUnit.MICROSECONDS);
            if (connection == null) {
                throw new DaoException("There no avaible connections in pool");
            }
        } catch (InterruptedException e) {
            LOG.fatal("Couldn't establish connection to database");
        }
        return connection;
    }

    /**
     *
     * @param connection
     * return connection to pool
     */
    public void putConnection(Connection connection) {
        LOG.debug("ConnectionPool.putConnection()");
        try {
            if (connection != null) {
                connectionQueue.put(connection);
            }
        } catch (InterruptedException e) {
            LOG.error("Error while returning connection to pool" + e);
        }

    }

    /**
     * Inner class
     */
    private static class ConnectionPoolInstanceHolder {

        private final static ConnectionPool instance = new ConnectionPool();

        private ConnectionPoolInstanceHolder() {

        }

    }
}
