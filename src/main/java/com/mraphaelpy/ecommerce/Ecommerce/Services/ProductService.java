package com.mraphaelpy.ecommerce.Ecommerce.Services;

import com.mraphaelpy.ecommerce.Ecommerce.Entites.Product;
import com.mraphaelpy.ecommerce.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    protected ProductRepository productRepository;

    public Product store(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void updateStock(Long id, int stock) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setStock(stock);
            productRepository.save(product);
        }
    }

    public java.util.List<Product> getAll() {
        return productRepository.findAll();
    }
}