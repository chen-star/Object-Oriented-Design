package stackoverflow;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

/**
 * @author : alexchen
 * @created : 9/12/20, Saturday
 **/
@Getter
@ToString
public class Answer {

    private final int answerId;

    private final int questionId;

    @Setter
    private String answerText;

    private int authorId;

    private Instant createdAt;

    List<Comment> comments;

    public Answer(int answerId, int questionId, String answerText, int authorId) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.answerText = answerText;
        this.authorId = authorId;
        createdAt = Instant.now();
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}
