package com.mikhail_istratenkov.task2;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

    private String customerName;
    private List<Dish> dishes;

    public Order() {
    }

    public Order(String customerName, List<Dish> dishes) {
        this.customerName = customerName;
        this.dishes = dishes;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public int getSummaryPrice() {
        return dishes.stream().mapToInt(Dish::getPrice).sum();
    }

    @Override
    public String toString() {
        String string = "{" + customerName + ", ";
        for (Dish dish : dishes) {
            string += dish + ", ";
        }
        string += ", цена всего заказа: " + getSummaryPrice() + " руб }";
        return string;
    }
}
