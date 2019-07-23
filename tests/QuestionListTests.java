package interviews.tests;

import java.util.Set;
import java.util.HashSet;
import interviews.*;

public class QuestionListTests {
        private static QuestionList qList;

        private static void BeforeEachTest() {
                // create a predefined question list with values
                qList = new QuestionList();
                qList.Add(new Question(1, "a question of JAVA", "a description", 10, "JAVA", Experience.JUNIOR,
                                new HashSet<String>()));
                qList.Add(new Question(2, "a question of c#", "a description", 10, "C#", Experience.MEDIUM,
                                new HashSet<String>()));
                qList.Add(new Question(3, "a question of javascript", "a description", 15, "Javascript",
                                Experience.JUNIOR, new HashSet<String>()));
                qList.Add(new Question(4, "a question for Senior", "a description", 5, "JAVA", Experience.SENIOR,
                                new HashSet<String>()));
        }

        public static void AddQuestionShouldSucceed() throws Exception {
                BeforeEachTest();
                Set<String> answers = new HashSet<String>();
                answers.add("answer1");
                answers.add("answer2");
                answers.add("answer3");
                qList.Add(new Question(1, "a title", "a description", 10, "JAVA", Experience.JUNIOR, answers));

                if (qList.Size() != 5)
                        throw new Exception("AddQuestionShouldSucceed failed : wrong size");
        }

        public static void SearchQuestionWithEmptyParamShouldReturnTheWholeList() throws Exception {
                BeforeEachTest();
                Set<Question> res = qList.Search(Experience.NONE, null, null);
                if (res.size() != 4)
                        throw new Exception(
                                        "SearchQuestionWithEmptyParamShouldReturnTheWholeList failed : expecting 4 but got "
                                                        + res.size());
        }

        public static void SearchQuestionForJuniorShouldReturn2Items() throws Exception {
                BeforeEachTest();
                Set<Question> res = qList.Search(Experience.JUNIOR, null, null);
                if (res.size() != 2)
                        throw new Exception("SearchQuestionForJuniorShouldReturn2Items failed : expecting 2 but got "
                                        + res.size());
        }

        
        public static void SearchQuestionInJavaDuring5MinutsShouldReturn1Item() throws Exception {
                BeforeEachTest();
                Set<Question> res = qList.Search(Experience.NONE, "java", 5);
                if (res.size() != 1)
                        throw new Exception("SearchQuestionInJavaDuring5MinutsShouldReturn1Item failed : expecting 1 but got "
                                        + res.size());
        }
}