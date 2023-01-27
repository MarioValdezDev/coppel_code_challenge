package mx.mariovaldez.codechallenge.polizascoppel.policies.domain.repository;

import mx.mariovaldez.codechallenge.polizascoppel.model.entity.Policies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliceRepository extends JpaRepository<Policies, String> {

    Policies findByidPolice(String id);

    Object deleteByidPolice(String id);


}
