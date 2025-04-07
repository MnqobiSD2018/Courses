package com.example.courses;

import java.util.List;

public class EngineeringBranch {
    private String name;
    private int semesters;
    private List<String> subjects;

    public EngineeringBranch(String name, int semesters, List<String> subjects) {
        this.name = name;
        this.semesters = semesters;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getSemesters() {
        return semesters;
    }

    public List<String> getSubjects() {
        return subjects;
    }
}