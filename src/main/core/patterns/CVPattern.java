package main.core.patterns;

import main.core.LetterType;

import java.util.ArrayList;
import java.util.List;

public class CVPattern extends TypePattern {
    private List<LetterType> pattern;
    private int position = 0;

    public CVPattern() {
        super();
    }

    protected List<LetterType> buildPattern() {
        List<LetterType> pattern = new ArrayList<>(List.of(LetterType.CONSONANT, LetterType.VOWEL));
        return pattern;
    }

}