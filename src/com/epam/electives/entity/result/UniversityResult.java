package com.epam.electives.entity.result;

public class UniversityResult extends Result {

    private String firstName;
    private String lastName;
    private String courseName;

    public UniversityResult() {

    }

    public UniversityResult( String courseName, String firstName, String lastName, int mark, String feedback) {
        super(mark, feedback);
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "UniversityResult{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
