package mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.usecase;

import mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.repository.InventoryRepository;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DecreaseQuantity {

    @Autowired
    InventoryRepository inventoryRepository;

    public Inventory decreaseInventory(Inventory inventory, Integer quantity) {
        inventory.setQuantity(inventory.getQuantity() - quantity);
        return inventoryRepository.save(inventory);
    }
}
