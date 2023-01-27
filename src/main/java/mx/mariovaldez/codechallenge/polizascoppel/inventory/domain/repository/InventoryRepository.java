package mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.repository;

import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,String> {

    Inventory findBySKU(String sku);
}
