package org.example.blps_lab1.controllers;

import org.example.blps_lab1.dto.request.OrderRequest;
import org.example.blps_lab1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<String> saveOrder(@RequestBody OrderRequest orderRequest) {
        String responseMessage = orderService.createOrder(orderRequest);
        if (responseMessage.contains("Error")) {
            return ResponseEntity.status(400).body(responseMessage);
        } else {
            return ResponseEntity.ok(responseMessage);
        }
    }
}
