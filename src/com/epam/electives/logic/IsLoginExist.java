package com.epam.electives.logic;

import com.epam.electives.db.dao.UserDao;
import com.epam.electives.entity.User;
import com.epam.electives.exceptions.DaoException;
import org.apache.log4j.Logger;

/**
 * Check is login exit
 */
public class IsLoginExist {
    /**
     *
     * @param login
     * @return true if login already exist
     * @throws DaoException
     */
    private static final Logger LOG = Logger.getLogger(IsLoginExist.class);

    public static boolean checkLoginExist(String login) throws DaoException {
        User user = new UserDao().findUserByLogin(login);
        return user != null;
    }

}
