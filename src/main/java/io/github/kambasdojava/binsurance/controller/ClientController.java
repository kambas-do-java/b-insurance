package io.github.kambasdojava.binsurance.controller;

import io.github.kambasdojava.binsurance.model.Client;
import io.github.kambasdojava.binsurance.model.Insurance;
import io.github.kambasdojava.binsurance.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }


    @GetMapping("/clients")
    public List<Client> findAll() {
        return service.findAll();
    }

    @PostMapping("/clients")
    public Client save(@RequestBody Client client) {
        return service.create(client);
    }

    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/clients/{id}")
    public Client findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PutMapping("/clients/{id}")
    public Client update(@PathVariable int id, @RequestBody Client client) {
        if (client.getId() != id) {
            return null;
        }


        return service.update(client);
    }

    @GetMapping("/clients/{id}/insurances")
    public List<Insurance> findInsurances(@PathVariable int id) {


        return service.findInsuranceByClientId(id);
    }

    @PostMapping("/clients/{id}/insurances")
    public Insurance save(@PathVariable int id, @RequestBody Insurance insurance) {

        return service.createInsurance(id, insurance);
    }
}
