package am.creativeweb.commentsnotifications.service;

import am.creativeweb.commentsnotifications.entity.NotificationEntity;
import am.creativeweb.commentsnotifications.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public NotificationEntity addNotification(NotificationEntity notificationEntity) {
        return notificationRepository.save(notificationEntity);
    }

    public Page<NotificationEntity> getNotifications(int pageNumber) {
        return notificationRepository.findAll(PageRequest.of(pageNumber, 10));
    }

    public void deleteNotification(NotificationEntity notificationEntity) {
        notificationRepository.delete(notificationEntity);
    }

    public Object getNotificationByCommentID(int id) {
        return notificationRepository.findById(id);
    }

    public NotificationEntity getNotificationByTime(java.sql.Timestamp time) {
        return notificationRepository.findByTime(time).orElse(null);
    }

}
