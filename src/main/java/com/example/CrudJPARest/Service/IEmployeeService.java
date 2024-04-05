package com.example.CrudJPARest.Service;

import com.example.CrudJPARest.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    List<Employee> getEmployees();
    Optional<Employee> getEmployee(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
