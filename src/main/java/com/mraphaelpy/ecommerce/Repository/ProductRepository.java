package com.mraphaelpy.ecommerce.Repository;

import com.mraphaelpy.ecommerce.Entities.Category;
import com.mraphaelpy.ecommerce.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategories(Category category);
}