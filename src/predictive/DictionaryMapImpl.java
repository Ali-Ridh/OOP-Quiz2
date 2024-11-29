package predictive;

import java.util.*;
import java.io.*;

public class DictionaryMapImpl {
    private Map<String, Set<String>> dictionary;

    public DictionaryMapImpl(String filePath) {
        dictionary = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().toLowerCase();
                if (isValidWord(word)) {
                    String signature = PredictivePrototype.wordToSignature(word);
                    dictionary.computeIfAbsent(signature, k -> new HashSet<>()).add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dictionary file not found: " + e.getMessage());
        }
    }

    public Set<String> signatureToWords(String signature) {
        return dictionary.getOrDefault(signature, new HashSet<>());
    }

    private static boolean isValidWord(String word) {
        return word.chars().allMatch(Character::isLetter);
    }
}
