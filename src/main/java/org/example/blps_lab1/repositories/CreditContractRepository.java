package org.example.blps_lab1.repositories;

import org.example.blps_lab1.models.CreditContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditContractRepository extends JpaRepository<CreditContract, Long> {
}
