package com.epam.electives.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class InfoTag extends TagSupport {

    private String firstName;
    private String lastName;
    private String role;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.write("<div> \n" +
                      "<b>" + firstName + " " + lastName + "</b>" + "</br>"  +
                      "<b>" + role + "</b>" );
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }

        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doAfterBody() throws JspException {

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {

        try {
            pageContext.getOut().write("\n </div>");
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }

        return EVAL_PAGE;
    }
}
