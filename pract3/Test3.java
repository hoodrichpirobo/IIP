package pract3;

import java.util.Scanner;
/**
 *  Class Test3.
 *  A first class with data input from keyboard, 
 *  and use of operations with int, long, Math, and String.
 *  It has three compilation errors.
 *  @author Cux Prada 
 *  @version Academic Year 2023-24
 */


public class Test3 {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Reading hour from keyboard.");
        System.out.print("   -> Input the hour (between 0 and 23): ");
        int h = kbd.nextInt();
        System.out.print("   -> Input the minutes (between 0 and 59): ");
        int m = kbd.nextInt();

        // Format hour and minutes as per the logic provided
        String hh = h / 10 + "" + h % 10;
        String mm = m / 10 + "" + m % 10;

        System.out.println("Input hour: " + hh + ":" + mm);

        long tMinTotal = System.currentTimeMillis() / (60 * 1000);

        int tMinCurrent = (int) (tMinTotal % (24 * 60));

        int hC = tMinCurrent / 60;
        int mC = tMinCurrent % 60;

        String hhC = hC / 10 + "" + hC % 10;
        String mmC = mC / 10 + "" + mC % 10;

        System.out.println("Current hour: " + hhC + ":" + mmC + " (UTC time)");

        int tMinInput = h * 60 + m;
        int dif = Math.abs(tMinInput - tMinCurrent);
        System.out.println("Difference in minutes between the two hours: " + dif + " (" + (dif / 60) + "h., " + (dif % 60) + " min. )");

        // Check if input time is before current time
        boolean isBefore = tMinInput < tMinCurrent;
        System.out.println("Is previous hour " + hh + ":" + mm + " to hour "+ hhC + ":" + mmC + "? " + isBefore);

        // Check if the "hh:mm" format is a palindrome
        String timeString = hh + ":" + mm;
        boolean isPalindrome = new StringBuilder(timeString).reverse().toString().equals(timeString);
        System.out.println("Is palindrome the hour " + timeString + "? " + isPalindrome);
    }
}

