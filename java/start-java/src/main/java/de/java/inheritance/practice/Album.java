package de.java.inheritance.practice;

public class Album extends Item{
    protected String artist;

    public Album(String name, int price, String artist) {
        super(name, price);
        this.artist = artist;
    }
}
