package interviews;

import java.util.HashSet;
import java.util.Set;

class Interview {
    // #region members
    protected int id;
    protected String name;
    protected String description;
    protected int duration; // number of minuts
    protected Set<Question> questions;
    // #endregion

    // #region getters
    protected int getId() {
        return id;
    }

    protected String getName() {
        return name;
    }

    protected String getDescription() {
        return description;
    }

    protected int getDuration() {
        return duration;
    }

    protected Set<Question> getQuestions() {
        return questions;
    }
    // #endregion

    // #region contructors
    protected Interview(int id, String name, String desc, int duration) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.duration = duration;
        this.questions = new HashSet<Question>();
    }
    // #endregion

    // #region overrides
    public String toString() {
        return "id: " + id + " / name: " + name + " / duration: " + duration;
    }
    // #endregion

    // #region methods

    protected void addQuestions(Set<Question> questions, boolean force) throws DurationExcedeedException {
        if (questions == null) {
            return;
        }
        // if ! force : calculate the total duration
        if (!force) {
            int totalDuration = 0;
            // first sum the existing question durations if any
            for (Question var : this.questions) {
                totalDuration += var.duration;
            }
            // then, add the new question durations
            for (Question var : questions) {
                totalDuration += var.duration;
            }
            // if the total exceeds the interview duration, raises an exception
            if (totalDuration > this.duration)
                throw new DurationExcedeedException("The total duration of the set of questions (" + totalDuration
                        + ") exceeds the interview duration (" + this.duration + ")");
        }
    }
    //#endregion
}