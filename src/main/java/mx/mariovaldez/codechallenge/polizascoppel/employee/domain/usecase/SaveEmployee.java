package mx.mariovaldez.codechallenge.polizascoppel.employee.domain.usecase;

import mx.mariovaldez.codechallenge.polizascoppel.employee.domain.repository.EmployeeRepository;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveEmployee {

    @Autowired
    EmployeeRepository repository;

    public Employee saveEmployee(Employee employee){
        return  repository.save(employee);
    }
}
