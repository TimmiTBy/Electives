package com.epam.electives.entity.result;

public class CourseResult extends Result {

    private String firstName;
    private String lastName;

    public CourseResult(String firstName, String lastName, int mark, String feedback) {
        super(mark, feedback);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CourseResult(int idResult, String firstName, String lastName, int mark, String feedback) {
        super(idResult, mark, feedback);
        this.firstName = firstName;
        this.lastName = lastName;
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


}
