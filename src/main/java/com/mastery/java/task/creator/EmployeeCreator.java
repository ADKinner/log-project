package com.mastery.java.task.creator;

import com.github.javafaker.Faker;
import com.mastery.java.task.entity.Employee;

public class EmployeeCreator {

    private static final Faker faker = new Faker();

    public static Employee createEmployee(Long id) {
        return new Employee(id, faker.name().firstName(), faker.name().lastName());
    }
}
