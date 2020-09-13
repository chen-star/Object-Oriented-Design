package stackoverflow;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alexchen
 * @created : 9/12/20, Saturday
 **/
@Getter
public class Tag {

    private final int tagId;

    private final String tagName;

    private List<Question> questions;

    public Tag(int tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.questions = new ArrayList<>();
    }

    public Tag(int tagId, String tagName, List<Question> questions) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.questions = new ArrayList<>(questions);
    }

    public String toString() {
        return tagId + " " + tagName;
    }
}
