package com.mraphaelpy.ecommerce.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private ProductService productService;

    public void addProductToCart(Long productId) {
        productService.getProductById(productId);
    }

    public void removeProductFromCart(Long productId) {
        productService.getProductById(productId);
    }
}