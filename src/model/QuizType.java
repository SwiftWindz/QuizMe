package model;

public enum QuizType {
    NOTE, 
    SCORE,
    UNKNOWN;

    @Override
    public String toString() {
        switch(this) {
            case NOTE: return "Note";
            case SCORE: return "Score";
            default: return "Unknown";
        }
    }
}
