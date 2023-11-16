package org.example._2023_11_16.Aplication.Services;

import org.example._2023_11_16.Aplication.DataBases.CatDataBase;
import org.example._2023_11_16.Framework.Annotations.AutoSet;
import org.example._2023_11_16.Framework.Annotations.Servise;
import org.example._2023_11_16.Framework.Interfaces.AppServise;

@Servise
public class CatService implements AppServise {
    @AutoSet
    private CatDataBase dataBase;

    @Override
    public void printAll() {
        dataBase.getAll().forEach(System.out::println);
    }

    @Override
    public void printOne(int id) {
        System.out.println(dataBase.getById(id));
    }
}
