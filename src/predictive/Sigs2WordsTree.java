package predictive;

import java.util.Scanner;
import java.util.Set;

public class Sigs2WordsTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Load the dictionary
        DictionaryTreeImpl dictionary = new DictionaryTreeImpl("words");

        // Prompt user for numeric signatures if no arguments are provided
        if (args.length == 0) {
            System.out.println("Enter numeric signatures (separated by spaces):");
            String input = scanner.nextLine();
            args = input.split(" ");
        }

        // Process each signature
        for (String signature : args) {
            Set<String> words = dictionary.signatureToWords(signature);
            System.out.print(signature + " : ");
            System.out.println(words);
        }
    }
}
