import main.core.LetterType;
import main.core.buffers.AlphabetBuffer;
import main.core.buffers.LetterSetLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static main.core.LetterType.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AlphabetBufferTest {

    private AlphabetBuffer buffer;
    private Map<LetterType, List<String>> alphabet;
    private List<String> vowel;
    private List<String> consonant;
    private static final int SIZE = 50;

    @BeforeEach
    public void setUp() {
       buffer = new AlphabetBuffer();
       alphabet = new HashMap<>();
       vowel = new ArrayList<>(Collections.nCopies(SIZE, "a"));
       consonant = new ArrayList<>(Collections.nCopies(SIZE, "b"));
       alphabet.put(VOWEL, vowel);
       alphabet.put(CONSONANT, consonant);
       buffer.setAlphabet(alphabet);
    }
    @AfterEach
    public void tearDown() {
        buffer = null;
        alphabet = null;
    }

    @Test
    public void testLoadAlphabet() {
        LetterSetLoader loader = mock(LetterSetLoader.class);
        when(loader.getSets()).thenReturn(alphabet);
        buffer.setAlphabet(null);
        buffer.setLoader(loader);
        buffer.loadAlphabet();

        assertNotNull(buffer.getAlphabet());

        assertEquals("a",buffer.getLetter(VOWEL,0));
        assertEquals("b",buffer.getLetter(CONSONANT,0));

        assertEquals(2,buffer.getTypeCount());

        assertEquals(SIZE,buffer.getLength(VOWEL));
        assertEquals(SIZE,buffer.getLength(CONSONANT));
    }

    @Test
    public void testGetVowel() {
        assertEquals("a", buffer.getLetter(VOWEL, 0));
    }

    @Test
    public void testGetConsonant() {
        assertEquals("b", buffer.getLetter(CONSONANT, 0));
    }

    @Test
    public void testGetLength() {
        assertEquals(SIZE, buffer.getLength(VOWEL));
    }

    @Test
    public void testGetTypeCount() {
        assertEquals(2, buffer.getTypeCount());
    }

    @Test
    public void testIndexRange() {
        assertThrows(IndexOutOfBoundsException.class, () -> buffer.getLetter(VOWEL, SIZE+1));
    }

    @Test
    public void testNonExistentType() {
        assertThrows(NullPointerException.class, () -> buffer.getLetter(null, 0));
    }
}
