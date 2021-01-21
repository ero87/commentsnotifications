package am.creativeweb.commentsnotifications.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity implements Serializable {

    public CommentEntity(String comment) {
        this.comment = comment;
    }

    public CommentEntity(String comment, java.sql.Timestamp time) {
        this.comment = comment;
        this.time = time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int comment_id;

    @NotNull
    private String comment;

    private java.sql.Timestamp time = new Timestamp(System.currentTimeMillis()); //2021-01-18T17:43:34.679+00:00
}
