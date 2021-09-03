package com.lovecoding.fellows7_springboot.service;

import com.lovecoding.fellows7_springboot.pojo.Employee;

public interface EmployeeService {
    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(Long id);
}
