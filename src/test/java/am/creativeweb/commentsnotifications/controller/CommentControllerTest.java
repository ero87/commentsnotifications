package am.creativeweb.commentsnotifications.controller;

import am.creativeweb.commentsnotifications.entity.CommentEntity;
import am.creativeweb.commentsnotifications.service.CommentService;
import am.creativeweb.commentsnotifications.service.NotificationService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CommentControllerTest {

    @MockBean
    CommentService commentService;

    @MockBean
    NotificationService notificationService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSumForFailur() {
        CommentController commentController = new CommentController();
        int successAdd = 0;
        for (int i = 0; i < 1000; i++) {
            CommentEntity commentEntity = new CommentEntity("test" + i);
            CommentEntity generatedCommentEntity = commentController.saveComment(commentEntity, commentService, notificationService);
            if (generatedCommentEntity != null) {
                successAdd++;
                Assertions.assertNotNull(commentService.getCommentByID(generatedCommentEntity.getComment_id()));
                Assertions.assertNotNull(notificationService.getNotificationByCommentID(generatedCommentEntity.getComment_id()));
            } else {
                Assertions.assertNull(commentService.getCommentByCommentAndTime(commentEntity.getComment(),
                        commentEntity.getTime()));
                Assertions.assertNull(notificationService.getNotificationByTime(commentEntity.getTime()));
            }
        }
        int dis = successAdd * 100 / 1000;
        int mark = successAdd * 100 % 1000;
        String doubleAsString = dis + "." + mark;
        double percent = Double.parseDouble(doubleAsString);
        System.out.println("successfully passed " + percent + "% of the test");
        System.out.println("failed " + (100 - percent) + "% of the test");
    }
}