package mx.mariovaldez.codechallenge.polizascoppel.inventory.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequest {

    private String SKU;
    private String name;
    private int quantity;
}
