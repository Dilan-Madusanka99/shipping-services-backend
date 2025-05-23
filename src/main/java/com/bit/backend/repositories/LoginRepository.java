package com.bit.backend.repositories;

import com.bit.backend.entities.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

}
