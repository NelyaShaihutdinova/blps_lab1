package org.example.blps_lab1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imageUrl;

    @Column(name = "old_price")
    private BigDecimal oldPrice;

    @Column(name = "discounted_price")
    private BigDecimal discountedPrice;

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private Set<Store> stores = new HashSet<>();
}
