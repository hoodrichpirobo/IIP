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

 public class Test3{

    public static void main(String[] args){
        Scanner kbd=new Scanner(System.in);
        System.out.println("Reading hour from keyboard.");
        System.out.print("   -> Input the hour (between 0 and 23): ");
        int h = kbd.nextInt();
        System.out.print("   -> Input the minutes (between 0 and 59): ");
        int m = kbd.nextInt();
        
        //1
        String hh = "" + h;
        //2
        String mm = "" + m;
        //3
        hh = "0" + h;
        mm = "0" + mm;
        hh = hh.substring( hh.length() - 2);
        mm = mm.substring( mm.length() - 2);
        
        System.out.println("Input hour: " + hh + ":" + mm); 
        
        long tMinTotal = System.currentTimeMillis() / (60 * 1000);
        
        int tMinCurrent = (int) (tMinTotal % (24 * 60));
        
        int hC = tMinCurrent / 60;
        int mC = tMinCurrent % 60;
        
        String hhC = "" + hC;
        String mmC = "" + mC;
        hhC = "0" + hhC;
        mmC = "0" + mmC;
        
        hhC = hhC.substring(hhC.length() - 2);
        mmC = mmC.substring(mmC.length() - 2);
        System.out.println("Current hour: " + hhC + ":" + mmC + "(UTC time)");
        
        int tMinInput = h * 60 + m;
        int dif = Math.abs (tMinInput - tMinCurrent);
        System.out.println("Difference in minutes between the two hours: " + dif + " (" + (dif/60) + "h., " + (dif%60) + " min. )");
     
    }    
 
}
