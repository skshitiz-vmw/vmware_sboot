package com.examples.boot.rest.model;

public class Greetings {

    private int id;
    private String message;

    public Greetings() {

    }

    public Greetings(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
