package com.oasys.PaymentService.service;

import com.oasys.PaymentService.model.PaymentRequest;
import com.oasys.PaymentService.model.PaymentResponse;

public interface PaymentService {

    long processPaymentInitiate(PaymentRequest paymentRequest);

    PaymentResponse  getPaymentDetailsByOrderId(long orderId);
}
