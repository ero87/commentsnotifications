package am.creativeweb.commentsnotifications.repository;

import am.creativeweb.commentsnotifications.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Integer> {
}
