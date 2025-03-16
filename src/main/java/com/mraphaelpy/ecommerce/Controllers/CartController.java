package com.mraphaelpy.ecommerce.Controllers;

import com.mraphaelpy.ecommerce.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/add")
    public void addProductToCart(@RequestBody Long productId) {
        cartService.addProductToCart(productId);
    }
    @DeleteMapping("/remove")
    public void removeProductFromCart(@RequestBody Long productId) {
        cartService.removeProductFromCart(productId);
    }

}
