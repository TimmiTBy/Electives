package com.epam.electives.entity;

import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;

public enum UserRole {

    GUEST (PageManager.getPage("path.page.login"), Constants.GUEST_ROLE_INT),
    STUDENT (PageManager.getPage("path.page.welcomestudent"), Constants.STUDENT_ROLE_INT),
    TEACHER(PageManager.getPage("path.page.welcometeacher"), Constants.TEACHER_ROLE_INT),
    ADMIN(PageManager.getPage("path.page.welcomeadmin"), Constants.ADMIN_ROLE_INT);

    String welcomePage;
    int role;

    UserRole(String welcomePage, int role) {
        this.welcomePage = welcomePage;
        this.role = role;
    }

    public String getWelcomePage() {
        return welcomePage;
    }

    public int getIntRole() {
        return role;
    }
}
