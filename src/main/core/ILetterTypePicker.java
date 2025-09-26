package main.core;

import main.core.patterns.TypePattern;

public interface ILetterTypePicker {

    LetterType pickNext();
    LetterType getLastPick();
    void setPattern(TypePattern pattern);

}
