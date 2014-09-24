package com.epam.electives.db.dao;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;

public interface IDao {

    static final Logger LOG = Logger.getLogger(IDao.class);

    /**
     *
     * @param statement
     * close statement
     */
    static void close(Statement statement) {
        if(statement !=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOG.error("Error in close statement", e);
            }
        }

    }
}
