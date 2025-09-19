package main.core;

import main.core.buffers.IAlphabetBuffer;

public interface ILetterFetcher {

    void setBuffer(IAlphabetBuffer buffer);
    String getRandomLetter();
    String getVowel();
    String getConsonant();

}
