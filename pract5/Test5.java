package pract5;

import java.util.Scanner;
/**
 * Class {@code Test5}: allows you to test part of the functionality 
 * of the {@link DateTime} class, in whose main the following actions are to be performed :<br>
 * a. Ask the user to enter from the keyboard the values of hours, minutes, 
 *     day, month, and year.
 * b. If the data does not correspond to a correct time and date, 
 *     display a message on the screen.
 * c. If they are correct:
 *    - Create a DateTime dT with this data.
 *    - Create a DateTime now with the current UTC date and time.
 *    - Compare dT and now.
 *    - Display on screen if dT is earlier, later or equal to now.
 *    
 * @author IIP 
 * @version Academic year 2023-24
 */
public class Test5 {
    /** No objects of this class are allowed. */
    private Test5() { }
    
    /**
     * main method.
     * @param args array of {@link String}.
     */
    public static void main(String[] args) {
        // a. Ask the user to enter from the keyboard the values of hours, minutes, day, month and year. 
        Scanner kbd = new Scanner(System.in);
        System.out.print("Hours? ");
        int hours = kbd.nextInt();
        System.out.print("Minutes? ");
        int minutes = kbd.nextInt();
        System.out.print("Day? ");
        int day = kbd.nextInt();
        System.out.print("Month? ");
        int month = kbd.nextInt();
        System.out.print("Year? ");
        int year = kbd.nextInt();
        
        // COMPLETE
        // b. If the data do not correspond to a correct time and date, 
        // display a message on the screen.
        
        if (hours > 24 || hours < 0 || month > 12 || month < 0 || year < 0 || day < 0 || day > 31){
            System.out.println("Error");
        }
        
        // c. If they are correct:
        // - Create a DateTime dT with this data.
        // - Create a DateTime now with the current UTC date and time.
        // - Compare dT and now.
        // - Display whether dT is earlier, later or equal to now.
        
        DateTime dT = new DateTime(hours, minutes, day, month, year);
        DateTime now = new DateTime(12, 52, 21, 11, 2023);
        int res = dT.compareTo(now);
        
        if(res == 0){
            System.out.println("Now");
        } else if(res < 0){
            System.out.println("Earlier");
        } else {
            System.out.println("Later");
        }
    }
}
