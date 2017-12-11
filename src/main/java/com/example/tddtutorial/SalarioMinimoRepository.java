package com.example.tddtutorial;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarioMinimoRepository extends JpaRepository<SalarioMinimo, Long> {

}
