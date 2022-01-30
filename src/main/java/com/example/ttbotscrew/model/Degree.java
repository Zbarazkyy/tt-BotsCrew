package com.example.ttbotscrew.model;

public enum Degree {
    ASSISTANT("assistant"),
    ASSOCIATE_PROFESSOR("associate professor"),
    PROFESSOR("professor");
    private String degree;

    Degree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }
}
