package com.bit.backend.repositories;

import com.bit.backend.entities.SeafarersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeafarersRepository extends JpaRepository<SeafarersEntity, Long> {
}
