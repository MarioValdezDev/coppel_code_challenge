package mx.mariovaldez.codechallenge.polizascoppel.service;

import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.model.InventoryRequest;
import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.usecase.FindAllInventory;
import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.usecase.SaveInventory;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    SaveInventory saveInventory;

    @Autowired
    FindAllInventory findAllInventory;

    public Object saveInventory(InventoryRequest inventoryRequest){
        return saveInventory.saveInventory(inventoryRequest);
    }

    public List<Inventory> findAll(){
        return findAllInventory.getAll();
    }
}
