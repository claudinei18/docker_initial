package com.example.tddtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalarioMinimoService {

    @Autowired
    SalarioMinimoRepository salarioMinimoRepository;

    public SalarioMinimo save(SalarioMinimo salarioMinimo){
        return salarioMinimoRepository.save(salarioMinimo);
    }
}
