import java.util.*;

public class Reverser {
    /**
     * Reverses a given number.
     *
     * @param number The number to be reversed.
     * @return The reversed number.
     */
    public static long reverseNumber(long number) {
        long reversed = 0; // This will store the reversed number.

        // Loop until the number is reduced to 0
        while (number != 0) {
            long lastDigit = number % 10; // Extracts the last digit of the number
            reversed = reversed * 10 + lastDigit; // Shifts the digits of the reversed number left and adds the last digit
            number /= 10; // Removes the last digit from the original number
        }

        return reversed; // Returns the reversed number
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        
        // Loop to continuously read and reverse numbers until the input is exhausted
        while(scan.hasNext()){
            long originalNumber = scan.nextLong(); // Reads the next number
            long reversedNumber = reverseNumber(originalNumber); // Reverses the number

            System.out.println(reversedNumber); // Prints the reversed number            
        }
    }
}
