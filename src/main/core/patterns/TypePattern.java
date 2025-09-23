package main.core.patterns;

import main.core.LetterType;

import java.util.List;

public abstract class TypePattern {

    private int position = 0;
    private final List<LetterType> pattern;

    protected TypePattern() {
        this.pattern = List.copyOf(buildPattern());
        if (pattern.isEmpty()) {
            throw new IllegalArgumentException("Pattern cannot be empty");
        }
    }

    public LetterType next() {
        LetterType next = pattern.get(position);
        position = (position + 1) % pattern.size();
        return next;
    }

    public int getPosition() {
        return position;
    }

    abstract List<LetterType> buildPattern();

}
