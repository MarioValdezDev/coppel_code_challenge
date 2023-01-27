package mx.mariovaldez.codechallenge.polizascoppel.inventory.infrastructure.controller;

import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.model.InventoryRequest;
import mx.mariovaldez.codechallenge.polizascoppel.exception.RequestException;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Inventory;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.ResponseSuccess;
import mx.mariovaldez.codechallenge.polizascoppel.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    InventoryService service;

    @PostMapping("")
    public HttpEntity<Object> saveInventory(@RequestBody InventoryRequest request) {
        try {
            if (request.getSKU().isEmpty() ||
                    request.getName().isEmpty()) {
                throw new RequestException("Ha ocurrido un error en los grabados de inventario.");
            }
            return new ResponseEntity<>(service.saveInventory(request), HttpStatus.OK);
        } catch (Exception e) {
            throw new RequestException("Ha ocurrido un error en los grabados de póliza.");
        }
    }

    @GetMapping("")
    public List<Inventory> inventory(Model model) {
        return service.findAll();
    }

}
