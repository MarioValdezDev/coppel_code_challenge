package mx.mariovaldez.codechallenge.polizascoppel.policies.infrastructure.controller;

import mx.mariovaldez.codechallenge.polizascoppel.exception.RequestException;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Policies;
import mx.mariovaldez.codechallenge.polizascoppel.model.request.SavePoliceRequest;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.ResponseSuccess;
import mx.mariovaldez.codechallenge.polizascoppel.service.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("police")
public class PoliceController {

    @Autowired
    private PoliceService policeService;

    @GetMapping("")
    public HttpEntity<List<Policies>> getPolicies() {
        try {
            return new ResponseEntity<>(policeService.getPolicies(), HttpStatus.OK);
        } catch (Exception e) {
            throw new RequestException("Ha ocurrido un error al obtener las pólizas");
        }
    }

    @GetMapping("/{id}")
    public HttpEntity<ResponseSuccess> getPolicieById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(policeService.getPolicie(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RequestException("Ha ocurrido un error al consultar la póliza.");
        }
    }

    @PostMapping("")
    public HttpEntity<ResponseSuccess> savePoliza(@RequestBody SavePoliceRequest request) {
        try {
            if (request.getIdPolice().isEmpty() ||
                    request.getIdEmployee().isEmpty() ||
                    request.getSku().isEmpty()) {
                throw new RequestException("Ha ocurrido un error en los grabados de póliza.");
            }
            return new ResponseEntity<>(policeService.savePolice(request), HttpStatus.OK);
        } catch (Exception e) {
            throw new RequestException("Ha ocurrido un error en los grabados de póliza.");
        }
    }

    @PatchMapping("")
    public HttpEntity<ResponseSuccess> updatePoliza(@RequestBody SavePoliceRequest request) {
        try {
            if (request.getIdPolice().isEmpty() ||
                    request.getIdEmployee().isEmpty() ||
                    request.getSku().isEmpty()) {
                throw new RequestException("Ha ocurrido un error al intentar actualizar la póliza.");
            }
            return new ResponseEntity<>(policeService.updatePolice(request), HttpStatus.OK);
        } catch (Exception e) {
            throw new RequestException("Ha ocurrido un error al intentar actualizar la póliza.");
        }
    }

    @DeleteMapping("/{idPolice}")
    public HttpEntity<Object> delete(@PathVariable("idPolice") String idPolice){

        return new ResponseEntity<>(policeService.delete(idPolice), HttpStatus.OK);
    }


}
