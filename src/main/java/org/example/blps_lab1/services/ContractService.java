package org.example.blps_lab1.services;

import org.example.blps_lab1.dto.request.ContractRequest;
import org.example.blps_lab1.models.Contract;
import org.example.blps_lab1.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractParserService contractParserService;

    @Autowired
    private CartService cartService;

    public String createContract(ContractRequest contractRequest) {
        try {
            Contract contract = contractParserService.parseContract(contractRequest);
            contractRepository.save(contract);
            cartService.clearCart(contractRequest.getUserId());
            return "Contract created successfully and card are cleared";
        } catch (Exception e) {
            return "Error while creating contract: " + e.getMessage();
        }
    }
}
