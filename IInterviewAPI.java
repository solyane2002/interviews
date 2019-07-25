package interviews;

import java.util.Set;

public interface IInterviewAPI {
    public void addQuestionToCatalog(String title, String desc, int duration, String language, Experience exp,
            Set<String> answers);

    public int sizeCatalog();

    public Set<Question> search(Experience exp, String language, Integer duration);

    public int createInterview(String name, String desc, int duration);

    public void addQuestionsToInterview(int interviewId, Set<Question> questions, boolean force)
            throws DurationExcedeedException, UnknownInterviewException;
}