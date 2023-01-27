package mx.mariovaldez.codechallenge.polizascoppel.service;

import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Policies;
import mx.mariovaldez.codechallenge.polizascoppel.model.request.SavePoliceRequest;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.ResponseSuccess;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.usercase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Transactional
@Service
public class PoliceService {

    @Autowired
    FindPoliceById findPoliceById;

    @Autowired
    FindAllPolicies findAllPolicies;

    @Autowired
    SavePolice savePolice;

    @Autowired
    UpdatePolice updatePolice;

    @Autowired
    DeleteById deleteById;

    public List<Policies> getPolicies() {
        return findAllPolicies.getAllPolicies();
    }

    public ResponseSuccess getPolicie(String id) {
        return findPoliceById.getPolicie(id);
    }

    public ResponseSuccess savePolice(SavePoliceRequest savePolizaRequest) {
        return savePolice.savePolice(savePolizaRequest);
    }

    public ResponseSuccess updatePolice(SavePoliceRequest savePolizaRequest) {
        return updatePolice.updatePolice(savePolizaRequest);
    }

    public Object delete(String idPolice) {
        return deleteById.delete(idPolice);
    }
}
