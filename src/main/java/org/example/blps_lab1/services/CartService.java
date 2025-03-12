package org.example.blps_lab1.services;

import org.example.blps_lab1.exceptions.CartNotFoundException;
import org.example.blps_lab1.exceptions.ProductNotFoundException;
import org.example.blps_lab1.exceptions.UserNotFoundException;
import org.example.blps_lab1.models.Cart;
import org.example.blps_lab1.models.Product;
import org.example.blps_lab1.models.ProductCart;
import org.example.blps_lab1.models.User;
import org.example.blps_lab1.repositories.CartRepository;
import org.example.blps_lab1.repositories.ProductCartRepository;
import org.example.blps_lab1.repositories.ProductRepository;
import org.example.blps_lab1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductCartRepository productCartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public String addProductToCart(Long userId, Long productId) {
        User user = userRepository.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        Optional<ProductCart> existingItem = productCartRepository.findAll().stream()
                .filter(item -> item.getProduct().equals(product) && item.getCart().equals(cart))
                .findFirst();

        if (existingItem.isPresent()) {
            productCartRepository.save(existingItem.get());
        } else {
            ProductCart newItem = new ProductCart();
            newItem.setCart(cart);
            newItem.setProduct(product);
            productCartRepository.save(newItem);
        }
        return "Product added to cart";
    }

    public List<ProductCart> getCartItems(Long userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new CartNotFoundException("Cart not found for user"));
        return productCartRepository.findByCartId(cart.getId());
    }

    public String removeProductFromCart(Long userId, Long productId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new CartNotFoundException("Cart not found for user"));

        ProductCart cartItem = productCartRepository.findAll().stream()
                .filter(item -> item.getProduct().getId().equals(productId) && item.getCart().getId().equals(cart.getId()))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found in the cart"));

        productCartRepository.delete(cartItem);
        return "Product removed from cart";
    }

    public String clearCart(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new CartNotFoundException("Cart not found for user"));
        List<ProductCart> cartItems = productCartRepository.findByCartId(cart.getId());
        productCartRepository.deleteAll(cartItems);
        return "Cart cleared successfully";
    }
}

