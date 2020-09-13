package stackoverflow;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : alexchen
 * @created : 9/12/20, Saturday
 **/
@Getter
@ToString
public class Question {

    private final int questionId;

    @Setter
    private String questionText;

    private int authorId;

    private Instant createdAt;

    @Setter
    List<Answer> answerList;

    @Setter
    List<Tag> tagList;

    @Setter
    List<Comment> commentList;

    public Question(int questionId, String text, int authorId) {
        this.questionId = questionId;
        this.questionText = text;
        this.authorId = authorId;
        this.tagList = new ArrayList<>();
        this.commentList = new ArrayList<>();
        this.answerList = new ArrayList<>();
        createdAt = Instant.now();
    }

    public void addAnswer(Answer answer) {
        this.answerList.add(answer);
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }

    public void addTag(Tag tag) {
        this.tagList.add(tag);
    }
}
