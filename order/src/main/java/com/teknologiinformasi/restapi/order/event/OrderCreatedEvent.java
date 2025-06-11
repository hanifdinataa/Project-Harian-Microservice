package com.teknologiinformasi.restapi.order.event;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderCreatedEvent implements Serializable {
   private String id;
   private Long productId;
   private int quantity;
   private LocalDateTime orderDate; // Ganti dari createdAt ke orderDate
   private String orderStatus; // Misal: CREATED

   public OrderCreatedEvent() {}

   public OrderCreatedEvent(String id, Long productId, int quantity, LocalDateTime orderDate, String orderStatus) {
       this.id = id;
       this.productId = productId;
       this.quantity = quantity;
       this.orderDate = orderDate;
       this.orderStatus = orderStatus;
   }

   // Getters & Setters
   public String getId() { // Perbaikan dari getid() → getId()
       return id;
   }
   public void setId(String id) { // Perbaikan dari setid() → setId()
       this.id = id;
   }
   public Long getProductId() {
       return productId;
   }
   public void setProductId(Long productId) {
       this.productId = productId;
   }
   public int getQuantity() {
       return quantity;
   }
   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }
   public LocalDateTime getOrderDate() { // Perbaikan dari getCreatedAt() → getOrderDate()
       return orderDate;
   }
   public void setOrderDate(LocalDateTime orderDate) { // Perbaikan dari setCreatedAt() → setOrderDate()
       this.orderDate = orderDate;
   }
   public String getOrderStatus() {
       return orderStatus;
   }
   public void setOrderStatus(String orderStatus) {
       this.orderStatus = orderStatus;
   }

   @Override
   public String toString() {
       return "OrderCreatedEvent{" +
               "id=" + id +
               ", productId=" + productId +
               ", quantity=" + quantity +
               ", orderDate=" + orderDate +
               ", orderStatus='" + orderStatus + '\'' +
               '}';
   }
}
