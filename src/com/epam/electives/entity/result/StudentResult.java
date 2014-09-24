package com.epam.electives.entity.result;

public class StudentResult extends Result {

    private String courseName;
    private int courseHours;

    public StudentResult() {

    }

    public StudentResult(int idResult, String courseName, int courseHours, int studentMark, String feedback) {
        super(idResult, studentMark, feedback);
        this.courseName = courseName;
        this.courseHours = courseHours;

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(int courseHours) {
        this.courseHours = courseHours;
    }



}
