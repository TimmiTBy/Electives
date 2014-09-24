package test.com.epam.electives.entity;

import com.epam.electives.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        String expResult = null;
        String result = user.getLogin();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetLogin() throws Exception {
        System.out.println("setLogin");
        String login = null;
        user.setLogin(login);
    }
}