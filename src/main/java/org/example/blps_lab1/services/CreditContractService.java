package org.example.blps_lab1.services;

import org.example.blps_lab1.dto.request.ContractRequest;
import org.example.blps_lab1.models.CreditContract;
import org.example.blps_lab1.models.Order;
import org.example.blps_lab1.repositories.CreditContractRepository;
import org.example.blps_lab1.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditContractService {
    @Autowired
    private CreditContractRepository contractRepository;

    @Autowired
    private OrderRepository orderRepository;

    public String createContract(ContractRequest contractRequest) {
        try {
            CreditContract contract = parseContract(contractRequest);
            contractRepository.save(contract);
            return "Contract created successfully";
        } catch (Exception e) {
            return "Error while creating contract: " + e.getMessage();
        }
    }

    public CreditContract parseContract(ContractRequest request) {
        CreditContract contract = new CreditContract();
        contract.setLoanAmount(request.getLoanAmount());
        contract.setTerm(request.getTerm());
        contract.setDownPayment(request.getDownPayment());
        contract.setMonthlyPayment(request.getMonthlyPayment());
        contract.setPassportDetails(request.getPassportDetails());
        contract.setEmail(request.getEmail());
        contract.setPhone(request.getPhone());
        Optional<Order> order = orderRepository.findById(request.getOrderId());
        contract.setOrder(order.get());
        return contract;
    }
}
