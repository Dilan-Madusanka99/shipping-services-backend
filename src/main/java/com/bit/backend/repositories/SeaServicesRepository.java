package com.bit.backend.repositories;

import com.bit.backend.entities.SeaServicesEntity;
import com.bit.backend.entities.SeafarersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeaServicesRepository extends JpaRepository<SeaServicesEntity, Long> {
}
