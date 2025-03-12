package org.example.blps_lab1.repositories;

import org.example.blps_lab1.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
