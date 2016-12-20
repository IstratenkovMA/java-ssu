package com.mikhail_istratenkov.task2;

import java.io.Serializable;

public class Dish implements Serializable {

    private String name;
    private int weight;
    private int price;

    public Dish() {
    }

    public Dish(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + weight +" г. , " + price + " руб]";
    }
}
