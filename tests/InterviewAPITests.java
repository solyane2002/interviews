package interviews.tests;

import java.util.Set;
import java.util.HashSet;
import interviews.*;

public class InterviewAPITests {
    private static IInterviewAPI api;
    private static Set<Question> questionSet;

    private static void beforeEachTest() {

        api = InterviewAPIFactory.getApi();

        api.addQuestionToCatalog("a question of JAVA", "a description", 10, "JAVA", Experience.JUNIOR,
                new HashSet<String>());
        api.addQuestionToCatalog("a question of c#", "a description", 10, "C#", Experience.MEDIUM,
                new HashSet<String>());
        api.addQuestionToCatalog("a question of javascript", "a description", 15, "Javascript", Experience.JUNIOR,
                new HashSet<String>());
        api.addQuestionToCatalog("a question for Senior", "a description", 5, "JAVA", Experience.SENIOR,
                new HashSet<String>());

        questionSet = new HashSet<Question>();
        questionSet.add(new Question(1, "a question of JAVA", "a description", 10, "JAVA", Experience.JUNIOR,
                new HashSet<String>()));
        questionSet.add(new Question(2, "a question of c#", "a description", 20, "C#", Experience.JUNIOR,
                new HashSet<String>()));
    }

    public static void addQuestionShouldSucceed() throws Exception {
        beforeEachTest();

        Set<String> answers = new HashSet<String>();
        answers.add("answer1");
        answers.add("answer2");
        answers.add("answer3");
        api.addQuestionToCatalog("a title", "a description", 10, "JAVA", Experience.JUNIOR, answers);

        if (api.sizeCatalog() != 5)
            throw new Exception("AddQuestionShouldSucceed failed : wrong size");
    }

    public static void searchQuestionWithEmptyParamShouldReturnTheWholeList() throws Exception {
        beforeEachTest();

        Set<Question> res = api.search(Experience.NONE, null, null);
        if (res.size() != 4)
            throw new Exception(
                    "searchQuestionWithEmptyParamShouldReturnTheWholeList failed : expecting 4 but got " + res.size());
    }

    public static void searchQuestionForJuniorShouldReturn2Items() throws Exception {
        beforeEachTest();

        Set<Question> res = api.search(Experience.JUNIOR, null, null);
        if (res.size() != 2)
            throw new Exception("searchQuestionForJuniorShouldReturn2Items failed : expecting 2 but got " + res.size());
    }

    public static void searchQuestionInJavaDuring5MinutsShouldReturn1Item() throws Exception {
        beforeEachTest();

        Set<Question> res = api.search(Experience.NONE, "java", 5);
        if (res.size() != 1)
            throw new Exception(
                    "searchQuestionInJavaDuring5MinutsShouldReturn1Item failed : expecting 1 but got " + res.size());
    }

    public static void addTooLongQuestionsShouldThrowAnException() throws Exception {
        beforeEachTest();

        boolean isCatched = false;
        try {
            int index = api.createInterview("interview junior", "interview for junior", 20);
            api.addQuestionsToInterview(index, questionSet, false);
        } catch (DurationExcedeedException e) {
            isCatched = true;
        }
        if (!isCatched)
            throw new Exception("AddTooLongQuestionsShouldThrowAnException failed : duration exceeded not detected");
    }

    public static void addTooLongQuestionsWithForceShouldSucceed() throws Exception {
        beforeEachTest();

        boolean isCatched = false;
        try {
            int index = api.createInterview("interview junior", "interview for junior", 20);
            api.addQuestionsToInterview(index, questionSet, true);
        } catch (DurationExcedeedException e) {
            isCatched = true;
        }
        if (isCatched)
            throw new Exception(
                    "AddTooLongQuestionsWithForceShouldSucceed failed : duration exceeded but should force");
    }

    public static void addQuestionsTwiceShouldSucceed() throws Exception {
        beforeEachTest();

        boolean isCatched = false;
        try {
            int index = api.createInterview("interview junior", "interview for junior", 60);
            api.addQuestionsToInterview(index, questionSet, true);
            Set<Question> anotherSeries = new HashSet<Question>();
            anotherSeries.add(new Question(1, "a question for Senior", "a description", 10, "javascript",
                    Experience.SENIOR, new HashSet<String>()));
            anotherSeries.add(new Question(2, "a question of javascript", "a description", 10, "C#", Experience.SENIOR,
                    new HashSet<String>()));
            api.addQuestionsToInterview(index, anotherSeries, false);
        } catch (DurationExcedeedException e) {
            isCatched = true;
        }
        if (isCatched)
            throw new Exception("AddQuestionsShouldSucceed failed : duration of question should be ok");
    }

    
    public static void addQuestionWithInvalidIndexShouldThrowAnException() throws Exception {
        beforeEachTest();

        boolean isCatched = false;
        try {
            int index = api.createInterview("interview junior", "interview for junior", 20);
            api.addQuestionsToInterview(40, questionSet, false);
        } catch (UnknownInterviewException e) {
            isCatched = true;
        }
        if (!isCatched)
            throw new Exception("addQuestionWithInvalidIndexShouldThrowAnException failed : invalid index not detected");
    }
}