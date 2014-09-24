package com.epam.electives.entity;

public class Course extends Entity {

    private String name;
    private int hours;
    private String description;

    public Course() {

    }

    public Course(String name, int hours, String description) {
        this.name = name;
        this.hours = hours;
        this.description = description;
    }

    public Course(int id, String name, int hours, String description) {
        super(id);
        this.name = name;
        this.hours = hours;
        this.description = description;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
