package com.bit.backend.repositories;

import com.bit.backend.entities.SeafarersEntity;
import com.bit.backend.entities.VesselRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface VesselRegistrationRepository extends JpaRepository<VesselRegistrationEntity, Long> {
    Optional<VesselRegistrationEntity> findByImoNo(String imoNo);
    @Query(nativeQuery = true, value = "select DATE_FORMAT(vessel_Type, '%Y-%m') as type, count(*) as cnt from ems.vessel_registration group by vessel_type order by vessel_type")
    List<Map<String, Object>> getVesselRegisteredByType();
}

