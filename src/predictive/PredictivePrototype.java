package predictive;

import java.io.*;
import java.util.*;

public class PredictivePrototype {

    // Converts a word to its numeric signature
    public static String wordToSignature(String word) {
        StringBuffer signature = new StringBuffer();
        String[] keypad = {
            " ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        for (char ch : word.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                for (int i = 2; i <= 9; i++) {
                    if (keypad[i].indexOf(ch) != -1) {
                        signature.append(i);
                        break;
                    }
                }
            } else {
                signature.append(" "); // Replace non-alphabetic characters
            }
        }
        return signature.toString();
    }

    // Finds words matching a numeric signature
    public static Set<String> signatureToWords(String signature) {
        Set<String> words = new HashSet<>();
        try (Scanner scanner = new Scanner(new File("words"))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().toLowerCase();
                if (isValidWord(word) && wordToSignature(word).equals(signature)) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dictionary file not found: " + e.getMessage());
        }
        return words;
    }

    // Helper Method: Checks if a word contains only alphabetic characters
    private static boolean isValidWord(String word) {
        return word.chars().allMatch(Character::isLetter);
    }
}
