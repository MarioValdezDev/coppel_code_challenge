package mx.mariovaldez.codechallenge.polizascoppel.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyResponse {

    private String idPolicy;
    private Integer quantity;

}
