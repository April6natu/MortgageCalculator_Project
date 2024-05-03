import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter loan amount: ");
        double loanAmount = scanner.nextDouble();

        System.out.print("Enter annual interest rate (in percentage): ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Enter loan term (in years): ");
        int loanTermYears = scanner.nextInt();

        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int loanTermMonths = loanTermYears * 12;

        double monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, loanTermMonths);

        System.out.println("Monthly payment: $" + monthlyPayment);
    }

    public static double calculateMonthlyPayment(double loanAmount, double monthlyInterestRate, int loanTermMonths) {
        double monthlyPayment;
        if (monthlyInterestRate == 0) {
            monthlyPayment = loanAmount / loanTermMonths;
        } else {
            monthlyPayment = loanAmount * monthlyInterestRate /
                    (1 - Math.pow(1 + monthlyInterestRate, -loanTermMonths));
        }
        return monthlyPayment;
    }
}
