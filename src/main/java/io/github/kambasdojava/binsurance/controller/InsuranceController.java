package io.github.kambasdojava.binsurance.controller;

import io.github.kambasdojava.binsurance.model.Insurance;
import io.github.kambasdojava.binsurance.service.InsuranceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsuranceController {
    private final InsuranceService service;

    public InsuranceController(InsuranceService service) {
        this.service = service;
    }

    @GetMapping("/insurances")
    public List<Insurance> getInsurances(@RequestParam(name = "status", required = false, defaultValue = "") String status) {
        return service.findByStatus(status);
    }
}
