package io.github.kambasdojava.binsurance.service;

import io.github.kambasdojava.binsurance.model.Insurance;
import io.github.kambasdojava.binsurance.repository.InsuranceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceService {
    private final InsuranceRepository repository;

    public InsuranceService(InsuranceRepository repository) {
        this.repository = repository;
    }

    public List<Insurance> findByStatus(String status) {
        var insurances = (List<Insurance>) repository.findAll();

        return switch (status) {
            case "active" -> {
                var aux = new ArrayList<Insurance>();
                for (Insurance insurance : insurances) {
                    if (insurance.getEndDate().isAfter(LocalDate.now())) {
                        aux.add(insurance);
                    }
                }

                yield aux;
            }
            case "expired" -> {
                var aux = new ArrayList<Insurance>();
                for (Insurance insurance : insurances) {
                    if (insurance.getEndDate().isBefore(LocalDate.now())) {
                        aux.add(insurance);
                    }
                }

                yield aux;
            }
            case "soon" -> {
                var aux = new ArrayList<Insurance>();
                for (Insurance insurance : insurances) {
                    if (Math.abs(insurance.getEndDate().until(LocalDate.now()).getDays()) < 30 ) {
                        aux.add(insurance);
                    }
                }

                yield aux;
            }
            default -> insurances;
        };
    }
}
