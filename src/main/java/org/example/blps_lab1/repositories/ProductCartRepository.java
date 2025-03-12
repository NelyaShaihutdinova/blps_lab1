package org.example.blps_lab1.repositories;

import org.example.blps_lab1.models.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
    List<ProductCart> findByCartId(Long cartId);
}
