package mx.mariovaldez.codechallenge.polizascoppel.service;

import mx.mariovaldez.codechallenge.polizascoppel.employee.domain.usecase.FindAllEmployees;
import mx.mariovaldez.codechallenge.polizascoppel.employee.domain.usecase.SaveEmployee;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    FindAllEmployees findAllEmployees;

    @Autowired
    SaveEmployee saveEmployee;

    public List<Employee> getAllEmployees(){
        return findAllEmployees.getAllEmployees();
    }

    public Employee saveEmployee(Employee employee){
        return saveEmployee.saveEmployee(employee);
    }

}
