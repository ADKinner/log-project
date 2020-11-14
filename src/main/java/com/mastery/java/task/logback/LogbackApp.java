package com.mastery.java.task.logback;

import com.mastery.java.task.creator.EmployeeCreator;
import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LogbackApp {

    private static final EmployeeService employeeService = new EmployeeService();

    private static final Logger logger = LoggerFactory.getLogger(LogbackApp.class);

    public static void get(Long id) {
        logger.trace("Enter");
        Employee employee = employeeService.get(id);
        if (employee == null) {
            logger.warn("Employee with id={} doesn't exist", id);
        } else {
            logger.debug(
                    "Get employee with id={}, first_name={}, last_name={}",
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName()
            );
        }
        logger.trace("Exit");
    }

    public static void getAll() {
        logger.trace("Enter");
        List<Employee> employeeList = employeeService.getAll();
        logger.debug("Get all employees, count={}", employeeList.size());
        logger.trace("Exit");
    }

    public static void delete(Long id) {
        logger.trace("Enter");
        employeeService.remove(id);
        logger.debug("Delete employee with id={}", id);
        logger.trace("Exit");
    }

    public static void create(Long id) {
        logger.trace("Enter");
        Employee employee = EmployeeCreator.createEmployee(id);
        employeeService.add(employee);
        logger.debug("Create employee with id={}, first_name={}, last_name={}",
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName()
        );
        logger.trace("Exit");
    }

    public static void main(String[] args) {
        get(8L);
        getAll();
        create(5L);
        create(6L);
        getAll();
        delete(5L);
        getAll();
    }
}
