package org.example.blps_lab1.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContractRequest {
    private Double loanAmount;
    private Integer term;
    private Double downPayment;
    private Double monthlyPayment;
    private String passportDetails;
    private String email;
    private String phone;
    private Long orderId;
}
