package com.epam.electives.logic;

import org.mindrot.BCrypt;

/**
 * Compare passwords(Entered and in base)
 */
public class LoginLogic {

    /**
     *
     * @param enteredPassword
     * @param passwordFromBase
     * @return return true if passwords match
     */
    public static boolean checkLogin (String enteredPassword, String passwordFromBase) {
        return !passwordFromBase.isEmpty() && BCrypt.checkpw(enteredPassword, passwordFromBase);
    }


}
