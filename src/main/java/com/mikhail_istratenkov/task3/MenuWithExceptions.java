package com.mikhail_istratenkov.task3;

import com.mikhail_istratenkov.task2.Dish;
import com.mikhail_istratenkov.task2.Menu;

import java.util.NoSuchElementException;

public class MenuWithExceptions extends Menu {

    @Override
    public Dish findDishByName(String name) {
        try {
            return super.findDishByName(name);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Dish with the name '" + name + "' doesn't exist in the menu.", e);
        }
    }
}
