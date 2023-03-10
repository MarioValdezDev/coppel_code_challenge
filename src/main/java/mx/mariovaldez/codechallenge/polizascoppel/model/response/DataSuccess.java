package mx.mariovaldez.codechallenge.polizascoppel.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataSuccess {

    private PolicyResponse policy;
    private EmployeeResponse employee;
    private ArticleDetailResponse articleDetail;
}
