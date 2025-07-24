package com.bit.backend.repositories;

import com.bit.backend.entities.SeafarersEntity;
import com.bit.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SeafarersRepository extends JpaRepository<SeafarersEntity, Long> {
    Optional<SeafarersEntity> findBySidNo(String sidNo);

    @Query(nativeQuery = true, value = "select DATE_FORMAT(applied_date, '%Y-%m') as month, count(*) as cnt from ems.seafarers_registration group by month order by month")
    List<Map<String, Object>> getSeafarersRegisteredByMonth();
}
