package com.webapps.controller;

import com.webapps.entity.Employee;
import com.webapps.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/hello")
    public String helloworld(Model model)
    {
        return "hello";
    }

    @PostMapping("/postEmployee")
    public String createEmployee(@ModelAttribute("employee") @Valid Employee employee, Errors errors)
    {
        if(errors.hasErrors())
        {
            return "addEmployee";
        }
        else {
            employeeService.createNewEmployee(employee);
            return "redirect:listEmployee";
        }
    }

    //Get Mapping
    @GetMapping(value = "/listEmployee")
    public void getAllEmployee(Model model) {
         model.addAttribute("allEmployees",employeeService.getAllEmployee());
        viewPagination(1,"name","asc",model);

    }
    @GetMapping("/index")
    public String showIndex(Model model)
    {
        return "index";
    }

    @GetMapping("/addEmployee")
    public String showAddNewEmployee(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "addEmployee";
    }

    @GetMapping("/employee/edit/{id}")
    public String getEmployeeById(@PathVariable long id, Model model)
    {
        Employee employee=employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "updateEmployee";
    }

    @PostMapping("/employee/edit/{id}")
    public String updateEmployee(@ModelAttribute("employee") Employee employee,Model model,@PathVariable long id)
    {
        Employee exixtingEmployee=employeeService.getEmployeeById(id);
        exixtingEmployee.setId(employee.getId());
        exixtingEmployee.setName(employee.getName());
        exixtingEmployee.setEmail(employee.getEmail());
        exixtingEmployee.setCity(employee.getCity());
        exixtingEmployee.setProfession(employee.getProfession());
        employeeService.createNewEmployee(exixtingEmployee);
        return "redirect:/listEmployee";
    }
    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable long id)
    {
        employeeService.deleteEmployee(id);
        return "redirect:/listEmployee";
    }
    @GetMapping("/employee/page/{pageNo}")
    public String viewPagination(@PathVariable (value = "pageNo")int pageNo,
                                 @RequestParam("sortField")String sortField,
                                 @RequestParam("sortDir")String sortDir,
                                 Model model)
    {
        int pageSize=5;
        Page<Employee> page=employeeService.findPaginated(pageNo,pageSize,sortField,sortDir);
        List<Employee>employeeList=page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalitems",page.getTotalElements());
        model.addAttribute("allEmployees",employeeList);
        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("reverseDir",sortDir.equals("asc")?"desc":"asc");

        System.out.println("CurrentPage:"+pageNo+"Total Page:"+page.getTotalPages()+"Total item:"+page.getTotalElements());
        return "listEmployee";


    }
}
