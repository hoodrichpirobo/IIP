import java.util.*;

public class Reverser{
    public static long reverseNumber(long number) {
        long reversed = 0;

        while (number != 0) {
            long lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number /= 10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        
        while(scan.hasNext()){
            long originalNumber = scan.nextLong();
            long reversedNumber = reverseNumber(originalNumber);

            System.out.println(reversedNumber);            
        }
    }
}
