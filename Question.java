package interviews;

import java.util.Set;

public class Question {

    // #region members
    protected int id;
    protected String title;
    protected String description;
    protected int duration; // number of minuts
    protected Set<String> answers;
    protected String language;
    protected Experience experience;
    // #endregion

    // #region getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public Set<String> getAnswers() {
        return answers;
    }

    public String getLanguage() {
        return language;
    }

    public Experience getExperience() {
        return experience;
    }
    // #endregion

    // #region constructors
    public Question(int id, String title, String desc, int duration, String language, Experience exp,
            Set<String> answers) {
        this.id = id;
        this.title = title;
        this.description = desc;
        this.duration = duration;
        this.answers = answers;
        this.language = language;
        this.experience = exp;
    }
    // #endregion

    // #region overrides
    public String toString() {
        return "id: " + id + " / title: " + title + " / duration: " + duration + " / language: " + language
                + " / experience: " + experience;
    }
    // #endregion
}