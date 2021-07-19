package com.company.springboot.service.impl;

import com.company.springboot.exception.ResourceNotFoundException;
import com.company.springboot.model.Employee;
import com.company.springboot.repo.EmployeeRepository;
import com.company.springboot.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveemployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else{
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // first check if the employee with given id exists in the database or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id)
        );

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // save existing employee to database
        employeeRepository.save(existingEmployee);
        return null;
    }


}
