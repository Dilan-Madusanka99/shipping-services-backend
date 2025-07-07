package com.bit.backend.repositories;

import com.bit.backend.entities.ItemsRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRegistrationRepository extends JpaRepository<ItemsRegistrationEntity, Long> {
}
