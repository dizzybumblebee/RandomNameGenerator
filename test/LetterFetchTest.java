import main.core.buffers.IAlphabetBuffer;
import main.core.LetterFetcher;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LetterFetchTest {

    private LetterFetcher lf;

    @BeforeEach
    public void setUp() {
        lf = new LetterFetcher();
    }

    @AfterEach
    public void tearDown() {
        lf = null;
    }

    @Test
    public void getRandomLetter() {
        IAlphabetBuffer buffer = mock(IAlphabetBuffer.class);
        lf.setBuffer(buffer);
        String test = lf.getRandomLetter();
        assertInstanceOf(String.class, test);
        assertNotNull(test);
    }

    @Test
    public void getConsonant() {
        IAlphabetBuffer buffer = mock(IAlphabetBuffer.class);
        lf.setBuffer(buffer);
        String test = lf.getConsonant();
        assertInstanceOf(String.class, test);
        assertNotNull(test);
    }

    @Test
    public void getVowel() {
        IAlphabetBuffer buffer = mock(IAlphabetBuffer.class);
        lf.setBuffer(buffer);
        String test = lf.getVowel();
        assertInstanceOf(String.class, test);
        assertNotNull(test);
    }
}
