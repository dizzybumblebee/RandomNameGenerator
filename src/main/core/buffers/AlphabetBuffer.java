package main.core.buffers;

import main.core.LetterType;

import java.util.*;

public class AlphabetBuffer implements IAlphabetBuffer {

    private Map<LetterType, List<String>> alphabet;
    private ILetterSetLoader loader;

    public AlphabetBuffer() {
    }

    public void loadAlphabet() {
        alphabet = loader.getSets();
    }

    public String getLetter(LetterType type, int pos) {
        return alphabet.get(type).get(pos);
    }

    public int getLength(LetterType type) {
        return alphabet.get(type).size();
    }

    public int getTypeCount() {
        return alphabet.size();
    }

    public void setAlphabet(Map<LetterType, List<String>> alphabet) {
        this.alphabet = alphabet;
    }

    public void setLoader(ILetterSetLoader loader) {
        this.loader = loader;
    }

    public Map<LetterType, List<String>> getAlphabet() {
        return alphabet;
    }


}
