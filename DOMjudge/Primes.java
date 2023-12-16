import java.util.*;

public class Primes {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        int NumberOfPrimes = 0;
        
        // Reads integers from the input until there are no more
        while(scan.hasNextInt()){
            int in = scan.nextInt();
            // Increment count if the number is prime
            if(isPrimeNumber(in)){
                NumberOfPrimes++;
            }
        }
        
        // Output the count of prime numbers found
        if(NumberOfPrimes==0){
            System.out.println("No prime numbers were found!");
        }else if(NumberOfPrimes==1){
            System.out.println("Only one prime number was found!");
        }else{
            System.out.println(NumberOfPrimes + " prime numbers were found!");                
        }        
        
    }
    
    /**
     * Checks if a number is prime.
     * 
     * @param number The number to check.
     * @return true if the number is prime, false otherwise.
     */
    public static boolean isPrimeNumber(int number){
        // Numbers less than 2 are not prime
        if(number < 2) return false;
        // 2 is a prime number
        if(number == 2) return true;
        // Even numbers greater than 2 are not prime
        if(number % 2 == 0) return false;
        // Check for factors up to the square root of the number
        for(int i = 3; i * i <= number; i += 2){
            // If number is divisible by i, then it's not prime
            if(number % i == 0){
                return false;
            }
        }
        // If no factors were found, number is prime
        return true;
    }
}
