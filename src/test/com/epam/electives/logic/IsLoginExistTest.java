package test.com.epam.electives.logic;

import com.epam.electives.logic.IsLoginExist;
import com.epam.electives.logic.LoginLogic;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsLoginExistTest {

    @Before
    public void setUp() {
            new DOMConfigurator().doConfigure("web/WEB-INF/log4j.xml", LogManager.getLoggerRepository());
    }

    @Test
    public void testCheckLoginExist() throws Exception {
        System.out.println("CheckLoginExist");
        String login = "burich";
        boolean expResult = false;
        boolean result = IsLoginExist.checkLoginExist(login);
        assertEquals(expResult, result);
    }
}