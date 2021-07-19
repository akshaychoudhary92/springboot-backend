package com.company.springboot.controller;

import com.company.springboot.model.Employee;
import com.company.springboot.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveemployee(employee), HttpStatus.CREATED);
    }

    //build get all employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // build get by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id") long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    //build update employee REST API
    @PutMapping
    public ResponseEntity<Employee> updateEmployee(){}
}
