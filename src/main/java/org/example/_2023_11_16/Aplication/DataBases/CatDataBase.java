package org.example._2023_11_16.Aplication.DataBases;

import org.example._2023_11_16.Aplication.Animals.Cat;
import org.example._2023_11_16.Framework.Annotations.DataBase;
import org.example._2023_11_16.Framework.Interfaces.AppDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataBase
public class CatDataBase implements AppDataBase<Cat>{
    private Map<Integer, Cat> cats = new HashMap<>();
    private int currentId;

    public CatDataBase() {
        add(5,"Tom");
        add(3,"Silvestr");
        add(7,"Garfild");
    }

    @Override
    public List<Cat> getAll() {
        return new ArrayList<>(cats.values());
    }

    @Override
    public Cat getById(int id) {
        return cats.get(id);
    }

    @Override
    public Cat add(int age, String name) {
        Cat cat = new Cat(++currentId,age,name);
        cats.put(cat.getId(),cat);
        return cat;
    }

    @Override
    public void delete(int id) {
        cats.remove(id);
    }
}
