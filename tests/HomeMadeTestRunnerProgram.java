package interviews.tests;

import interviews.*;

public class HomeMadeTestRunnerProgram {
    public static void main(String[] args) {
        boolean noError = true;
        try {

            System.out.println("*** Questions ***");
            System.out.println("*** running test : AddQuestionShouldSucceed ***");
            QuestionListTests.AddQuestionShouldSucceed();
            System.out.println("success");
            System.out.println("*** running test : SearchQuestionWithEmptyParamShouldReturnTheWholeList ***");           
            QuestionListTests.SearchQuestionWithEmptyParamShouldReturnTheWholeList();
            System.out.println("success");
            System.out.println("*** running test : SearchQuestionForJuniorShouldReturn2Items ***");           
            QuestionListTests.SearchQuestionForJuniorShouldReturn2Items();
            System.out.println("success");
            System.out.println("*** running test : SearchQuestionInJavaDuring5MinutsShouldReturn1Item ***");           
            QuestionListTests.SearchQuestionInJavaDuring5MinutsShouldReturn1Item();
            System.out.println("success");
            System.out.println("*** Interviews ***");
            System.out.println("*** running test : SetQuestionsShouldThrowAnException ***");           
            InterviewTests.AddTooLongQuestionsShouldThrowAnException();
            System.out.println("success");
            System.out.println("*** running test : AddTooLongQuestionsShouldThrowAnException ***");           
            InterviewTests.AddTooLongQuestionsWithForceShouldSucceed();
            System.out.println("success");
            System.out.println("*** running test : AddQuestionsTwiceShouldSucceed ***");           
            InterviewTests.AddQuestionsTwiceShouldSucceed();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("test failed " + e);
            noError = false;
        }
        if (noError){
            System.out.println("all tests succeeded");
        }
    }
}