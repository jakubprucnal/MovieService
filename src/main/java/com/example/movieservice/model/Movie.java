package com.example.movieservice.model;

public class Movie {
    private Long id;
    private String name;
    private Enum<Category> category;

    public Movie(String name) {
        this.name = name;
    }

    public Movie(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Movie(Enum<Category> category) {
        this.category = category;
    }
//    public Movie(Long id, String name, Enum<Category> category) {
//        this.id = id;
//        this.name = name;
//        this.category = category;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum<Category> getCategory() {
        return category;
    }

    public void setCategory(Enum<Category> category) {
        this.category = category;
    }
}
