package com.bit.backend.repositories;

import com.bit.backend.entities.PaymentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentsRepository extends JpaRepository<PaymentsEntity, Long> {
    Optional<PaymentsEntity> findByPaymentNo(String paymentNo);
}
