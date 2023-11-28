package pract6;
import graph2D.Graph2D; //Import the Graph2D class (from the graph2D package)
import java.awt.Color; //If you want to change the colour of the elements
import java.util.*;


/**
 * This main tests the methods compared to the ones already implemented in Java.
 *
 * @author Cux Prada
 * @version 2023-2024
 */
public class TestIIPMath
{
    /** Write to standard output, line by line, the values of
     * Math.sin(x) and IIPMath.sin(x), for x from 0 to 20 radians.
     * Display the difference in absolute value between these values. */
     
     public static void table(){
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("  x           Math.sin(x)             IIPMath.sin(x)             |dif|");
        System.out.println("-----------------------------------------------------------------------------");
        double xMin = 0;
        double xMax = 20;
        
        double delta = 1.0;
        for (double x = xMin; x <= xMax; x = x + delta) {
            double y = IIPMath.sin(x) ; // y is the value of the function
            double yMath = Math.sin(x);
            double dif = Math.abs(y - yMath);
            System.out.printf(Locale.US, "%4.1f %23.15f %23.15f %23.15f\n", x, yMath, y, dif);   
        }
     }
     
     /** Gets the graph of the function IIPMath.sin(x) on the interval [0, 15] */
    public static void graph() {
        double xMin = -20;
        double xMax = 20;
        double yMin = -2;
        double yMax = 2;
        // Create the drawing space with the desired dimensions.
        Graph2D gd = new Graph2D(xMin, xMax, yMin, yMax, 800, 250);
        gd.setTitle("IIPMath.sin");
        
        // Calculate the increment at each step of x (delta).
        double delta = (xMax - xMin) / Graph2D.INI_WIDTH; 
        for (double x = xMin; x <= xMax; x = x + delta) {
            double y = IIPMath.sin(x) ; 
            gd.drawPoint(x, y, Color.BLUE, 2); // plot (x, y) in blue colour
                                               //  and thickness 2
        }
    }
}
