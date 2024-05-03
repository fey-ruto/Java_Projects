import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        System.out.println("Hello,Welcome to the Guessing Game!");
        System.out.println("I’m thinking of a number between 1 and 100. Can you guess it?");

        // Generate a random number between 1 and 100
        int secretNumber = (int) (Math.random() * 100) + 1;

        // Initialize variables
        int attempts = 0;

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            // Get user's guess
            System.out.print("Guess: ");
            int guess = keyboard.nextInt();

            // Increment the number of attempts
            attempts++;

            // Check if the guess is correct
            if (guess == secretNumber) {
                System.out.println("Yes! You guessed correctly after " + attempts + " tries! Congratulations.");
                break;
            } else if (guess < secretNumber) {
                System.out.println("Good try, but that’s too low. Try again.");
            } else {
                System.out.println("Good try, but that’s too high. Try again.");
            }
        }

        // Close the scanner
        keyboard.close();
    }
}
