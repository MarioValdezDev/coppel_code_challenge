package mx.mariovaldez.codechallenge.polizascoppel.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PoliciesResponse {

    private List<DataSuccess> data;
}
