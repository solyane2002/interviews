package interviews.tests;

import java.util.Set;
import java.util.HashSet;
import interviews.*;

public class InterviewTests {
    private static Set<Question> questionSet;

    private static void BeforeEachTest() {
        // create a predefined interview
        questionSet = new HashSet<Question>();
        questionSet.add(new Question(1, "a question of JAVA", "a description", 10, "JAVA", Experience.JUNIOR,
                new HashSet<String>()));
        questionSet.add(new Question(2, "a question of c#", "a description", 20, "C#", Experience.JUNIOR,
                new HashSet<String>()));

    }

    public static void AddTooLongQuestionsShouldThrowAnException() throws Exception {
        BeforeEachTest();
        boolean isCatched = false;
        try {
            Interview interview = new Interview(1, "interview junior", "interview for junior", 20);
            interview.AddQuestions(questionSet, false);
        } catch (DurationExcedeedException e) {
            isCatched = true;
        }
        if (!isCatched)
            throw new Exception("AddTooLongQuestionsShouldThrowAnException failed : duration exceeded not detected");
    }

    public static void AddTooLongQuestionsWithForceShouldSucceed() throws Exception {
        BeforeEachTest();
        boolean isCatched = false;
        try {
            Interview interview = new Interview(1, "interview junior", "interview for junior", 20);
            interview.AddQuestions(questionSet, true);
        } catch (DurationExcedeedException e) {
            isCatched = true;
        }
        if (isCatched)
            throw new Exception("AddTooLongQuestionsWithForceShouldSucceed failed : duration exceeded but should force");
    }

    public static void AddQuestionsTwiceShouldSucceed() throws Exception {
        BeforeEachTest();
        boolean isCatched = false;
        try {
            Interview interview = new Interview(1, "interview junior", "interview for junior", 60);
            interview.AddQuestions(questionSet, false);
            Set<Question> anotherSeries= new HashSet<Question>();
            anotherSeries.add(new Question(1, "a question for Senior", "a description", 10, "javascript", Experience.SENIOR,
                new HashSet<String>()));
                anotherSeries.add(new Question(2, "a question of javascript", "a description", 10, "C#", Experience.SENIOR,
                new HashSet<String>()));
            interview.AddQuestions(anotherSeries, false);
        } catch (DurationExcedeedException e) {
            isCatched = true;
        }
        if (isCatched)
            throw new Exception("AddQuestionsShouldSucceed failed : duration of question should be ok");
    }

}