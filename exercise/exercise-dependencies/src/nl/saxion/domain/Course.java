package nl.saxion.domain;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Course {

    private final static ArrayList<Course> allCourses = new ArrayList<>();

    public static Stream<Course> getAllCourses() {
        return allCourses.stream();
    }

    private final String code;

    private final String year;

    private final String quartile;

    public Course(String name, String year, String quartile) {
        this.code = name;
        this.year = year;
        this.quartile = quartile;
    }

    public void save() {
        allCourses.add(this);
    }

    public String getCode() {
        return code;
    }

    public String getYear() {
        return year;
    }

    public String getQuartile() {
        return quartile;
    }

}
