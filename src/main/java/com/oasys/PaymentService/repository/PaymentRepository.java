package com.oasys.PaymentService.repository;

import com.oasys.PaymentService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository  extends JpaRepository<TransactionDetails, Long> {
    // This class will handle database operations related to payments
    // It can include methods for saving, updating, deleting, and retrieving payment records
    // For example:
    // public Payment save(Payment payment) {
    //     // Logic to save the payment to the database
    // }

    // Additional methods and logic can be added as needed

    TransactionDetails findByOrderID(long orderID);



}
