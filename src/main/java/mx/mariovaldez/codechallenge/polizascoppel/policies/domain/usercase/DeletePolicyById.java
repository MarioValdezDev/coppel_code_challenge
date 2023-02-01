package mx.mariovaldez.codechallenge.polizascoppel.policies.domain.usercase;

import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletePolicyById {

    @Autowired
    PoliceRepository policyRepository;

    public Object delete(String idPolice) {
        return policyRepository.deleteByidPolice(idPolice);
    }
}
