package interviews;

import java.util.Set;
import java.util.HashSet;

class QuestionList {
    // #region members
    protected Set<Question> innerList;
    // #endregion

    // #region constructor
    protected QuestionList() {
        innerList = new HashSet<Question>();
    }
    // #endregion

    // #region methods

    protected void add(Question q) {
        innerList.add(q);
    }

    protected int size(){
        return innerList.size();
    }

    /**
     * parameters are ignored in the search if experience: NONE, language: empty or
     * null, duration: null
     */
    protected Set<Question> search(Experience exp, String language, Integer duration) {
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