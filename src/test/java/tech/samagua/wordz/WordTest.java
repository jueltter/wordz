package tech.samagua.wordz;

import org.junit.jupiter.api.Test;
import tech.samagua.wordz.domain.Letter;
import tech.samagua.wordz.domain.Word;
import tech.samagua.wordz.domain.Score;

import static org.junit.jupiter.api.Assertions.*;

public class WordTest {

    @Test
    public void oneIncorrectLetter() {
        var word = new Word("A");

        var score = word.guess("Z");

        assertScoreForLetter(score, Letter.INCORRECT);
    }

    @Test
    public void oneCorrectLetter() {
        var word = new Word("A");

        var score = word.guess("A");

        assertScoreForLetter(score, Letter.CORRECT);
    }

    @Test
    void secondLetterWrongPosition() {
        var word = new Word("AR");

        var score = word.guess("ZA");

        assertScoreForLetter(score, Letter.INCORRECT, Letter.PART_CORRECT);

    }

    @Test
    void allScoreCombinations() {
        var word = new Word("ARI");

        var score = word.guess("ZAI");

        assertScoreForLetter(score, Letter.INCORRECT, Letter.PART_CORRECT, Letter.CORRECT);

    }

    private void assertScoreForLetter(Score score, Letter... expectedScores) {
        for (int position = 0; position < expectedScores.length; position++) {
            Letter expectedScore = expectedScores[position];
            assertEquals(expectedScore, score.letter(position));
        }
    }

}
