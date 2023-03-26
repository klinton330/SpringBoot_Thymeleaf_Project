package com.webapps.controller;

import com.webapps.entity.Employee;
import com.webapps.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    EmployeeService employeeService;

    public Employee createEmployee(Employee employee)
    {
        return employeeService.createNewEmployee(employee);
    }

    @GetMapping("/")
    public String getAllEmployee(Model model) {
         model.addAttribute("allEmployees",employeeService.getAllEmployee());
         return "index";

    }

}
