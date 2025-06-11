package com.teknologiinformasi.restapi.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasi.restapi.order.model.Order;  // import orderr

// import com.teknologiinformasi.restapi.order.model.Produk; 


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
