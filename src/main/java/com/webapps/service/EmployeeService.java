package com.webapps.service;

import com.webapps.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createNewEmployee(Employee employee);

    List<Employee>getAllEmployee();
}
