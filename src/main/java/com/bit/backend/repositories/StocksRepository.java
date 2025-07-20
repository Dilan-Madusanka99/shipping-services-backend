package com.bit.backend.repositories;

import com.bit.backend.entities.StocksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StocksRepository extends JpaRepository<StocksEntity, Long> {
    StocksEntity findById(String itemNo);
    StocksEntity findByItemNo(String string);
}
