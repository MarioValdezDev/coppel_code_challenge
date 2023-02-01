package mx.mariovaldez.codechallenge.polizascoppel.policies.domain.mappers;

import mx.mariovaldez.codechallenge.polizascoppel.domain.Mapper;
import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Policies;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PoliciesListMapper implements Mapper<Policies, DataSuccess> {
    @Override
    public DataSuccess map(Policies policies) {
        return null;
    }

    @Override
    public List<DataSuccess> map(List<Policies> policies) {
        try {
            return policies.stream().map(
                    policy ->
                            DataSuccess.builder()
                                    .policy(new PolicyResponse(policy.getIdPolice(), policy.getQuantity()))
                                    .employee(new EmployeeResponse(policy.getEmployee().getName(), policy.getEmployee().getLastName()))
                                    .articleDetail(new ArticleDetailResponse(policy.getInventory().getSKU(), policy.getInventory().getName()))
                                    .build()
            ).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exception at obtain policy info.");
        }
    }
}
