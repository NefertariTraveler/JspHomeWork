package com.javacto.po;

import java.util.Date;

/**
 * liu
 **/
public class Dog {
    private int id;
    private String dogName;
    private String pwd;
    private String species;
    private String color;
    private double health;
    private Date date;

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", dogName='" + dogName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", species='" + species + '\'' +
                ", color='" + color + '\'' +
                ", health=" + health +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
