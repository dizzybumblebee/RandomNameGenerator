package main.core;

public interface ILetterTypePicker {

    LetterType pickNext();
    LetterType getLast();
    LetterType setLast();
}
