package mx.mariovaldez.codechallenge.polizascoppel.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavePoliceRequest {

    private String idPolice;
    private String date;
    private Integer quatity;
    private String sku;
    private String idEmployee;

}
