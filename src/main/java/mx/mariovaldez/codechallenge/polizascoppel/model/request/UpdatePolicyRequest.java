package mx.mariovaldez.codechallenge.polizascoppel.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePolicyRequest {

    private String idPolicy;
    private String articleName;
    private String employeeName;
    private String employeeLastName;

}
