package mx.mariovaldez.codechallenge.polizascoppel.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PoliciesSuccess {
    
    private Meta meta;
    private DataSuccess data;
}
