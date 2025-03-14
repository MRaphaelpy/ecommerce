package com.mraphaelpy.ecommerce.Ecommerce.Controllers;

import com.mraphaelpy.ecommerce.Ecommerce.Entites.Product;
import com.mraphaelpy.ecommerce.Ecommerce.Services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.store(product), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Product> getProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@RequestBody Long id) {
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.FOUND);
    }
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update-stock/{id}")
    public ResponseEntity<Product> updateStock(@RequestBody Long id, int stock) {
        productService.updateStock(id, stock);
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public Product deleteProduct(@RequestBody Long id) {
        Product product = productService.getProduct(id);
        productService.deleteProduct(id);
        return product;
    }
}
