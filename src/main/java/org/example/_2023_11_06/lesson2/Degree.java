package org.example._2023_11_06.lesson2;

public enum Degree {

    BACHELOR("Бакалавр"),
    MASTER("Магистр");

    private String description;

    Degree(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}