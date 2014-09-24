package com.epam.electives.entity;

public class User extends Entity{

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private UserRole userRole;

    public User() {

    }

    public User(int id, String login, String password, String userRole, String firstName, String lastName) {
        super(id);
        this.login = login;
        this.password = password;
        this.userRole = UserRole.valueOf(userRole.toUpperCase());
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String login, String password, String firstName, String lastName, String userRole) {
        this.login = login;
        this.password = password;
        this.userRole = UserRole.valueOf(userRole.toUpperCase());
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return login + password + userRole;
    }
}
