package am.creativeweb.commentsnotifications.controller;

import am.creativeweb.commentsnotifications.entity.CommentEntity;
import am.creativeweb.commentsnotifications.entity.NotificationEntity;
import am.creativeweb.commentsnotifications.service.CommentService;
import am.creativeweb.commentsnotifications.service.NotificationService;
import am.creativeweb.commentsnotifications.utils.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    NotificationService notificationService;

    @PostMapping("/add/comment")
    public CommentEntity addComment(@RequestBody CommentEntity commentEntity) {
        return saveComment(commentEntity);
    }

    @GetMapping("/getComments")
    Page<CommentEntity> commentsPageable(@RequestParam Optional<Integer> page) {
        return commentService.getComments(page.orElse(0));
    }

    @GetMapping("/getNotifications")
    Page<NotificationEntity> notificationsPageable(@RequestParam Optional<Integer> page) {
        return notificationService.getNotifications(page.orElse(0));
    }

    public CommentEntity saveComment(CommentEntity commentEntity) {
        CommentEntity entity = commentService.addComment(commentEntity);
        NotificationEntity notificationEntity = new NotificationEntity();
        if (entity != null) {
            try {
                notificationEntity.setComment_id(entity.getComment_id());
                notificationService.addNotification(notificationEntity);
                BusinessLogic.doSomeWorkOnCommentCreation();
            } catch (RuntimeException e) {
                commentService.deleteComment(entity);
                notificationService.deleteNotification(notificationEntity);
                e.printStackTrace();
                return  null;
            }
            try {
                BusinessLogic.doSomeWorkOnNotification();
            } catch (RuntimeException e) {
                notificationEntity.setDelivered(false);
                notificationService.addNotification(notificationEntity);
                e.printStackTrace();
            }
        }
        return entity;
    }

    public CommentEntity saveComment(CommentEntity commentEntity, CommentService commentService, NotificationService notificationService) {
        CommentEntity entity = commentService.addComment(commentEntity);
        NotificationEntity notificationEntity = new NotificationEntity();
        if (entity != null) {
            try {
                notificationEntity.setComment_id(entity.getComment_id());
                notificationService.addNotification(notificationEntity);
                BusinessLogic.doSomeWorkOnCommentCreation();
            } catch (RuntimeException e) {
                commentService.deleteComment(entity);
                notificationService.deleteNotification(notificationEntity);
                e.printStackTrace();
                return  null;
            }
            try {
                BusinessLogic.doSomeWorkOnNotification();
            } catch (RuntimeException e) {
                notificationEntity.setDelivered(false);
                notificationService.addNotification(notificationEntity);
                e.printStackTrace();
            }
        }
        return entity;
    }

}
