package org.example;

import com.google.gson.Gson;
import org.apache.commons.lang3.SystemUtils;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", "Smith", 30);

        // Сериализация объекта в JSON
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println("Сериализованный объект: " + json);

        // Десериализация JSON в объект
        Person deserializedPerson = gson.fromJson(json, Person.class);
        System.out.println("Десериализованный объект: " + deserializedPerson);

    }
}