package mx.mariovaldez.codechallenge.polizascoppel.policies.domain.mappers;

import mx.mariovaldez.codechallenge.polizascoppel.domain.Mapper;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Policies;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Component
public class PolicyMapper implements Mapper<Policies, ResponseSuccess> {

    @Override
    public ResponseSuccess map(Policies policies) {
        try {
            return ResponseSuccess.builder()
                    .meta(new Meta("OK"))
                    .data(new DataSuccess(
                                    new PolicyResponse(policies.getIdPolice(), policies.getQuantity()),
                                    new EmployeeResponse(policies.getEmployee().getName(), policies.getEmployee().getLastName()),
                                    new ArticleDetailResponse(policies.getInventory().getSKU(), policies.getInventory().getName())
                            )
                    ).build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exception at obtain policy info.");
        }
    }

    @Override
    public List<ResponseSuccess> map(List<Policies> values) {
        return Collections.emptyList();
    }
}
