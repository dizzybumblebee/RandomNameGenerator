import main.core.ILetterTypePicker;
import main.core.LetterTypePicker;
import main.core.LetterType;
import main.core.patterns.TypePattern;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LetterTypePickerTest {

    private ILetterTypePicker picker;
    private TypePattern pattern;

    @BeforeEach
    public void setUp() {
        picker = new LetterTypePicker();
        pattern = mock(TypePattern.class);
        when(pattern.next()).thenReturn(LetterType.VOWEL, LetterType.CONSONANT);
    }

    @Test
    public void mustHavePatternTest() {
        assertThrows(NullPointerException.class, () -> picker.pickNext());
        assertThrows(NullPointerException.class, () -> picker.getLastPick());
    }

    @Test
    public void getNextTest() {
        picker.setPattern(pattern);
        assertEquals(picker.pickNext(), LetterType.VOWEL);
    }

    @Test
    public void getLastPickTest() {
        picker.setPattern(pattern);
        picker.pickNext();
        assertEquals(picker.getLastPick(), LetterType.VOWEL);
        picker.pickNext();
        assertEquals(picker.getLastPick(), LetterType.CONSONANT);
    }

}
