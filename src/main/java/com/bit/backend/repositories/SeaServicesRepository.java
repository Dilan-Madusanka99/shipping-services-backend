package com.bit.backend.repositories;

import com.bit.backend.entities.OtherDetailsRegistrationEntity;
import com.bit.backend.entities.SeaServicesEntity;
import com.bit.backend.entities.SeafarersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SeaServicesRepository extends JpaRepository<SeaServicesEntity, Long> {
    Optional<List<SeaServicesEntity>> findBySidNo(String sidNo);

    @Query(nativeQuery = true, value = "select sum(total_months) as exp from ems.Sea_Services where sid_no = :sid")
    Integer getSeafarersExp(String sid);
}
