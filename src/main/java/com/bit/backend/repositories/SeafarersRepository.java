package com.bit.backend.repositories;

import com.bit.backend.entities.SeafarersEntity;
import com.bit.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeafarersRepository extends JpaRepository<SeafarersEntity, Long> {
    Optional<SeafarersEntity> findBySidNo(String sidNo);
}
