package mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.repository;

import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Employee findByidEmployee(String idEmployee);
}
