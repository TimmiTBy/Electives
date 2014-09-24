package com.epam.electives.entity.result;

import com.epam.electives.entity.Entity;

public class Result extends Entity {

    private int mark;
    private String feedback;

    public Result() {

    }

    public Result(int mark, String feedback) {
        this.mark = mark;
        this.feedback = feedback;
    }

    public Result(int id, int mark, String feedback) {
        super(id);
        this.mark = mark;
        this.feedback = feedback;
    }


    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
