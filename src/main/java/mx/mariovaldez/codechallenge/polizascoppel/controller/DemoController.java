package mx.mariovaldez.codechallenge.polizascoppel.controller;

import mx.mariovaldez.codechallenge.polizascoppel.exception.RequestException;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Inventory;
import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private InventoryRepository inventarioRepository;

    @PostMapping("/insert_inventory")
    public Object insertInventory(@RequestParam(value = "name", defaultValue = "World JEJEJ") String name) {
        try {
            Inventory inventario = new Inventory();
            inventario.setSKU("1");
            inventario.setName("Mario");
            inventario.setQuantity(10);
            return inventarioRepository.save(inventario);
        } catch (Exception e) {
            throw new RequestException("Ha ocurrido un error al obtener las pólizas");
        }
    }
}
