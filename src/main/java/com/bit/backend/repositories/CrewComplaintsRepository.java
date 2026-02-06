package com.bit.backend.repositories;

import com.bit.backend.entities.CrewComplaintsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CrewComplaintsRepository extends JpaRepository<CrewComplaintsEntity, Long> {
  Optional<List<CrewComplaintsEntity>> findBySidNo(String sidNo);
}
