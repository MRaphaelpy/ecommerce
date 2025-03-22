package com.mraphaelpy.ecommerce.Services;

import com.mraphaelpy.ecommerce.Entities.OrderItem;
import com.mraphaelpy.ecommerce.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem store(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem update(Long id, OrderItem orderItemDetails) {
        OrderItem existingOrderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item do pedido nao encontrado com ID: " + id));

        existingOrderItem.setProduct(orderItemDetails.getProduct());
        existingOrderItem.setQuantity(orderItemDetails.getQuantity());

        return orderItemRepository.save(existingOrderItem);
    }

    public void delete(Long id) {
        if (!orderItemRepository.existsById(id)) {
            throw new RuntimeException("Item do pedido nao encontrado ID: " + id);
        }
        orderItemRepository.deleteById(id);
    }
}
