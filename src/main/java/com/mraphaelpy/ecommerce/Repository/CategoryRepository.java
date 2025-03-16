package com.mraphaelpy.ecommerce.Repository;

import com.mraphaelpy.ecommerce.Entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
