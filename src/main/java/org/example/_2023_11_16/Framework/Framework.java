package org.example._2023_11_16.Framework;

import javassist.tools.reflect.Reflection;
import org.example._2023_11_16.Framework.Annotations.AutoSet;
import org.example._2023_11_16.Framework.Annotations.DataBase;
import org.example._2023_11_16.Framework.Annotations.Servise;
import org.example._2023_11_16.Framework.Interfaces.AppServise;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Framework {
    private static Reflections reflections;
    private static Set<Object> dataBases;
    private static Set<Object> services;

    private static AppServise getService(String type) {
        for (Object service : services) {
            if (service.getClass().getSimpleName().toLowerCase().startsWith(type)) {
                return (AppServise) service;
            }
        }
        return null;
    }

    public static void run(Class<?> appClass) {
        Package parrentPackage = appClass.getPackage();
        reflections = new Reflections(parrentPackage.getName());
        dataBases = getAnnotatedInstances(DataBase.class);
        services = getAnnotatedInstances(Servise.class);
        setDataBasesToServices();
        work();
    }

    private static Set<Object> getAnnotatedInstances(Class<? extends Annotation> annotation) {
        Set<Class<?>> dbClasses = reflections.getTypesAnnotatedWith(annotation);
        Set<Object> result = new HashSet<>();
        try {
            for (Class<?> dbclass : dbClasses) {
                Object object = dbclass.getDeclaredConstructor().newInstance();
                result.add(object);
            }
        } catch (Exception exception) {
            System.out.println("Не удалось создать обьект");
        }
        return result;
    }

    private static void setDataBasesToServices() {
        for (Object service : services) {
            Field[] fields = service.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(AutoSet.class)) {
                    Class<?> classType = field.getType();
                    for (Object database : dataBases) {
                        if (database.getClass().equals(classType)) {
                            field.setAccessible(true);
                            try {
                                field.set(service, database);
                            } catch (Exception exception) {
                                System.out.println("Не удалось засетить базу данных в сервис");
                            }
                        }
                    }
                }
            }
        }
    }

    private static void work() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите запрос или exit для выхода");
            String req = scanner.nextLine().toLowerCase();
            if (req.equals("exit")) break; //здесь выход из цикла, иначе будет бесконечный, return выбросил бы из метода и код ниже цикла был бы недостижим - ошибка компиляции
            //cat all - возвращает всех кошек
            //cat 3 - возвращает кошку под номером 3
            String[] reqArr = req.split(" ");
            if (reqArr.length != 2){
                continue;
            }
            String type = reqArr[0];
            AppServise servise = getService(type);
            if (servise != null) {
                if (reqArr[1].equals("all")) {
                    servise.printAll();
                } else {
                    servise.printOne(Integer.parseInt(reqArr[1]));
                }
            } else {
                System.out.println("Неверный запрос");
            }
        }
        scanner.close();
    }
}
