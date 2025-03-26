package org.example.blps_lab1.repositories;

import org.example.blps_lab1.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
