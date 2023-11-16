package org.example._2023_11_16.Framework.Interfaces;

import java.util.List;

public interface AppDataBase <T>{
    List<T> getAll();
    T getById(int id);
    T add(int age, String name);
    void delete(int id);
}
