package interviews.tests;


public class HomeMadeTestRunnerProgram {
    public static void main(String[] args) {

        boolean noError = true;
        try {

        System.out.println("*** InterviewAPITests ***");
        System.out.println("*** running test: AddQuestionShouldSucceed ***");
        InterviewAPITests.addQuestionShouldSucceed();
        System.out.println("success");
        System.out.println("*** running test: searchQuestionWithEmptyParamShouldReturnTheWholeList ***");
        InterviewAPITests.searchQuestionWithEmptyParamShouldReturnTheWholeList();
        System.out.println("success");
        System.out.println("*** running test: searchQuestionForJuniorShouldReturn2Items ***");
        InterviewAPITests.searchQuestionForJuniorShouldReturn2Items();
        System.out.println("success");
        System.out.println("*** running test: searchQuestionInJavaDuring5MinutsShouldReturn1Item ***");
        InterviewAPITests.searchQuestionInJavaDuring5MinutsShouldReturn1Item();
        System.out.println("success");
        System.out.println("*** running test : addTooLongQuestionsShouldThrowAnException ***");
        InterviewAPITests.addTooLongQuestionsShouldThrowAnException();
        System.out.println("success");
        System.out.println("*** running test : addTooLongQuestionsWithForceShouldSucceed ***");
        InterviewAPITests.addTooLongQuestionsWithForceShouldSucceed();
        System.out.println("success");
        System.out.println("*** running test : addQuestionsTwiceShouldSucceed ***");
        InterviewAPITests.addQuestionsTwiceShouldSucceed();
        System.out.println("success");
        System.out.println("*** running test : addQuestionWithInvalidIndexShouldThrowAnException ***");
        InterviewAPITests.addQuestionWithInvalidIndexShouldThrowAnException();
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