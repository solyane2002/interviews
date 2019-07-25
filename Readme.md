# Project Interviews

The API Interviews exposes the following features through the interface:

```
IInterviewAPI
```

- search for questions according to optional parameters: candidate experience, language, question duration
- add new questions to the catalog
- create an Interview
- add questions to the Interview, with an optional check of the total duration

To get the default implementation of this interface, use:

```
InterviewAPIFactory.get()
```

### Prerequisites

Java environment, (developped with java-1.8.0-openjdk-1.8.0.212-3.b04.redhat.windows.x86_64)

## Running the tests

Coudn't make the Java Test Runner extension work on Visual Studio Code. 
Unit tests have been implemented in a main program.

Compilation:

```
>javac interviews/*.java
>javac interviews/tests/*.java
```

Run unit tests:

```
>javac interviews.tests.HomeMadeTestRunnerProgram
```

Should get the result output : 

```
*** InterviewAPITests ***
*** running test: AddQuestionShouldSucceed ***
success
*** running test: searchQuestionWithEmptyParamShouldReturnTheWholeList ***
success
*** running test: searchQuestionForJuniorShouldReturn2Items ***
success
*** running test: searchQuestionInJavaDuring5MinutsShouldReturn1Item ***
success
*** running test : addTooLongQuestionsShouldThrowAnException ***
success
*** running test : addTooLongQuestionsWithForceShouldSucceed ***
success
*** running test : addQuestionsTwiceShouldSucceed ***
success
*** running test : addQuestionWithInvalidIndexShouldThrowAnException ***
success
all tests succeeded
```


