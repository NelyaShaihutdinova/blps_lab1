package org.example.blps_lab1.services;

import org.example.blps_lab1.dto.request.OrderRequest;
import org.example.blps_lab1.models.*;
import org.example.blps_lab1.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditContractRepository creditContractRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private CartService cartService;

    public String createOrder(OrderRequest orderRequest) {
        try {
            Order order = parseOrder(orderRequest);
            orderRepository.save(order);
            cartService.clearCart(orderRequest.getUserId());
            return "Contract created successfully and card are cleared";
        } catch (Exception e) {
            return "Error while creating contract: " + e.getMessage();
        }
    }

    public Order parseOrder(OrderRequest request) {
        Order order = new Order();
        order.setStatus(Status.valueOf(request.getStatus()));
        List<Product> products = productRepository.findAllById(request.getProductsId());
        order.setProducts(products);
        Optional<User> user = userRepository.findById(request.getUserId());
        order.setUser(user.get());
        Optional<Store> store = storeRepository.findById(request.getStoreId());
        order.setStore(store.get());
        return order;
    }
}
