package mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.usecase;

import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.repository.InventoryRepository;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FindAllInventory {

    @Autowired
    InventoryRepository inventoryRepository;

    public List<Inventory> getAll(){
        return inventoryRepository.findAll();
    }
}
