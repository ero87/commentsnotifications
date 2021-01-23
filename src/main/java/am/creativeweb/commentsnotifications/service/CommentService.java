package am.creativeweb.commentsnotifications.service;

import am.creativeweb.commentsnotifications.entity.CommentEntity;
import am.creativeweb.commentsnotifications.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public CommentEntity addComment(CommentEntity commentEntity){
        return commentRepository.save(commentEntity);
    }

    public Page<CommentEntity> getComments(int pageNumber) {
        return commentRepository.findAll(PageRequest.of(pageNumber, 10));
    }

    public void deleteComment(CommentEntity commentEntity) {
        commentRepository.delete(commentEntity);
    }

    public CommentEntity getCommentByID(int id){
        return commentRepository.findById(id).orElse(null);
    }

    public CommentEntity getCommentByCommentAndTime(String com, java.sql.Timestamp time){
        return commentRepository.findByCommentAndTime(com, time).orElse(null);
    }

}
