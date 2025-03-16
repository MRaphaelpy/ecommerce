package com.mraphaelpy.ecommerce.Controllers;

import com.mraphaelpy.ecommerce.Entites.Product;
import com.mraphaelpy.ecommerce.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add-product")
    public ResponseEntity<Void> addProductToCategory(@RequestParam Long productId, @RequestParam Long categoryId) {
        categoryService.addProductToCategory(productId, categoryId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove-product")
    public ResponseEntity<Void> removeProductFromCategory(@RequestParam Long productId, @RequestParam Long categoryId) {
        categoryService.removeProductFromCategory(productId, categoryId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<Set<Product>> getProductsByCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getProductsByCategory(id));
    }
}
