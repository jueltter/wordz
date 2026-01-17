package tech.samagua.wordz.domain;

public class Score {
    private final String correct;
    private Letter result = Letter.INCORRECT;
    private int position;

    public Score(String correct) {
        this.correct = correct;
    }

    public void assess(String attempt) {;
        for (char current: attempt.toCharArray()) {
            if (isCorrectLetter(current)) {
                result = Letter.CORRECT;
            } else if (occursInWord(current)) {
                result = Letter.PART_CORRECT;
            }
            position++;
        }


    }

    public Letter letter(int position) {
        return result;
    }

    private boolean isCorrectLetter(char currentLetter) {
        return correct.charAt(position) == currentLetter;
    }

    private boolean occursInWord(char current) {
        return correct.contains(String.valueOf(current));
    }
}
