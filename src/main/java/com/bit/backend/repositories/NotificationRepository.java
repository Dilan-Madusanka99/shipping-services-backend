package com.bit.backend.repositories;

import com.bit.backend.entities.NotificationEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

    @Query(nativeQuery = true, value = "select * from notification where target_user = :id order by id desc")
    List<NotificationEntity> getUserNotification(String id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE notification SET read_status = 1 WHERE target_user = :userId")
    int markAllAsRead(@Param("userId") int userId);
}
