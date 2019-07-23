package interviews;

import java.util.Set;
import java.util.HashSet;

public class QuestionList implements IQuestionList {
    // #region members
    protected Set<Question> innerList;
    // #endregion

    // #region constructor
    public QuestionList() {
        innerList = new HashSet<Question>();
    }
    // #endregion

    // #region IQuestionList implementation

    public void Add(Question q) {
        innerList.add(q);
    }

    public int Size(){
        return innerList.size();
    }

    /**
     * parameters are ignored in the search if experience: NONE, language: empty or
     * null, duration: null
     */
    public Set<Question> Search(Experience exp, String language, Integer duration) {
        Set<Question> result = new HashSet<Question>();
        for (Question var : innerList) {
            if ((exp == Experience.NONE || exp == var.experience)
                    && (language == null || language.length() == 0 || language.equalsIgnoreCase(var.language))
                    && (duration == null || duration == var.duration)) {
                result.add(var);
            }
        }
        return result;
    }
    // #endregion
}