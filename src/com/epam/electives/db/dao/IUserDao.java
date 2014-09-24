package com.epam.electives.db.dao;

import com.epam.electives.entity.User;
import com.epam.electives.exceptions.DaoException;

public interface IUserDao extends IDao {
    /**
     *
     * @param login
     * @return
     */
    User findUserByLogin(String login) throws DaoException;

    /**
     *
     * @param user
     * @return
     */
    boolean saveUser(User user) throws DaoException;

    /**
     *
     * @param newPassword
     * @param login
     * @return
     */
    boolean resetPassword(String newPassword, String login) throws DaoException;

    /**
     *
     * @param idUser
     * @return
     */
    boolean deleteUser(int idUser) throws DaoException;

}
