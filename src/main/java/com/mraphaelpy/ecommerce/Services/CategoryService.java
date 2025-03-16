package com.mraphaelpy.ecommerce.Services;

import com.mraphaelpy.ecommerce.Entites.Category;
import com.mraphaelpy.ecommerce.Entites.Product;
import com.mraphaelpy.ecommerce.Repository.CategoryRepository;
import com.mraphaelpy.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void addProductToCategory(Long productId, Long categoryId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        if (!category.getProducts().contains(product)) {
            category.addProduct(product);
            categoryRepository.save(category);
            productRepository.save(product);
        }
    }

    @Transactional
    public void removeProductFromCategory(Long productId, Long categoryId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        if (category.getProducts().contains(product)) {
            category.removeProduct(product);
            categoryRepository.save(category);
            productRepository.save(product);
        }
    }

    public Set<Product> getProductsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return category.getProducts();
    }
}
