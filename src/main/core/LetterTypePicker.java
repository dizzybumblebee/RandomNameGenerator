package main.core;

import main.core.patterns.TypePattern;

public class LetterTypePicker implements ILetterTypePicker {

    private TypePattern pattern;
    private LetterType lastPick;

    public LetterTypePicker() {}

    @Override
    public LetterType pickNext() {
        if (pattern == null) {
            throw new NullPointerException("No pattern assigned!");
        }
        LetterType toReturn = pattern.next();
        lastPick = toReturn;
        return toReturn;
    }

    @Override
    public LetterType getLastPick() {
        if (pattern == null) {
            throw new NullPointerException("No pattern assigned!");
        }
        else if (lastPick == null) {
            throw new NullPointerException("No picks so far!");
        }
        return lastPick;
    }

    @Override
    public void setPattern(TypePattern pattern) {
        this.pattern = pattern;
    }


}
