package mx.mariovaldez.codechallenge.polizascoppel.policies.domain.usercase;

import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.usecase.DecreaseQuantity;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Inventory;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Policies;
import mx.mariovaldez.codechallenge.polizascoppel.model.request.SavePolicyRequest;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.ResponseSuccess;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.mappers.PolicyMapper;
import mx.mariovaldez.codechallenge.polizascoppel.employee.domain.repository.EmployeeRepository;
import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.repository.InventoryRepository;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePolicy {
    @Autowired
    PoliceRepository policyRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PolicyMapper mapper;

    @Autowired
    DecreaseQuantity decreaseQuantity;

    public ResponseSuccess savePolicy(SavePolicyRequest savePoliceRequest) {
        Inventory inventory = inventoryRepository.findBySKU(savePoliceRequest.getSku());
        Policies policie = Policies.builder()
                .idPolice(savePoliceRequest.getIdPolicy())
                .employee(employeeRepository.findByidEmployee(savePoliceRequest.getIdEmployee()))
                .inventory(decreaseQuantity.decreaseInventory(inventory,savePoliceRequest.getQuantity()))
                .date(savePoliceRequest.getDate())
                .quantity(savePoliceRequest.getQuantity())
                .build();
        return mapper.map(policyRepository.save(policie));
    }
}
