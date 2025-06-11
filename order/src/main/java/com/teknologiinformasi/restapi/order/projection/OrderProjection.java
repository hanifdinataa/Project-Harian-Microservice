package com.teknologiinformasi.restapi.order.projection;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teknologiinformasi.restapi.order.event.OrderCreatedEvent;
import com.teknologiinformasi.restapi.order.event.OrderUpdatedEvent;
// import com.teknologiinformasi.restapi.order.model.OrderSummary; //  Tambahkan ini
import com.teknologiinformasi.restapi.order.repository.OrderSummaryRepository; //  Tambahkan ini

@Component
public class OrderProjection {

    @Autowired
    private OrderSummaryRepository orderSummaryRepository;

    @EventHandler
    public void on(OrderCreatedEvent event) {
        OrderSummary orderSummary = new OrderSummary(
            event.getId(),
            event.getProductId(),
            event.getQuantity(),
            event.getOrderDate(), //  Pastikan method ini ada di event class
            event.getOrderStatus()
        );
        orderSummaryRepository.save(orderSummary);
    }

    @EventHandler
    public void on(OrderUpdatedEvent event) {
        OrderSummary orderSummary = orderSummaryRepository.findById(event.getOrderId())
            .orElseThrow(() -> new RuntimeException("Order not found with ID: " + event.getOrderId())); // ✅ Lebih aman
        
        orderSummary.setProductId(event.getProductId());
        orderSummary.setQuantity(event.getQuantity());
        orderSummary.setOrderDate(event.getOrderDate()); // ✅ Pastikan method ini ada di event class
        orderSummary.setOrderStatus(event.getOrderStatus());

        orderSummaryRepository.save(orderSummary);
    }
}
