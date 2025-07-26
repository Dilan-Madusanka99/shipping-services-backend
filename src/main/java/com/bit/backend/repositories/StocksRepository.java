package com.bit.backend.repositories;

import com.bit.backend.entities.StocksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StocksRepository extends JpaRepository<StocksEntity, Long> {
    StocksEntity findByItemNo(String string); // quantity update to payment and stock modules
    Optional<StocksEntity> findByitemNo(String itemNo);
}
