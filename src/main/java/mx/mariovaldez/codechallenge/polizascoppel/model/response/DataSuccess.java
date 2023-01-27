package mx.mariovaldez.codechallenge.polizascoppel.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataSuccess {

    private PoliceResponse police;
    private EmployeeResponse employee;
    private ArticleDetailResponse articleDetail;
}
