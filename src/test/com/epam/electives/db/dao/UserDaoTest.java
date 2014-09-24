package test.com.epam.electives.db.dao;

import com.epam.electives.db.dao.UserDao;
import com.epam.electives.logic.IsLoginExist;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Before
    public void setUp() {
        new DOMConfigurator().doConfigure("web/WEB-INF/log4j.xml", LogManager.getLoggerRepository());
    }

    @Test
    public void testDeleteUser() throws Exception {
        System.out.println("CheckLoginExist");
        int idUser = 100;
        boolean expResult = false;
        boolean result = new UserDao().deleteUser(idUser);
        assertEquals(expResult, result);
    }
}