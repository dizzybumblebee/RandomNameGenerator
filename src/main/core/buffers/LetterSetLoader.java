package main.core.buffers;

import main.core.LetterType;

import java.io.*;
import java.util.*;

public class LetterSetLoader implements ILetterSetLoader {

    private String lang;
    private List<LetterType> letterTypes;

    public LetterSetLoader(String lang) {
        this.lang = lang;
    }

    @Override
    public int getSetCount() {
        return letterTypes.size();
    }

    public void loadLetterTypes() {
        List<LetterType> letterTypes = new ArrayList<>();
        try (InputStream in = getClass().getResourceAsStream("/alphabets/" + lang + "/manifest.txt")) {
            if (in == null) {
                throw new FileNotFoundException("manifest.txt not found in classpath");
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                reader.lines()
                        .map(LetterType::fromString)
                        .forEach(letterTypes::add);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading manifest.txt", e);
        }
        this.letterTypes = letterTypes;
    }

    public Map<LetterType,List<String>> getSets() {
        Map<LetterType, List<String>> sets = new HashMap<>();

        for (LetterType type : letterTypes) {
            List<String> set = new ArrayList<>();
            try (InputStream in = getClass().getResourceAsStream("/alphabets/" + lang + "/" + type + ".csv")) {
                if (in == null) {
                    throw new FileNotFoundException(LetterType.toString(type) + ".txt not found in classpath");
                }
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                    Arrays.stream(reader.readLine().split(","))
                            .forEach(set::add);
                }
            } catch (IOException e) {
                throw new RuntimeException("Error reading manifest.txt", e);
            }
            sets.put(type, set);
        }
        return sets;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return this.lang;
    }

    public List<LetterType> getLetterTypes() {
        return this.letterTypes;
    }

}
