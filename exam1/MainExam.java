package exam1;

import java.util.Scanner;
import others.TimeInstant;
/**
 * MainExam class: program class that uses the TimeInstant class from the "others" package, 
 * identical to your TimeInstant class with the correct multiplyBy2() method.  
 * 
 * @author IIP
 * @version Academic Year 2023-24
 */
public class MainExam {
    
    /** No objects of this class are created. */
    private MainExam() { }
    
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Reading hour from keyboard.");
        System.out.print("   -> Input the hour (between 0 and 23): ");
        int h = kbd.nextInt();
        System.out.print("   -> Input the minutes (between 0 and 59): ");
        int m = kbd.nextInt();
        // Once both data have been read from keyboard and assuming they are correct:
        // a) Create a TimeInstant ti with these data. 
        TimeInstant ti = new TimeInstant(h, m); /* TO COMPLETE */
        
        // b) Show the TimeInstant ti on Screen (with format "hh:mm")        
        /* TO COMPLETE */
        
        System.out.println(ti.toString());
        
        // c) Update the hours and minutes of ti multiplying by 2,
        //      using the multiplyBy2 method
        /* TO COMPLETE */
        
        ti.multiplyBy2();
        
        // d) Show the TimeInstant ti on Screen again (with format "hh:mm")        
        /* TO COMPLETE */
        
        System.out.println(ti.toString());
    }
}
