import main.core.LetterType;
import main.core.patterns.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PatternTest {

    public TypePattern pattern;

    @BeforeEach
    public void setUp() {
        this.pattern = new CVPattern();
    }

    @Test
    public void testNext() {
        assertEquals(pattern.next(), LetterType.CONSONANT);
        assertEquals(pattern.next(), LetterType.VOWEL);
        assertEquals(pattern.next(), LetterType.CONSONANT);
    }

}
