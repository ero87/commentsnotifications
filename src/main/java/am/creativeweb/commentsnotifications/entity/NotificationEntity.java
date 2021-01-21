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
@Table(name = "notification")
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int notification_id;

    @NotNull
    private int comment_id;

    private java.sql.Timestamp time = new Timestamp(System.currentTimeMillis());

    private boolean delivered = true;
}
