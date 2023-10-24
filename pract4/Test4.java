package pract4;
import java.util.Scanner;
/**
 *  Class Test4. Test of TimeInstat.
 *  @author IIP 
 *  @version Academic Year 2023-24
 */
public class Test4 {
    
    /** No objects of this class are created. */
    private Test4() { }
    
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Reading hour from keyboard.");
        System.out.print("   -> Input the hour (between 0 and 23): ");
        int h = kbd.nextInt();
        System.out.print("   -> Input the minutes (between 0 and 59): ");
        int m = kbd.nextInt();
            
       // TO COMPLETE
 
       System.out.println("Input hour: " /* TO COMPLETE */);
       System.out.println("Current hour: " /* TO COMPLETE */);
       System.out.println("Difference in minutes between the two hours: " 
                        /* TO COMPLETE */  );
       System.out.println("Is previous input hour to current hour? " 
                        /* TO COMPLETE */  );
    }    
 
}   
