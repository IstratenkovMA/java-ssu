package com.mikhail_istratenkov;

import com.mikhail_istratenkov.task2.Dish;
import com.mikhail_istratenkov.task2.Menu;
import com.mikhail_istratenkov.task2.Order;
import com.mikhail_istratenkov.task5.Serializer;
import com.mikhail_istratenkov.task5.SerializerException;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Task5Test {

    @Test
    public void dishSerialization() throws IOException, SerializerException {
        File file = createTempFile();
        Serializer serializer = new Serializer(file);
        Dish expected = new Dish("name", 0, 0);
        assertTrue(file.length() == 0);
        serializer.serialize(expected);
        Dish actual = serializer.deserialize(Dish.class);
        assertEquals(expected.toString(), actual.toString());
        assertFalse(file.length() == 0);
    }

    @Test
    public void menuSerialization() throws IOException, SerializerException {
        File file = createTempFile();
        Serializer serializer = new Serializer(file);
        Menu expected = new Menu(readDishList("dishes.txt"));
        assertTrue(file.length() == 0);
        serializer.serialize(expected);
        Menu actual = serializer.deserialize(Menu.class);
        assertEquals(expected.toString(), actual.toString());
        assertFalse(file.length() == 0);
    }

    @Test
    public void orderSerialization() throws IOException, SerializerException {
        File file = createTempFile();
        Serializer serializer = new Serializer(file);
        Order expected = new Order("customer", readDishList("dishes.txt"));
        assertTrue(file.length() == 0);
        serializer.serialize(expected);
        Order actual = serializer.deserialize(Order.class);
        assertEquals(expected.toString(), actual.toString());
        assertFalse(file.length() == 0);
    }

    @Test
    public void serializerException() throws IOException, SerializerException {
        File file = createTempFile();
        Serializer serializer = new Serializer(file);
        Dish expected = new Dish("name", 0, 0);
        assertTrue(file.length() == 0);
        assertThrows(SerializerException.class, () -> serializer.deserialize(Dish.class));
        serializer.serialize(expected);
        assertThrows(SerializerException.class, () -> serializer.deserialize(Order.class));

    }

    private File createTempFile() throws IOException {
        return File.createTempFile("tmp", String.valueOf(System.nanoTime()));
    }

    private List<Dish> readDishList(String fileName){
        List<Dish> dishes = new ArrayList<>();
        try(FileReader reader = new FileReader(fileName))
        {
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line  = br.readLine()) != null){
                String[] parameters = line.split(" ");
                dishes.add(new Dish(parameters[0], new Integer(parameters[1]), new Integer(parameters[2])));
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return dishes;
    }
}
