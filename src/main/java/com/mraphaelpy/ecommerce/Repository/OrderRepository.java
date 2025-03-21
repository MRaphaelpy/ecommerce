package com.mraphaelpy.ecommerce.Repository;

import com.mraphaelpy.ecommerce.Entities.Order;
import com.mraphaelpy.ecommerce.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
