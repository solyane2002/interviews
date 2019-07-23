package interviews;

import java.util.Set;

public interface IQuestionList {
    public void Add(Question q);
    public int Size();

    public Set<Question> Search(Experience exp, String language, Integer duration);
}