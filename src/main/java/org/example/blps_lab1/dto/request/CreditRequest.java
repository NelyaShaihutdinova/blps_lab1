package org.example.blps_lab1.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditRequest {
    private Double loanAmount;
    private Integer term;
    private Double downPayment;
    private Double monthlyPayment;
    private String passportDetails;
    private String email;
    private String phone;
}
