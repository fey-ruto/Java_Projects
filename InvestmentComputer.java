// This is a proram to compute the total value of investment and the interest earned over a period of time

// Steps involved
// 1.Receive input from the user
// 2.Compute total value of the investment by
//  a) Initializing total value of the investment
//  b)Loop through each period
//    i)Co mpute interest for the period
//    ii)Add interest to the total period
//    iii)Add deposit to the total value of each period except the first one
//    iv)Return the total value of the investment

import java.util.Scanner;

public class InvestmentComputer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input from the user
        System.out.print("Kindly enter initial amount to you want to invest : ");
        double principal = scanner.nextDouble();

        System.out.print("Kindly enter the yearly interest rate : ");

        // Convert percentage to decimal
        double rate = scanner.nextDouble() / 100;

        System.out.print("Kindly enter number of times the interest is compounded each year: ");
        int periodsPerYear = scanner.nextInt();

        System.out.print(
                "Kindly enter the amount to add to the investment account in each period after the initial one : ");
        double deposit = scanner.nextDouble();

        System.out.print("Kindly enter the number of periods the investment will accrue over : ");
        int totalPeriods = scanner.nextInt();

        // Compute total value of the investment
        double totalValue = computeInvestmentValue(principal, rate, periodsPerYear, deposit, totalPeriods);

        // Compute total interest earned
        double totalInterest = totalValue - (principal + (deposit * (totalPeriods - 1)));

        // Display the total value of the investment
        System.out.println("Total value of the investment: ¢" + totalValue);

        // Display the total interest earned over the period
        System.out.println("Total interest earned: ¢" + totalInterest);

        scanner.close();
    }

    // Method to compute the total value of the investment
    public static double computeInvestmentValue(double principal, double rate, int periodsPerYear, double deposit,
            int totalPeriods) {
        // Initialize total value of the investment
        double totalValue = principal;

        // Loop through each period
        for (int i = 1; i <= totalPeriods; i++) {
            // Compute interest for the period
            double interest = totalValue * (rate / periodsPerYear);

            // Add interest to total value
            totalValue += interest;

            // Add deposit to total value for all periods except the first one
            if (i != 1) {
                totalValue += deposit;
            }
        }

        // Return the total value of the investment
        return totalValue;

    }
}
