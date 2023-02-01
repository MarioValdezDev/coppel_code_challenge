package mx.mariovaldez.codechallenge.polizascoppel.policies.domain.usercase;

import mx.mariovaldez.codechallenge.polizascoppel.model.response.ResponseSuccess;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.mappers.PolicyMapper;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindPolicyById {

    @Autowired
    PoliceRepository repository;

    @Autowired
    PolicyMapper mapper;

    public ResponseSuccess getPolicie(String id) {
        return mapper.map(repository.findByidPolice(id));
    }
}
