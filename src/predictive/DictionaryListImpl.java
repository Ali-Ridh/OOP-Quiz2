package predictive;

import java.io.*;
import java.util.*;

public class DictionaryListImpl {
    private List<WordSig> dictionary;

    public DictionaryListImpl(String filePath) {
        dictionary = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().toLowerCase();
                if (isValidWord(word)) {
                    dictionary.add(new WordSig(word, PredictivePrototype.wordToSignature(word)));
                }
            }
            Collections.sort(dictionary); // Sort by signature
        } catch (FileNotFoundException e) {
            System.err.println("Dictionary file not found: " + e.getMessage());
        }
    }

    public Set<String> signatureToWords(String signature) {
        Set<String> words = new HashSet<>();

        WordSig key = new WordSig("", signature);
        int index = Collections.binarySearch(dictionary, key);

        if (index >= 0) {
            // Add all matching words (scan up and down the list)
            int i = index;
            while (i >= 0 && dictionary.get(i).getSignature().equals(signature)) {
                words.add(dictionary.get(i).getWord());
                i--;
            }
            i = index + 1;
            while (i < dictionary.size() && dictionary.get(i).getSignature().equals(signature)) {
                words.add(dictionary.get(i).getWord());
                i++;
            }
        }

        return words;
    }

    private static boolean isValidWord(String word) {
        return word.chars().allMatch(Character::isLetter);
    }
}
