package com.mraphaelpy.ecommerce.Services;

import com.mraphaelpy.ecommerce.Entites.Order;
import com.mraphaelpy.ecommerce.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    protected OrderRepository orderRepository;

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public java.util.List<Order> getAll() {
        return orderRepository.findAll();
    }
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order store(Order order) {
        orderRepository.save(order);
        return order;
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

}
