package tech.samagua.wordz.domain;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final String correct;
    private final List<Letter> results = new ArrayList<>();
    private int position;

    public Score(String correct) {
        this.correct = correct;
    }

    public void assess(String attempt) {;
        for (char current: attempt.toCharArray()) {
            results.add(scoreFor(current));
            position++;
        }


    }

    public Letter letter(int position) {
        return results.get(position);
    }

    private boolean isCorrectLetter(char currentLetter) {
        return correct.charAt(position) == currentLetter;
    }

    private boolean occursInWord(char current) {
        return correct.contains(String.valueOf(current));
    }

    private Letter scoreFor(char current) {
        if (isCorrectLetter(current)) {
            return Letter.CORRECT;
        }

        if (occursInWord(current)) {
            return Letter.PART_CORRECT;
        }

        return Letter.INCORRECT;
    }
}
