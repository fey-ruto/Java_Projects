
// Import Scanner class for user input
import java.util.Scanner;

public class EssentialsStore {

    public static void main(String[] args) {

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the cost of items
        System.out.print("Enter the cost of items purchased: ");

        // Read the cost of items entered by the user
        double cost = scanner.nextDouble();

        // Prompt the user to enter the amount paid
        System.out.print("Enter the amount paid: ");

        // Read the amount paid entered by the user
        double paid = scanner.nextDouble();

        // Calculate the change and print the breakdown of denominations
        computeChangeBreakdown(cost, paid);

        scanner.close();
    }

    // Method to compute change and print breakdown of denominations
    public static void computeChangeBreakdown(double cost, double paid) {
        double change = paid - cost; // Calculate the change to give to the customer

        // Print the calculated change to give
        System.out.println("Change to give: ₵" + String.format("%.2f", change));

        // Compute and print the breakdown of denominations

    }

    // Method to calculate and print denominations
    public static void printDenomination(String denomination, double change, double value) {

        // Calculate the count of the denomination
        int count = (int) (change / value);

        // Print only if count is greater than 0
        if (count > 0) {
            System.out.println(count + " " + denomination);

            // Update the remaining change
            change -= count * value;
        }
    }
}
