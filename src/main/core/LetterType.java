package main.core;

public enum LetterType {
    VOWEL,
    CONSONANT,
    UMLAUT;

    public static LetterType fromString(String type) {
        return switch (type) {
            case "vowel" -> VOWEL;
            case "consonant" -> CONSONANT;
            case "umlaut" -> UMLAUT;
            default -> throw new IllegalArgumentException(type);
        };
    }

    public static String toString(LetterType type) {
        return switch (type) {
            case VOWEL -> "vowel";
            case CONSONANT -> "consonant";
            case UMLAUT -> "umlaut";
            default -> throw new IllegalArgumentException();
        };
    }
}
