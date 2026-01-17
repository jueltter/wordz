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

        var result = score.letter(0);

        assertEquals(Letter.INCORRECT, result);
    }

    @Test
    public void oneCorrectLetter() {
        var word = new Word("A");

        var score = word.guess("A");

        assertScoreForLetter(score, 0, Letter.CORRECT);
    }

    @Test
    void secondLetterWrongPosition() {
        var word = new Word("AR");

        var score = word.guess("ZA");

        assertScoreForLetter(score, 1, Letter.PART_CORRECT);

    }

    private void assertScoreForLetter(Score score, int position, Letter expected) {

        assertEquals(expected, score.letter(position));
    }

}
