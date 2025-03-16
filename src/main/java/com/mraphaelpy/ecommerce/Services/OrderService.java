package com.mraphaelpy.ecommerce.Services;

import com.mraphaelpy.ecommerce.Entites.Order;
import com.mraphaelpy.ecommerce.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order store(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com ID: " + id));
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = getOrder(id);

        order.setDate(orderDetails.getDate());
        order.setUser(orderDetails.getUser());
        order.setItems(orderDetails.getItems());

        return orderRepository.save(order);
    }

    public void delete(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado para exclusão com ID: " + id);
        }
        orderRepository.deleteById(id);
    }
}
