package com.mraphaelpy.ecommerce.Repository;

import com.mraphaelpy.ecommerce.Entites.Cart;
import com.mraphaelpy.ecommerce.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
