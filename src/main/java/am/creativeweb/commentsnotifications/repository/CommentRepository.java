package am.creativeweb.commentsnotifications.repository;

import am.creativeweb.commentsnotifications.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    Optional<CommentEntity> findByCommentAndTime(String comment, java.sql.Timestamp time);
}
