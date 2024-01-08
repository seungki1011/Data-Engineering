package de.java.inheritance.practice;

public class Movie extends Item{
    protected String director;
    protected String actor;

    public Movie(String name, int price, String director, String actor) {
        super(name, price);
        this.director = director;
        this.actor = actor;
    }
}
