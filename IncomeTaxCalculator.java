import java.util.Scanner;

public class IncomeTaxCalculator {

    // Function to calculate income tax and net salary
    public static void calculateIncomeTax(double grossSalary) {
        // Tax rate table as per the Ghana Revenue Authority
        double[] taxBlocks = { 402, 110, 130, 3000, 16395, 29963, 50000, Double.POSITIVE_INFINITY };
        double[] taxRates = { 0, 0.05, 0.1, 0.175, 0.25, 0.3, 0.35 };

        // Initialize variables
        double remainingSalary = grossSalary;
        double totalTax = 0;

        // Calculate tax for each block
        for (int i = 0; i < taxBlocks.length; i++) {
            if (remainingSalary <= 0) {
                break;
            }

            double taxableIncome = Math.min(remainingSalary, taxBlocks[i]);
            double taxAmount = taxableIncome * taxRates[i];
            totalTax += taxAmount;

            remainingSalary -= taxBlocks[i];
        }

        // Calculate net salary
        double netSalary = grossSalary - totalTax;

        // Display results
        System.out.println("Your Income Tax is: GH¢" + String.format("%.2f", totalTax));
        System.out.println("Your Net Monthly Salary is: GH¢" + String.format("%.2f", netSalary));
    }

    // Main method
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner keyboard = new Scanner(System.in);

        // Prompt user for gross salary
        System.out.print("Kindly enter your gross monthly salary (GH¢): ");
        double grossSalary = keyboard.nextDouble();

        // Calculate income tax and net salary
        calculateIncomeTax(grossSalary);

        // Closes the Scanner
        keyboard.close();

    }
}
