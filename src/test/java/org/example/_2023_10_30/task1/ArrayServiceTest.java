package org.example._2023_10_30.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceTest {
    /**
    Задание:
    Придумать несколько тест-кейсов (минимум 3).
    На каждый тест-кейс написать отдельный тестовый метод в данном классе.
    Тестовые методы должны тестировать функционал ArrayService.
     */
    private ArrayService service;

    @BeforeEach //производит все нужные действия ПЕРЕД запуском КАЖДОГО теста. В данном случае каждый раз создает новый чистый обьект нашего класса.
    public void init() {
        service = new ArrayService();
    }

    @Test
    public void checkingArraySize(){
        Assertions.assertEquals(5,service.getArrayBySize(5).length);
    }

    @Test
    public void checkingValues (){
        Assertions.assertEquals(2,service.getArrayBySize(5)[1]);
        Assertions.assertEquals(4,service.getArrayBySize(5)[3]);
        Assertions.assertEquals(5,service.getArrayBySize(5)[4]);
    }

    @Test
    public void checkingForNull(){
        Assertions.assertNotNull(service.getArrayBySize(5));
    }

    @Test
    public void notNegativeSize(){
        Assertions.assertThrows(IllegalArgumentException.class,()->service.getArrayBySize(0));
    }

}