package main.core.buffers;

import main.core.LetterType;

public interface IAlphabetBuffer {

    void loadAlphabet();

    String getLetter(LetterType type, int pos);
}
