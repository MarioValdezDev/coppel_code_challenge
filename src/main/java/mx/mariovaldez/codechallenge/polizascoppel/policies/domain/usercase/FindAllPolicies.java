package mx.mariovaldez.codechallenge.polizascoppel.policies.domain.usercase;

import mx.mariovaldez.codechallenge.polizascoppel.model.response.DataSuccess;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.mappers.PoliciesListMapper;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllPolicies {
    @Autowired
    PoliceRepository repository;

    @Autowired
    PoliciesListMapper mapper;

    public List<DataSuccess> getAllPolicies() {
        return mapper.map(repository.findAll());
    }
}
