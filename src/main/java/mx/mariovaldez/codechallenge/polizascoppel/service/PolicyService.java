package mx.mariovaldez.codechallenge.polizascoppel.service;

import mx.mariovaldez.codechallenge.polizascoppel.model.request.SavePolicyRequest;
import mx.mariovaldez.codechallenge.polizascoppel.model.request.UpdatePolicyRequest;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.DataSuccess;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.ResponseSuccess;
import mx.mariovaldez.codechallenge.polizascoppel.policies.domain.usercase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Transactional
@Service
public class PolicyService {

    @Autowired
    FindPolicyById findPoliceById;

    @Autowired
    FindAllPolicies findAllPolicies;

    @Autowired
    SavePolicy savePolice;

    @Autowired
    UpdatePolicy updatePolice;

    @Autowired
    DeletePolicyById deleteById;

    public List<DataSuccess> getPolicies() {
        return findAllPolicies.getAllPolicies();
    }

    public ResponseSuccess getPolicy(String id) {
        return findPoliceById.getPolicie(id);
    }

    public ResponseSuccess savePolicy(SavePolicyRequest savePolizaRequest) {
        return savePolice.savePolicy(savePolizaRequest);
    }

    public ResponseSuccess updatePolicy(UpdatePolicyRequest updatePolicyRequest) {
        return updatePolice.updatePolice(updatePolicyRequest);
    }

    public Object delete(String idPolice) {
        return deleteById.delete(idPolice);
    }
}
