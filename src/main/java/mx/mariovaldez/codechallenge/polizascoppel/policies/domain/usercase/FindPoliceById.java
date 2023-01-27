package mx.mariovaldez.codechallenge.polizascoppel.policies.domain.usercase;

import mx.mariovaldez.codechallenge.polizascoppel.model.response.ResponseSuccess;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.mappers.PoliceMapper;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindPoliceById {

    @Autowired
    PoliceRepository repository;

    @Autowired
    PoliceMapper mapper;

    public ResponseSuccess getPolicie(String id) {
        return mapper.map(repository.findByidPolice(id));
    }
}
