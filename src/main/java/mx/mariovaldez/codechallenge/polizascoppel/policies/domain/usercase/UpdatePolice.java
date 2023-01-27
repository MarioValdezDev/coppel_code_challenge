package mx.mariovaldez.codechallenge.polizascoppel.policies.domain.usercase;

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
public class UpdatePolice {

    @Autowired
    PoliceRepository policeRepository;

    @Autowired
    InventoryRepository inventarioRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PoliceMapper mapper;

    public ResponseSuccess updatePolice(SavePoliceRequest savePolizaRequest){
        Policies policie = Policies.builder()
                .idPolice(savePolizaRequest.getIdPolice())
                .employee(employeeRepository.findByidEmployee(savePolizaRequest.getIdEmployee()))
                .inventory(inventarioRepository.findBySKU(savePolizaRequest.getSku()))
                .date(savePolizaRequest.getDate())
                .quantity(savePolizaRequest.getQuatity())
                .build();
        return mapper.map(policeRepository.save(policie));
    }
}
