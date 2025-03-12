package org.example.blps_lab1.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private List<Long> productsId;
    private Long storeId;
    private Long userId;
}
