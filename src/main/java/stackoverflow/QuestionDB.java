package stackoverflow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : alexchen
 * @created : 9/12/20, Saturday
 **/
public class QuestionDB {

    private static QuestionDB instance = new QuestionDB();

    private QuestionDB() {
        questionMap = new HashMap<>();
    }

    public static QuestionDB getInstance() {
        return instance;
    }

    Map<Integer, Question> questionMap;

    public void addQuestion(Question question) {
        questionMap.put(question.getQuestionId(), question);
    }
}
