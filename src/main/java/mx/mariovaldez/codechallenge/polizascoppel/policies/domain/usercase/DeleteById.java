package mx.mariovaldez.codechallenge.polizascoppel.policies.domain.usercase;

import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteById {

    @Autowired
    PoliceRepository policeRepository;

    public Object delete(String idPolice) {
        return policeRepository.deleteByidPolice(idPolice);
    }
}
