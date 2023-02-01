package mx.mariovaldez.codechallenge.polizascoppel.policies.infrastructure.controller;

import mx.mariovaldez.codechallenge.polizascoppel.exception.RequestException;
import mx.mariovaldez.codechallenge.polizascoppel.model.request.SavePolicyRequest;
import mx.mariovaldez.codechallenge.polizascoppel.model.request.UpdatePolicyRequest;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.*;
import mx.mariovaldez.codechallenge.polizascoppel.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("policy")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("")
    public HttpEntity<List<DataSuccess>> getPolicies() {
        try {
            return new ResponseEntity<>(policyService.getPolicies(), HttpStatus.OK);
        } catch (Exception e) {
            throw new RequestException("Ha ocurrido un error al obtener las pólizas");
        }
    }

    @GetMapping("/{id}")
    public HttpEntity<ResponseSuccess> getPolicieById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(policyService.getPolicy(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RequestException("Ha ocurrido un error al consultar la póliza.");
        }
    }

    @PostMapping("")
    public HttpEntity<ResponseSuccess> savePoliza(@RequestBody SavePolicyRequest request) {
        try {
            if (request.getIdPolicy().isEmpty() ||
                    request.getIdEmployee().isEmpty() ||
                    request.getSku().isEmpty()) {
                throw new RequestException("Ha ocurrido un error en los grabados de póliza.");
            }
            return new ResponseEntity<>(policyService.savePolicy(request), HttpStatus.OK);
        } catch (Exception e) {
            throw new RequestException("Ha ocurrido un error en los grabados de póliza.");
        }
    }

    @PatchMapping("")
    public HttpEntity<Object> updatePolicy(@RequestBody UpdatePolicyRequest request) {
        try {
            if (request.getIdPolicy().isEmpty() ||
                    request.getArticleName().isEmpty() ||
                    request.getEmployeeLastName().isEmpty() ||
                    request.getEmployeeName().isEmpty()) {
                throw new RequestException("Ha ocurrido un error al intentar actualizar la póliza.");
            }
            policyService.updatePolicy(request);
            return new ResponseEntity<>(new ActionDoneResponse(
                    new Meta("OK"),
                    new DataFailure("Se actualizó correctamente la póliza")
            ), HttpStatus.OK);
        } catch (Exception e) {
            throw new RequestException("Ha ocurrido un error al intentar actualizar la póliza.");
        }
    }

    @DeleteMapping("/{idPolicy}")
    public HttpEntity<Object> delete(@PathVariable("idPolicy") String idPolice){

        return new ResponseEntity<>(policyService.delete(idPolice), HttpStatus.OK);
    }


}
