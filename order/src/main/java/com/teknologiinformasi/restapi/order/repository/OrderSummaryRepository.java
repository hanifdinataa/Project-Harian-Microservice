package com.teknologiinformasi.restapi.order.repository;
// com.teknologiinformasi.restapi.order.repository.OrderSummaryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import com.teknologiinformasi.restapi.order.model.Order;  // import orderr
import com.teknologiinformasi.restapi.order.projection.OrderSummary;

// import com.teknologiinformasi.restapi.order.model.Produk; 


@Repository
public interface OrderSummaryRepository extends JpaRepository<OrderSummary, String> {
}
