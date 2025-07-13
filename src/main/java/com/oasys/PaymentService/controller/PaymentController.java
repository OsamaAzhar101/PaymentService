package com.oasys.PaymentService.controller;

import com.oasys.PaymentService.model.PaymentRequest;
import com.oasys.PaymentService.model.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oasys.PaymentService.service.PaymentService;

@RestController()
@RequestMapping("/payment")
public class PaymentController {


    @Autowired
    private PaymentService paymentService;

    //create Post method to handle payment processing
    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest) {
        // Logic to process the payment using paymentService
        paymentService.processPaymentInitiate(paymentRequest);
        return ResponseEntity.ok("Payment processed successfully");
    }

    @GetMapping("/response/{oderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId
            (@PathVariable long orderId) {
        // Logic to retrieve payment response using paymentService
        PaymentResponse paymentResponse = paymentService.getPaymentDetailsByOrderId(orderId);
        return ResponseEntity.ok(paymentResponse);
    }

}
