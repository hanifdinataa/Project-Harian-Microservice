package com.teknologiinformasi.restapi.order.controller;

import com.teknologiinformasi.restapi.order.model.Order;
import com.teknologiinformasi.restapi.order.projection.OrderSummary;
import com.teknologiinformasi.restapi.order.repository.OrderRepository;
import com.teknologiinformasi.restapi.order.repository.OrderSummaryRepository;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orders/query")
public class OrderQueryController {


   @Autowired
   private OrderSummaryRepository orderRepository;


   @GetMapping
   public ResponseEntity<List<OrderSummary> > getAllOrders() {
       List<OrderSummary>  orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
   }


   @GetMapping("/{id}")
   public ResponseEntity<OrderSummary> getOrderById(@PathVariable String id) {
        return orderRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
   }
}




