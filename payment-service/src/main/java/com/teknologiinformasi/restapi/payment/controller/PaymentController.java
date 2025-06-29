package com.teknologiinformasi.restapi.payment.controller;

import com.teknologiinformasi.restapi.payment.model.Payment;
import com.teknologiinformasi.restapi.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    // GET semua payment
    @GetMapping
    public List<Payment> getAllPayments() {
        log.info("GET /api/payments accessed");
        return paymentService.getAll();
    }

    // GET payment berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        log.info("GET /api/payments/{} accessed", id);
        return paymentService.getById(id)
                .map(payment -> {
                    log.info("Payment found with id {}", id);
                    return ResponseEntity.ok(payment);
                })
                .orElseGet(() -> {
                    log.warn("Payment not found with id {}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    // POST membuat payment baru
    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        log.info("POST /api/payments accessed with body: {}", payment);
        return paymentService.createPayment(payment);
    }

    // PUT update payment yang ada
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
        log.info("PUT /api/payments/{} accessed with body: {}", id, paymentDetails);
        try {
            Payment updatedPayment = paymentService.updatePayment(id, paymentDetails);
            return ResponseEntity.ok(updatedPayment);
        } catch (RuntimeException e) {
            log.warn("PUT /api/payments/{} failed: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE payment
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable Long id) {
        log.info("DELETE /api/payments/{} accessed", id);
        try {
            paymentService.deletePayment(id);
            log.info("Payment with id {} successfully deleted", id);
            return ResponseEntity.ok("Payment deleted successfully");
        } catch (RuntimeException e) {
            log.warn("DELETE /api/payments/{} failed: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}


// package com.teknologiinformasi.restapi.payment.controller;

// import com.teknologiinformasi.restapi.payment.model.Payment;
// import com.teknologiinformasi.restapi.payment.service.PaymentService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/payments")
// public class PaymentController {

//     @Autowired
//     private PaymentService paymentService;

//     // GET semua payment
//     @GetMapping
//     public List<Payment> getAllPayments() {
//         return paymentService.getAll();
//     }

//     // GET payment berdasarkan id
//     @GetMapping("/{id}")
//     public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
//         return paymentService.getById(id)
//                 .map(payment -> ResponseEntity.ok(payment))
//                 .orElse(ResponseEntity.notFound().build());
//     }

//     // POST membuat payment baru
//     @PostMapping
//     public Payment createPayment(@RequestBody Payment payment) {
//         return paymentService.createPayment(payment);
//     }

//     // PUT update payment yang ada
//     @PutMapping("/{id}")
//     public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
//         try {
//             Payment updatedPayment = paymentService.updatePayment(id, paymentDetails);
//             return ResponseEntity.ok(updatedPayment);
//         } catch (RuntimeException e) {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     // DELETE payment
//     @DeleteMapping("/{id}")
//     public ResponseEntity<?> deletePayment(@PathVariable Long id) {
//         try {
//             paymentService.deletePayment(id);
//             return ResponseEntity.ok("Payment deleted successfully");
//         } catch (RuntimeException e) {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }