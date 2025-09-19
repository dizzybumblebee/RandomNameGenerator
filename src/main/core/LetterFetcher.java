package main.core;

import main.core.buffers.IAlphabetBuffer;

public class LetterFetcher implements ILetterFetcher{

    private IAlphabetBuffer buffer;

    @Override
    public void setBuffer(IAlphabetBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public String getRandomLetter() {
        return "";
    }

    @Override
    public String getVowel() {
        return "";
    }

    @Override
    public String getConsonant() {
        return "";
    }
}
