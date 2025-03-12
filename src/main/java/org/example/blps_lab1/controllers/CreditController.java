package org.example.blps_lab1.controllers;

import org.example.blps_lab1.dto.request.ContractRequest;
import org.example.blps_lab1.dto.request.CreditRequest;
import org.example.blps_lab1.dto.response.CreditResponse;
import org.example.blps_lab1.models.Contract;
import org.example.blps_lab1.services.ContractService;
import org.example.blps_lab1.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit")
public class CreditController {
    @Autowired
    private CreditService creditService;

    @Autowired
    private ContractService contractService;

    @PostMapping
    public ResponseEntity<CreditResponse> applyForCredit(@RequestBody CreditRequest creditRequest) {
        CreditResponse creditResponse = creditService.getCreditDecision(creditRequest);
        if (creditResponse.isApproved()) {
            return ResponseEntity.ok(creditResponse);
        } else {
            return ResponseEntity.status(400).body(creditResponse);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCredit(@RequestBody ContractRequest contractRequest) {
        String responseMessage = contractService.createContract(contractRequest);
        if (responseMessage.contains("Error")) {
            return ResponseEntity.status(400).body(responseMessage);
        } else {
            return ResponseEntity.ok(responseMessage);
        }
    }
}
