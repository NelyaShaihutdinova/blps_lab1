package org.example.blps_lab1.repositories;

import org.example.blps_lab1.models.Product;
import org.example.blps_lab1.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
