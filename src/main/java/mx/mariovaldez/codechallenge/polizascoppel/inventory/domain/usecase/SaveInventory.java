package mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.usecase;

import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.model.InventoryRequest;
import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.repository.InventoryRepository;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SaveInventory {

    @Autowired
    InventoryRepository inventoryRepository;

    public Object saveInventory(InventoryRequest inventoryRequest) {
        Inventory inventory = Inventory.builder()
                .name(inventoryRequest.getName())
                .SKU(inventoryRequest.getSKU())
                .quantity(inventoryRequest.getQuantity())
                .build();

        return inventoryRepository.save(inventory);
    }
}
