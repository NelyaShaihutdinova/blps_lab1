package org.example.blps_lab1.repositories;

import org.example.blps_lab1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findAllByIdIn(List<Long> ids);
}
