package com.epam.electives.util.sort;

import com.epam.electives.entity.result.UniversityResult;

import java.util.Comparator;

/**
 * Sorting University results by course name
 */
public class SortByCourseName implements Comparator<UniversityResult> {

    @Override
    public int compare(UniversityResult result1, UniversityResult result2) {
        String courseName1 = result1.getCourseName().toUpperCase();
        String courseName2 = result2.getCourseName().toUpperCase();

        //ascending order
        return courseName1.compareTo(courseName2);
    }
}
