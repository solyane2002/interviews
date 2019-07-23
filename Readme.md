# Project Interviews

The API Interviews exposes the following features:

- search for questions according to optional parameters: candidate experience, language, question duration
- add new questions to the catalog
- create an Interview
- add questions to the Interview, with an optional check of the total duration

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
*** Questions ***
*** running test : AddQuestionShouldSucceed ***
success
*** running test : SearchQuestionWithEmptyParamShouldReturnTheWholeList ***
success
*** running test : SearchQuestionForJuniorShouldReturn2Items ***
success
*** running test : SearchQuestionInJavaDuring5MinutsShouldReturn1Item ***
success
*** Interviews ***
*** running test : SetQuestionsShouldThrowAnException ***
success
*** running test : AddTooLongQuestionsShouldThrowAnException ***
success
*** running test : AddQuestionsTwiceShouldSucceed ***
success
all tests succeeded
```


