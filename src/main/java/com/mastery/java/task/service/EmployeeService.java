package com.mastery.java.task.service;

import com.github.javafaker.Faker;
import com.mastery.java.task.creator.EmployeeCreator;
import com.mastery.java.task.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    {
        employees.add(EmployeeCreator.createEmployee(1L));
        employees.add(EmployeeCreator.createEmployee(2L));
        employees.add(EmployeeCreator.createEmployee(3L));
        employees.add(EmployeeCreator.createEmployee(4L));
    }

    public Employee get(Long id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Employee> getAll() {
        return employees;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Long id) {
        employees.removeIf(e -> e.getId().equals(id));
    }
}
