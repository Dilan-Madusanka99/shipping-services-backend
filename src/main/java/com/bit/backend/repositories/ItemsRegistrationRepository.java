package com.bit.backend.repositories;

import com.bit.backend.entities.ItemsRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemsRegistrationRepository extends JpaRepository<ItemsRegistrationEntity, Long> {
    Optional<ItemsRegistrationEntity> findByItemNo(String itemNo);
}
