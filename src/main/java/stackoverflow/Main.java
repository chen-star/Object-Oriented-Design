package stackoverflow;

import java.util.Collections;

/**
 * @author : alexchen
 * @created : 9/12/20, Saturday
 **/
public class Main {

    public static void main(String[] args) {
        // init
        StackOverflow stackOverflow = StackOverflow.getInstance();

        Account account1 = new Account(1, "Alex");
        Account account2 = new Account(2, "Olivia");
        stackOverflow.getAccountMap().put(account1.getAccountId(), account1);
        stackOverflow.getAccountMap().put(account2.getAccountId(), account2);

        Tag tag1 = new Tag(1, "Java");
        Tag tag2 = new Tag(2, "Python");
        Tag tag3 = new Tag(3, "OOD");
        stackOverflow.getTagMap().put(1, tag1);
        stackOverflow.getTagMap().put(2, tag2);
        stackOverflow.getTagMap().put(3, tag3);


        // post 3 questions
        stackOverflow.postAQuestion(account1.getAccountId(), 1,
                "What is Encapsulation in Java?", Collections.singletonList(tag1));
        stackOverflow.postAQuestion(account2.getAccountId(), 2,
                "What is Spring Framework", Collections.singletonList(tag1));
        stackOverflow.postAQuestion(account2.getAccountId(), 3,
                "What is Python interpreter", Collections.singletonList(tag2));

        // view all questions
        System.out.println(stackOverflow.getAllQuestions());

        // query by tag
        System.out.println(stackOverflow.queryByTag(tag1));

        // answer q1
        stackOverflow.postAnAnswer(account2.getAccountId(), 1, 1, "Hide unnecessary info from users");
        System.out.println(stackOverflow.getQuestionDB().questionMap.get(1));
    }
}
