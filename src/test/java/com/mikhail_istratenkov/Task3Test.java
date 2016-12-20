package com.mikhail_istratenkov;

import com.mikhail_istratenkov.task3.DishWithExceptions;
import com.mikhail_istratenkov.task3.MenuWithExceptions;
import com.mikhail_istratenkov.task5.SerializerException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {

    @Test
    public void dishExceptions() throws IOException, SerializerException {
        assertThrows(IllegalArgumentException.class, () -> new DishWithExceptions("name", -1, 0));
        assertThrows(IllegalArgumentException.class, () -> new DishWithExceptions("name", 0, -1));
    }

    @Test
    public void menuExceptions() throws IOException, SerializerException {
        assertThrows(IllegalArgumentException.class, () -> new MenuWithExceptions().findDishByName("dish"));
    }
}
