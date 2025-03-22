package com.mraphaelpy.ecommerce.Repository;

import com.mraphaelpy.ecommerce.Entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
