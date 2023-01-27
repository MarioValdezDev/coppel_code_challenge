package mx.mariovaldez.codechallenge.polizascoppel.policies.domain.usercase;

import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.usecase.DecreaseQuantity;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Inventory;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Policies;
import mx.mariovaldez.codechallenge.polizascoppel.model.request.SavePoliceRequest;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.ResponseSuccess;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.mappers.PoliceMapper;
import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.repository.EmployeeRepository;
import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.repository.InventoryRepository;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePolice {
    @Autowired
    PoliceRepository policeRepository;

    @Autowired
    InventoryRepository inventarioRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PoliceMapper mapper;

    @Autowired
    DecreaseQuantity decreaseQuantity;

    public ResponseSuccess savePolice(SavePoliceRequest savePoliceRequest) {
        Inventory inventory = inventarioRepository.findBySKU(savePoliceRequest.getSku());
        Policies policie = Policies.builder()
                .idPolice(savePoliceRequest.getIdPolice())
                .employee(employeeRepository.findByidEmployee(savePoliceRequest.getIdEmployee()))
                .inventory(decreaseQuantity.decreaseInventory(inventory,savePoliceRequest.getQuatity()))
                .date(savePoliceRequest.getDate())
                .quantity(savePoliceRequest.getQuatity())
                .build();
        return mapper.map(policeRepository.save(policie));
    }
}
