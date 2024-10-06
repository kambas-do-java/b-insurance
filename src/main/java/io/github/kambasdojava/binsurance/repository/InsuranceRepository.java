package io.github.kambasdojava.binsurance.repository;

import io.github.kambasdojava.binsurance.model.Insurance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance, Long> {
}
