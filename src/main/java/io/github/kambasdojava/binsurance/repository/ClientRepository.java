package io.github.kambasdojava.binsurance.repository;

import io.github.kambasdojava.binsurance.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
}
