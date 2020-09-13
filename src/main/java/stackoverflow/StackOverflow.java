package stackoverflow;

import lombok.Getter;
import lombok.ToString;
import stackoverflow.exception.AnswerException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : alexchen
 * @created : 9/12/20, Saturday
 **/
@ToString
@Getter
public class StackOverflow {

    private static StackOverflow instance = new StackOverflow();

    private StackOverflow() {
        tagMap = new HashMap<>();
        accountMap = new HashMap<>();
        questionDB = QuestionDB.getInstance();
    }

    public static StackOverflow getInstance() {
        return instance;
    }

    private Map<Integer, Tag> tagMap;

    private Map<Integer, Account> accountMap;

    private QuestionDB questionDB;

    /*
     *
     */
    public List<Question> getAllQuestions() {
        return new ArrayList<>(questionDB.questionMap.values());
    }

    /*
     * Query by Tag
     */
    public List<Question> queryByTag(Tag tag) {
        return tag.getQuestions();
    }

    /*
     * Post a question
     */
    public Question postAQuestion(int accountId, int qId, String qText) {
        // check auth ...

        // create a question
        Question question = new Question(qId, qText, accountId);

        // add into DB
        questionDB.addQuestion(question);

        return question;
    }

    public Question postAQuestion(int accountId, int qId, String qText, List<Tag> tags) {
        Question question = postAQuestion(accountId, qId, qText);
        question.tagList.addAll(tags);
        for (Tag tag : tags) {
            tag.getQuestions().add(question);
        }
        return question;
    }

    /*
     * Answer a question
     */
    public Question postAnAnswer(int accountId, int qId, int aId, String answerText) {
        // check auth ..


        // get question
        Question question = questionDB.questionMap.get(qId);
        if (question == null) {
            throw new AnswerException();
        }

        // create an answer
        Answer answer = new Answer(aId, qId, answerText, accountId);

        // add to this question
        question.addAnswer(answer);

        return question;
    }


    public void addTags(List<Tag> tags) {
        for (Tag tag : tags) {
            tagMap.put(tag.getTagId(), tag);
        }
    }

    public void addAccounts(List<Account> accounts) {
        for (Account account : accounts) {
            accountMap.put(account.getAccountId(), account);
        }
    }
}
