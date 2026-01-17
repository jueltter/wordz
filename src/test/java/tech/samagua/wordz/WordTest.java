package tech.samagua.wordz;

import org.junit.jupiter.api.Test;
import tech.samagua.wordz.domain.Letter;
import tech.samagua.wordz.domain.Word;

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

        var result = score.letter(0);
        assertEquals(Letter.CORRECT, result);
    }

}
