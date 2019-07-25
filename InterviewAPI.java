package interviews;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

class InterviewAPI implements IInterviewAPI {

    protected QuestionList questionCatalog;
    protected List<Interview> interviews;

    protected int questionId = 0;
    protected int interviewId = 0;

    protected InterviewAPI() {
        questionCatalog = new QuestionList();
        interviews = new ArrayList<Interview>();
    }

    public void addQuestionToCatalog(String title, String desc, int duration, String language, Experience exp,
            Set<String> answers) {
        questionCatalog.add(new Question(questionId++, title, desc, duration, language, exp, answers));
    }

    public int sizeCatalog() {
        return questionCatalog.size();
    }

    public Set<Question> search(Experience exp, String language, Integer duration) {
        return questionCatalog.search(exp, language, duration);
    }

    public int createInterview(String name, String desc, int duration) {
        interviews.add(interviewId, new Interview(interviewId, name, desc, duration));
        return interviewId++;
    }

    public void addQuestionsToInterview(int interviewId, Set<Question> questions, boolean force)
            throws DurationExcedeedException, UnknownInterviewException {
        try {
            Interview current = interviews.get(interviewId);
            current.addQuestions(questions, force);
        } catch (IndexOutOfBoundsException e) {
            throw new UnknownInterviewException("interview with id " + interviewId + " not found");
        } catch (Exception e) {
            throw e;
        }
    }
}