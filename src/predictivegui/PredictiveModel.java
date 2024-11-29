package predictivegui;

import predictive.DictionaryTreeImpl;
import java.util.Set;

public class PredictiveModel {
    private DictionaryTreeImpl dictionary;
    private StringBuilder currentSignature;
    private Set<String> currentMatches;
    private String currentWord;

    public PredictiveModel(String dictionaryPath) {
        dictionary = new DictionaryTreeImpl(dictionaryPath);
        currentSignature = new StringBuilder();
        currentWord = "";
    }

    // Add a digit to the current signature and update matches
    public void addDigit(char digit) {
        currentSignature.append(digit);
        currentMatches = dictionary.signatureToWords(currentSignature.toString());
    }

    // Get the current set of matching words
    public Set<String> getCurrentMatches() {
        return currentMatches;
    }

    // Complete the current word
    public void completeWord() {
        if (!currentWord.isEmpty()) {
            currentWord += " ";
        }
        currentSignature.setLength(0);
    }

    // Remove the last digit (backspace functionality)
    public void removeLastDigit() {
        if (currentSignature.length() > 0) {
            currentSignature.setLength(currentSignature.length() - 1);
            currentMatches = dictionary.signatureToWords(currentSignature.toString());
        }
    }

    // Get the current numeric signature
    public String getCurrentSignature() {
        return currentSignature.toString();
    }
}
