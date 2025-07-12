package com.oasys.PaymentService.service;

import com.oasys.PaymentService.model.PaymentRequest;

public interface PaymentService {

    long processPayment(PaymentRequest paymentRequest);
}
