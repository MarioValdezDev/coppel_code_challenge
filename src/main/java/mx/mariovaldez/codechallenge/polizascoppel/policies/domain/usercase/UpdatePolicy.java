package mx.mariovaldez.codechallenge.polizascoppel.policies.domain.usercase;

import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Employee;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Inventory;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Policies;
import mx.mariovaldez.codechallenge.polizascoppel.model.request.UpdatePolicyRequest;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.ResponseSuccess;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.mappers.PolicyMapper;
import mx.mariovaldez.codechallenge.polizascoppel.employee.domain.repository.EmployeeRepository;
import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.repository.InventoryRepository;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePolicy {

    @Autowired
    PoliceRepository policyRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PolicyMapper mapper;

    public ResponseSuccess updatePolice(UpdatePolicyRequest updatePolicyRequest){
        Policies currentPolicy = policyRepository.findByidPolice(updatePolicyRequest.getIdPolicy());
        Employee employee = employeeRepository.findByidEmployee(currentPolicy.getEmployee().getIdEmployee());
        employee.setName(updatePolicyRequest.getEmployeeName());
        employee.setLastName(updatePolicyRequest.getEmployeeLastName());
        Inventory inventory = inventoryRepository.findBySKU(currentPolicy.getInventory().getSKU());
        inventory.setName(updatePolicyRequest.getArticleName());
        Policies policy = Policies.builder()
                .idPolice(currentPolicy.getIdPolice())
                .employee(employee)
                .inventory(inventory)
                .date(currentPolicy.getDate())
                .quantity(currentPolicy.getQuantity())
                .build();
        return mapper.map(policyRepository.save(policy));
    }
}
