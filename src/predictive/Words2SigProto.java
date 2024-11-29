package predictive;

import java.util.Scanner;

public class Words2SigProto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for words if no command-line arguments are provided
        if (args.length == 0) {
            System.out.println("Enter words (separated by spaces):");
            String input = scanner.nextLine();
            args = input.split(" ");
        }

        // Display input
        System.out.print("Input: ");
        for (String word : args) {
            System.out.print(word + " ");
        }
        System.out.println();

        // Convert words to signatures and display the result
        System.out.print("Output: ");
        for (String word : args) {
            System.out.print(PredictivePrototype.wordToSignature(word) + " ");
        }
        System.out.println();
    }
}