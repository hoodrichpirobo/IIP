package pract6;
import java.util.*;

/**
 * Calculating sin of x.
 *
 * @author Cux Prada
 * @version 2023-2023
 */
public class IIPMath
{
    private IIPMath(){
        
    }
    
    /** Calculate the sine of an angle x, in radins, *
     * with a maximum error epsilon
     * @param double x,
     * @param double epsilon, maximum error
     * @result double, sin of x
       */
     
    public static double sin(double x, double epsilon){
        x = reducFirstCirc(x);
        
        int k = 0;
        double term = x, sum = term, prev;
        
        while (Math.abs(term) >= epsilon){
            k++;
            prev = term;
            term = -((x*x)/ (2*k*(2*k+1)))*prev;
            sum += term;
        }
        
        return sum;
    }
    
    /** Calculate the sine of an angle x, in radians, *
     * with a maximum error 1e-15
     * @param double x,
     * @result double, sin of x
       */
     
    public static double sin(double x){
         return sin(x,1e-15);
    }
     
    /** Return the reduction of the angle x to the first circumference
     * Precondition: x is in radians. */
     
     private static double reducFirstCirc(double x){
         
         double res = x%(2*Math.PI);
         
         return res;         
     }
}
