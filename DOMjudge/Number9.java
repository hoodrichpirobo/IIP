import java.util.*;

public class Number9 {

    public static void main(String[] args) {
        // Scanner object to read input from the console.
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        // Continue reading numbers until there are no more numbers to read.
        while (scan.hasNextLong()) {
            // Read a long integer from the input.
            long in = scan.nextLong();

            // Check if the read number is a semi-perfect number.
            if (isSemiPerfect(in)) {
                // If it is semi-perfect, print the number.
                System.out.println(in);
            }
        }

    }

    // Method to check if a number is semi-perfect.
    public static boolean isSemiPerfect(long number) {
        // Calculate the sum of digits of the number.
        long sum = sum(number);

        // Keep reducing the number by summing its digits until it's a single digit.
        while (sum > 9) {
            sum = sum(sum);
        }

        // Check if the final single-digit sum is 9.
        return sum == 9;
    }

    // Method to calculate the sum of digits of a number.
    public static long sum(long number) {
        long result = 0; // Initialize sum result to 0.

        // Loop through each digit of the number.
        while (number != 0) {
            // Add the last digit to the result.
            result += number % 10; // number % 10 extracts the last digit.
            number /= 10; // Remove the last digit from the number.
        }

        // Return the sum of the digits.
        return result;
    }
}
