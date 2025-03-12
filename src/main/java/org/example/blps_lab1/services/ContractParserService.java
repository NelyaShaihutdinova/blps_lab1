package org.example.blps_lab1.services;

import org.example.blps_lab1.dto.request.ContractRequest;
import org.example.blps_lab1.models.Contract;
import org.example.blps_lab1.models.Product;
import org.example.blps_lab1.models.Store;
import org.example.blps_lab1.models.User;
import org.example.blps_lab1.repositories.ProductRepository;
import org.example.blps_lab1.repositories.StoreRepository;
import org.example.blps_lab1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractParserService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoreRepository storeRepository;

    public Contract parseContract(ContractRequest request) {
        Contract contract = new Contract();
        contract.setLoanAmount(request.getLoanAmount());
        contract.setTerm(request.getTerm());
        contract.setDownPayment(request.getDownPayment());
        contract.setMonthlyPayment(request.getMonthlyPayment());
        contract.setPassportDetails(request.getPassportDetails());
        contract.setEmail(request.getEmail());
        contract.setPhone(request.getPhone());
        List<Product> products = productRepository.findAllByIdIn(request.getProductsId());
        System.out.println(products);
        contract.setProducts(products);
        Optional<User> user = userRepository.findUserById(request.getUserId());
        contract.setUser(user.get());
        Optional<Store> store = storeRepository.findById(request.getStoreId());
        contract.setStore(store.get());
        return contract;
    }
}
