package io.github.kambasdojava.binsurance.service;

import io.github.kambasdojava.binsurance.model.Client;
import io.github.kambasdojava.binsurance.model.Insurance;
import io.github.kambasdojava.binsurance.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Client create(Client client) {
        return repository.save(client);
    }

    public Client findById(Integer id) {
        var optional = repository.findById(id);

        return optional.get();
    }

    public List<Client> findAll() {
        return (List<Client>) repository.findAll();
    }

    public Client update(Client client) {
        if (repository.existsById(client.getId())) {
            return null;
        }

        return repository.save(client);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Insurance> findInsuranceByClientId(Integer id) {
        var optional = repository.findById(id);

        if (optional.isPresent()) {
            return optional.get().getInsurances();
        }

        return null;
    }

    public Insurance createInsurance(Integer id, Insurance insurance) {
        var optional = repository.findById(id);

        if (optional.isPresent()) {
            var client = optional.get();

            client.getInsurances().add(insurance);

            repository.save(client);

            return insurance;
        }

        return null;
    }
}
