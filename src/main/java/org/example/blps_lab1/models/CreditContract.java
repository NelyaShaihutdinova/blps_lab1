package org.example.blps_lab1.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CreditContract {
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

    @OneToOne
    @JoinColumn(name = "order_id")
    @JsonManagedReference
    private Order order;
}
