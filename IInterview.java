package interviews;

import java.util.Set;
public interface IInterview {

    // to add a question set to the interview, if the total duration exceeds the
    // interview duration, an exception is thrown unless the force parameter is set
    // to true
    public void AddQuestions(Set<Question> questions, boolean force) throws DurationExcedeedException;
}
