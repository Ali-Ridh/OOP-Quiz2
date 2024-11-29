package predictive;

import java.util.Scanner;
import java.util.Set;

public class Sigs2WordsProto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // // Prompt user for numeric signatures if no command-line arguments are provided
        if (args.length == 0) {
            System.out.println("Enter numeric signatures (separated by spaces):");
            String input = scanner.nextLine();
            args = input.split(" ");
            
        }
        scanner.close();

        // Convert each signature to words and display the results
        for (String signature : args) {
            Set<String> words = PredictivePrototype.signatureToWords(signature);
            System.out.print(signature + " : ");
            System.out.println(words);

        }
    }
}
