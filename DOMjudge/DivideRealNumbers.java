import java.util.*;

public class DivideRealNumbers {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        while(scan.hasNext()){
            double a = scan.nextDouble();
            double b = scan.nextDouble();
            String str = "";
            if (a==0 && b==0){
                str = "Not a Number";
            } else if (a>0 && b==0){
                str = "Infinite";
            } else if (a<0 && b==0){
                str = "-Infinite";
            } else {
                double div = a / b;
                str = String.format("%.7f", div);
            }        
            
            System.out.println(String.format("%.7f", a) + " / " + String.format("%.7f", b) + " = " + str);
        }
    }
    
}
