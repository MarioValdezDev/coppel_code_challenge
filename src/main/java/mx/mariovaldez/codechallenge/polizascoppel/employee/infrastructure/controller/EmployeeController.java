package mx.mariovaldez.codechallenge.polizascoppel.employee.infrastructure.controller;

import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Employee;
import mx.mariovaldez.codechallenge.polizascoppel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("")
    public HttpEntity<Employee> saveEmployee(@RequestBody Employee request){
        return new ResponseEntity<>(employeeService.saveEmployee(request), HttpStatus.OK);
    }
}
