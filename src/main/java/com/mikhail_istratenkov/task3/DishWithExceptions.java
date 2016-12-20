package com.mikhail_istratenkov.task3;

import com.mikhail_istratenkov.task2.Dish;

public class DishWithExceptions extends Dish {

    public DishWithExceptions(String name, int weight, int price) {
        setName(name);
        setWeight(weight);
        setPrice(price);
    }

    @Override
    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price can't be negative.");
        }
        super.setPrice(price);
    }

    @Override
    public void setWeight(int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight can't be negative.");
        }
        super.setWeight(weight);
    }
}
