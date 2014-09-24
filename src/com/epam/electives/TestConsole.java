package com.epam.electives;

import com.epam.electives.db.dao.UserDao;
import com.epam.electives.entity.User;
import com.epam.electives.exceptions.DaoException;
import org.mindrot.BCrypt;

import java.text.NumberFormat;
import java.util.*;

public class TestConsole {

    public static void main(String[] args) {

        String password = null;
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed.isEmpty());
        System.out.println(BCrypt.checkpw("12345", hashed));

    }
}











