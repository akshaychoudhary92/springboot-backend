package com.company.springboot.service;

import com.company.springboot.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveemployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
}
