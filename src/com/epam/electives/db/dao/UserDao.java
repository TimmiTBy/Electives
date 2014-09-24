package com.epam.electives.db.dao;

import com.epam.electives.db.util.ConnectionPool;
import com.epam.electives.entity.User;
import com.epam.electives.exceptions.DaoException;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Implementation for UserDao Interface
 */
public class UserDao implements IUserDao {

    private static final Logger LOG = Logger.getLogger(UserDao.class);

    public static final String FIND_USER_BY_LOGIN = "select users.idUser, users.login, users.password, users.first_name, users.last_name, roles.role from users " +
            "join roles on users.idRole = roles.idRole where login = ?";
    public static final String PUT_USER_TO_DB = "insert into users (login, password, first_name, last_name, idRole) values (?, ?, ?, ?, ?)";
    public static final String CHANGE_PASSWORD = "UPDATE users SET password= ? WHERE login = ?";
    public static final String DELETE_USER_FROM_USERS = "delete from users where idUser = ?";
    public static final String DELETE_USER_FROM_COURSE_RESULT = "delete from course_result where idUser = ?";
    public static final String FIND_USER_BY_ID = "select * from users where idUser = ?";
    /**
     *
     * @param login
     * @return user
     * @throws DaoException
     *
     */
    @Override
    public User findUserByLogin(String login) throws DaoException {
        LOG.info("UserDao.findUserByLogin()");
        User user = null;
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement(FIND_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                user = new User(result.getInt("idUser"), result.getString("login"), result.getString("password"), result.getString("role"), result.getString("first_name"), result.getString("last_name"));
            }
        } catch (SQLException e) {
            throw new DaoException("DaoException while finding user in database", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
        return user;
    }

    /**
     *
     * @param user
     * @return boolean true/false
     * @throws DaoException
     */
    @Override
    public boolean saveUser(User user) throws DaoException {
        LOG.info("UserDao.saveUser()");
        boolean flag = false;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        String login = user.getLogin();
        String password = user.getPassword();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        int role = user.getUserRole().getIntRole();
        try {
            preparedStatement = connection.prepareStatement(PUT_USER_TO_DB);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setInt(5, role);
            preparedStatement.executeUpdate();
            flag = true;
            LOG.info("User " + login + " has been saved");
        } catch (SQLException e) {
            throw new DaoException("DaoException while UserDao.saveUser()", e);
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }

        return flag;
    }

    /**
     *
     * @param newPassword
     * @param login
     * @return boolean true/false
     */
    @Override
    public boolean resetPassword(String newPassword, String login) throws DaoException {
        LOG.info("UserDao.resetPassword()");
        boolean flag = false;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(CHANGE_PASSWORD);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DaoException("DaoException while change password");
        } finally {
            IDao.close(preparedStatement);
            ConnectionPool.getInstance().putConnection(connection);
        }
        return flag;
    }
/*
    /**
     *
     * @param idUser
     * @return boolean true/false
     */
    @Override
    public boolean deleteUser(int idUser) throws DaoException {
        LOG.info("UserDao.deleteUser()");
        boolean flag = false;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;

        try {
            preparedStatement = connection.prepareStatement(FIND_USER_BY_ID);
            preparedStatement.setInt(1, idUser);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next() == false) {
                LOG.info("User with id: " + idUser + " has not been found");
                IDao.close(preparedStatement);
                return flag;
            } else {
                connection.setAutoCommit(false);
                preparedStatement1 = connection.prepareStatement(DELETE_USER_FROM_COURSE_RESULT);
                preparedStatement1.setInt(1, idUser);
                preparedStatement1.executeUpdate();
                preparedStatement2 = connection.prepareStatement(DELETE_USER_FROM_USERS);
                preparedStatement2.setInt(1, idUser);
                preparedStatement2.executeUpdate();
                connection.commit();
                connection.setAutoCommit(true);
                flag = true;
                LOG.info("User with id " + idUser + " has been deleted");
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new DaoException("DAOException while UserDao.delete() at rollback", e);
            }
            throw new DaoException("DAOException while UserDao.delete()", e);
        } finally {
            IDao.close(preparedStatement1);
            IDao.close(preparedStatement2);
            ConnectionPool.getInstance().putConnection(connection);
        }
        return false;
    }

}
