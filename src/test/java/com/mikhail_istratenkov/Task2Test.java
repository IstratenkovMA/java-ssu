package com.mikhail_istratenkov;

import com.mikhail_istratenkov.task2.Dish;
import com.mikhail_istratenkov.task2.Menu;
import com.mikhail_istratenkov.task2.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Task2Test {

    private Menu menu;

    @BeforeEach
    public void setUp() {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Рулет с изюмом", 75, 15));
        dishes.add(new Dish("Пирог с повидлом", 60, 13));
        dishes.add(new Dish("Пирог с яблоками", 60, 13));
        dishes.add(new Dish("Салат Изюминка", 100, 35));
        dishes.add(new Dish("Салат Лукошко", 100, 40));
        dishes.add(new Dish("Салат Капустный с помидором", 100, 19));
        dishes.add(new Dish("Суп харчо с говядиной", 250, 31));
        dishes.add(new Dish("Суп куриный с грибами", 250, 21));
        dishes.add(new Dish("Суп болгарский вегетарианский", 80, 54));
        dishes.add(new Dish("Рыбное филе с помидоркой", 150, 54));
        dishes.add(new Dish("Печень по королевски", 150, 54));
        dishes.add(new Dish("Свинина запеченная \"По-гусарски\"", 80, 68));
        dishes.add(new Dish("Греча с маслом", 170, 17));
        dishes.add(new Dish("Макароны отварные", 170, 15));
        dishes.add(new Dish("Рис отварной с маслом", 170, 16));
        menu = new Menu(dishes);
    }

    @Test
    public void menuReport() {
        String expectedResult = menu.getClass().getName() + "@" + Integer.toHexString(menu.hashCode());
        String actualResult = menu.toString();
        assertNotEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }

    @Test
    public void orderReport() {
        List<Order> orders = new ArrayList<>();

        List<Dish> dishes = new ArrayList<>();
        dishes.add(menu.findDishByName("Салат Изюминка"));
        dishes.add(menu.findDishByName("Печень по королевски"));
        dishes.add(menu.findDishByName("Рис отварной с маслом"));
        dishes.add(menu.findDishByName("Рулет с изюмом"));
        orders.add(new Order("Пупкин А.", dishes));

        dishes = new ArrayList<>();
        dishes.add(menu.findDishByName("Салат Лукошко"));
        dishes.add(menu.findDishByName("Суп куриный с грибами"));
        dishes.add(menu.findDishByName("Свинина запеченная \"По-гусарски\""));
        dishes.add(menu.findDishByName("Макароны отварные"));
        dishes.add(menu.findDishByName("Пирог с яблоками"));
        orders.add(new Order("Кривенко С.", dishes));

        dishes = new ArrayList<>();
        dishes.add(menu.findDishByName("Суп болгарский вегетарианский"));
        dishes.add(menu.findDishByName("Рыбное филе с помидоркой"));
        dishes.add(menu.findDishByName("Рулет с изюмом"));
        dishes.add(menu.findDishByName("Пирог с повидлом"));
        orders.add(new Order("Гайченов П.", dishes));

        dishes = new ArrayList<>();
        dishes.add(menu.findDishByName("Салат Изюминка"));
        dishes.add(menu.findDishByName("Суп куриный с грибами"));
        dishes.add(menu.findDishByName("Печень по королевски"));
        dishes.add(menu.findDishByName("Макароны отварные"));
        dishes.add(menu.findDishByName("Пирог с повидлом"));
        orders.add(new Order("Сухожилов Л.", dishes));

        String expectedResult = "";
        for (Order order : orders) {
            expectedResult += order.getClass().getName() + "@" + Integer.toHexString(order.hashCode()) + "\n";
        }
        String actualResult = "";
        for (Order order : orders) {
            actualResult += order + "\n";
        }
        assertNotEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
}