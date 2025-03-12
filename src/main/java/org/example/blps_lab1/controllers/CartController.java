package org.example.blps_lab1.controllers;

import org.example.blps_lab1.models.ProductCart;
import org.example.blps_lab1.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<String> addToCart(
            @RequestParam("userId") Long userId,
            @RequestParam("productId") Long productId) {
        String response = cartService.addProductToCart(userId, productId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ProductCart>> getCartItems(@PathVariable("userId") Long userId) {
        List<ProductCart> items = cartService.getCartItems(userId);
        return ResponseEntity.ok(items);
    }

    @DeleteMapping
    public ResponseEntity<String> removeFromCart(
            @RequestParam("userId") Long userId,
            @RequestParam("productId") Long productId) {
        String response = cartService.removeProductFromCart(userId, productId);
        return ResponseEntity.ok(response);
    }
}

