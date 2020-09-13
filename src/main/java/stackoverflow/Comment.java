package stackoverflow;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

/**
 * @author : alexchen
 * @created : 9/12/20, Saturday
 **/
@ToString
@Getter
public class Comment {

    private final int commentId;

    @Setter
    private String commentText;

    private int authorId;

    private Instant createdAt;

    public Comment(int commentId, String commentText, int authorId) {
        this.commentId = commentId;
        this.commentText = commentText;
        this.authorId = authorId;
        createdAt = Instant.now();
    }
}
