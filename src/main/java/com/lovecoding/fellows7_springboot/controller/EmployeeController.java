package com.lovecoding.fellows7_springboot.controller;

import com.lovecoding.fellows7_springboot.pojo.Employee;
import com.lovecoding.fellows7_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService es;

    @GetMapping("/getEmployeeById")
    public Employee getEmployeeById(Long id){
        return es.getEmployeeById(id);
    }

    @PostMapping("/updateEmployee")
    public Employee updateEmployee(Employee employee){
        es.updateEmployee(employee);
        return employee;
    }

    @PostMapping("/deleteEmployeeById")
    public void deleteEmployeeById(Long id){
        es.deleteEmployeeById(id);
    }
}
