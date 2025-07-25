package com.bit.backend.repositories;

import com.bit.backend.entities.PaymentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PaymentsRepository extends JpaRepository<PaymentsEntity, Long> {
    Optional<PaymentsEntity> findByPaymentNo(String paymentNo);

    @Query(nativeQuery = true, value = "select DATE_FORMAT(payment_date, '%Y-%m') as month, SUM(amount) as cnt from ems.payments group by month order by month")
    List<Map<String, Object>> getPaymentsByMonth();
}
