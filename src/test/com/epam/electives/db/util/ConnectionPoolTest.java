package test.com.epam.electives.db.util;

import com.epam.electives.db.util.DBPropertyManager;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectionPoolTest {

    @Test
    public void testGetConnection() throws SQLException{

        String URL = DBPropertyManager.getDBProperty("db.url");
        String LOGIN = DBPropertyManager.getDBProperty("db.login");
        String PASSWORD = DBPropertyManager.getDBProperty("db.password");
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        assertNotNull("Cant get connection", connection);
    }
}