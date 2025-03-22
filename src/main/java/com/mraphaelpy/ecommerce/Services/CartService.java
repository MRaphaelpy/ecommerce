package com.mraphaelpy.ecommerce.Services;

import com.mraphaelpy.ecommerce.Entities.Cart;
import com.mraphaelpy.ecommerce.Entities.Product;
import com.mraphaelpy.ecommerce.Repository.CartRepository;
import com.mraphaelpy.ecommerce.Repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CartService {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public Cart getCart(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
    }

    @Transactional
    public void addProductToCart(Long cartId, Long productId, int quantity) {
        Cart cart = getCart(cartId);
        Product product = productService.getProductById(productId);
        cart.addItem(product, quantity);
        cartRepository.save(cart);
    }

    @Transactional
    public void removeProductFromCart(Long cartId, Long productId) {
        Cart cart = getCart(cartId);
        cart.removeItem(productService.getProductById(productId));
        cartRepository.save(cart);
    }

    @Transactional
    public void clearCart(Long cartId) {
        Cart cart = getCart(cartId);
        cart.clearCart();
        cartRepository.save(cart);
    }
}
