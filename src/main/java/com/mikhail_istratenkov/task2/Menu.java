package com.mikhail_istratenkov.task2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu implements Serializable {

    private List<Dish> dishes = new ArrayList<>();

    public Menu() {
    }

    public Menu(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Dish findDishByName(String name) {
        return dishes.stream()
                .filter(dish -> Objects.equals(dish.getName(), name))
                .findFirst()
                .get();
    }

    @Override
    public String toString() {
        String string = "{Name, Weight, Price}\n";
        for (Dish dish : dishes) {
            string += dish + "\n";
        }
        return string;
    }
}
