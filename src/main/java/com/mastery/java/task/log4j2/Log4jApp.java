package com.mastery.java.task.log4j2;

import com.mastery.java.task.creator.EmployeeCreator;
import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Log4jApp {

    private static final EmployeeService employeeService = new EmployeeService();

    private static final Logger logger = LogManager.getLogger(Log4jApp.class);

    public static void get(Long id) {
        logger.traceEntry();
        Employee employee = employeeService.get(id);
        if (employee == null) {
            logger.atWarn().log("Employee with id={} doesn't exist", id);
        } else {
            logger.atDebug().log(
                    "Get employee with id={}, first_name={}, last_name={}",
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName()
            );
        }
        logger.traceExit();
    }

    public static void getAll() {
        logger.traceEntry();
        List<Employee> employeeList = employeeService.getAll();
        logger.atDebug().log("Get all employees, count={}", employeeList.size());
        logger.traceExit();
    }

    public static void delete(Long id) {
        logger.traceEntry();
        employeeService.remove(id);
        logger.atDebug().log("Delete employee with id={}", id);
        logger.traceExit();
    }

    public static void create(Long id) {
        logger.traceEntry();
        Employee employee = EmployeeCreator.createEmployee(id);
        employeeService.add(employee);
        logger.atDebug().log("Create employee with id={}, first_name={}, last_name={}",
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName()
        );
        logger.traceExit();
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
