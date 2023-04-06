package com.webapps.service;

import com.webapps.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    Employee createNewEmployee(Employee employee);

    List<Employee>getAllEmployee();

    Employee getEmployeeById(long id);

    public void deleteEmployee(long id);

    Page<Employee> findPaginated(int pageNo, int pageSize,String sortField,String sortDirection);
}
