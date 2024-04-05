package com.example.CrudJPARest.Controller;

import com.example.CrudJPARest.Model.Employee;
import com.example.CrudJPARest.Service.IEmployeeService;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employees = employeeService.getEmployees();
        HttpHeaders headers = new HttpHeaders();
        headers.add("total", String.valueOf(employees.size()));
        return new ResponseEntity<List<Employee>>(employees, headers, HttpStatus.OK);
    }

    @GetMapping(value = "employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployee(@PathVariable(name = "id")int id){
        return employeeService.getEmployee(id).orElse(null);
    }

    @PostMapping(value = "employees", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addEmployees(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "employees", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(name = "id") int id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
