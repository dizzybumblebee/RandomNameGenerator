package main.core.buffers;

import main.core.LetterType;

import java.util.List;
import java.util.Map;

public interface ILetterSetLoader {

    int getSetCount();
    Map<LetterType, List<String>> getSets();
    List<LetterType> getLetterTypes();
}
