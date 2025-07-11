package com.bit.backend.repositories;

import com.bit.backend.entities.LoginEntity;
import com.bit.backend.entities.SeafarersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
    Optional<LoginEntity> findByUserName(String userName);
    Optional<LoginEntity> findByUserId(Long id);
}
