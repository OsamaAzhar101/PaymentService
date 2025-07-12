package com.oasys.PaymentService.service;

import com.oasys.PaymentService.entity.TransactionDetails;
import com.oasys.PaymentService.model.PaymentRequest;
import com.oasys.PaymentService.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public long processPayment(PaymentRequest paymentRequest) {

        log.info("Processing payment for Order ID: {}", paymentRequest.getOrderId());

        TransactionDetails transactionDetails = TransactionDetails.builder()
                .amount(paymentRequest.getAmount())
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .orderID(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .paymentStatus("SUCCESS")
                .build();


       paymentRepository.save(transactionDetails);
        log.info("Payment processed successfully for Order ID: {}",
                paymentRequest.getOrderId());

        return transactionDetails.getTransactionId();

    }
}
