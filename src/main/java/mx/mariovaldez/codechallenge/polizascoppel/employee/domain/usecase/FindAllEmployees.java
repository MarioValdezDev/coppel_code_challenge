package mx.mariovaldez.codechallenge.polizascoppel.employee.domain.usecase;

import mx.mariovaldez.codechallenge.polizascoppel.employee.domain.repository.EmployeeRepository;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Employee;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.repository.PoliceRepository;
import mx.mariovaldez.codechallenge.polizascoppel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllEmployees {

    @Autowired
    EmployeeRepository repository;

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }
}
