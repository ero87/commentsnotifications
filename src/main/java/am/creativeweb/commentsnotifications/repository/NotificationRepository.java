package am.creativeweb.commentsnotifications.repository;

import am.creativeweb.commentsnotifications.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Integer> {
    Optional<NotificationEntity> findByTime(java.sql.Timestamp time);
}
