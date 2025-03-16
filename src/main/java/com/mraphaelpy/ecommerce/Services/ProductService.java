package com.mraphaelpy.ecommerce.Services;

import com.mraphaelpy.ecommerce.Entites.Category;
import com.mraphaelpy.ecommerce.Entites.Product;
import com.mraphaelpy.ecommerce.Exceptions.ProductNotFoundException;
import com.mraphaelpy.ecommerce.Repository.CategoryRepository;
import com.mraphaelpy.ecommerce.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product store(Product product) {
        if (product.getCategories() != null) {
            for (Category category : product.getCategories()) {
                categoryRepository.findById(category.getId())
                        .orElseThrow(() -> new RuntimeException("Categoria não encontrada."));
            }
        }
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado com ID: " + id));
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Transactional
    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());

        if (productDetails.getCategories() != null) {
            for (Category category : productDetails.getCategories()) {
                Category foundCategory = categoryRepository.findById(category.getId())
                        .orElseThrow(() -> new RuntimeException("Categoria não encontrada."));
                product.addCategory(foundCategory);
            }
        }

        return productRepository.save(product);
    }

    @Transactional
    public void updateStock(Long id, int stock) {
        productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado com ID: " + id))
                .setStock(stock);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Produto não encontrado para exclusão com ID: " + id);
        }
        productRepository.deleteById(id);
    }
}