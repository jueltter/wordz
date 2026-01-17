package tech.samagua.wordz.domain;

public class Score {
    private final String correct;
    private Letter result = Letter.INCORRECT;
    private int position;

    public Score(String correct) {
        this.correct = correct;
    }

    public void assess(int position, String attempt) {;
        if (isCorrectLetter(attempt)) {
            result = Letter.CORRECT;

        }
    }

    public Letter letter(int position) {
        return result;
    }

    private boolean isCorrectLetter(String attempt) {
        return correct.charAt(position) == attempt.charAt(position);
    }
}
