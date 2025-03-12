package org.example.blps_lab1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double loanAmount;
    private Integer term;
    private Double downPayment;
    private Double monthlyPayment;
    private String passportDetails;
    private String email;
    private String phone;

    @ManyToMany
    @JoinTable(
            name = "contract_product",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @ManyToOne
    private Store store;

    @ManyToOne
    private User user;
}
