package com.mraphaelpy.ecommerce.Services;
import com.mraphaelpy.ecommerce.Entites.Category;
import com.mraphaelpy.ecommerce.Entites.Product;
import com.mraphaelpy.ecommerce.Repository.CategoryRepository;
import com.mraphaelpy.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;
    public void addProductToCategory(Long productId, Long categoryId) {
        Product product = productService.getProductById(productId);
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        category.getProducts().add(product);
        categoryRepository.save(category);
    }
    public void removeProductFromCategory(Long productId, Long categoryId) {
        Product product = productService.getProductById(productId);
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        category.getProducts().remove(product);
        categoryRepository.save(category);
    }
}
