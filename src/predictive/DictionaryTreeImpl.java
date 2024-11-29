package predictive;

import java.util.*;
import java.io.*;

public class DictionaryTreeImpl {
    private TreeNode root;

    public DictionaryTreeImpl(String filePath) {
        root = new TreeNode();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().toLowerCase();
                if (isValidWord(word)) {
                    addWord(PredictivePrototype.wordToSignature(word), word);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dictionary file not found: " + e.getMessage());
        }
    }

    private void addWord(String signature, String word) {
        TreeNode current = root;
        for (char digit : signature.toCharArray()) {
            int index = digit - '2';
            if (current.children[index] == null) {
                current.children[index] = new TreeNode();
            }
            current = current.children[index];
            current.words.add(word);
        }
    }

    public Set<String> signatureToWords(String signature) {
        TreeNode current = root;
        for (char digit : signature.toCharArray()) {
            int index = digit - '2';
            if (current.children[index] == null) {
                return new HashSet<>();
            }
            current = current.children[index];
        }
        return current.words;
    }

    private static boolean isValidWord(String word) {
        return word.chars().allMatch(Character::isLetter);
    }

    // TreeNode represents each node in the tree
    private static class TreeNode {
        private Set<String> words;
        private TreeNode[] children;

        public TreeNode() {
            words = new HashSet<>();
            children = new TreeNode[8]; // 2–9, so 8 possible children
        }
    }
}
